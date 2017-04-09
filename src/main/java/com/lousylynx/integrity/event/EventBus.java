package com.lousylynx.integrity.event;

import com.lousylynx.integrity.api.event.IEvent;
import com.lousylynx.integrity.api.event.IEventBus;
import com.lousylynx.integrity.api.event.IListener;
import com.lousylynx.integrity.api.event.IntegrationEvent;
import com.lousylynx.integrity.core.ILogger;
import lombok.Getter;
import org.apache.logging.log4j.Level;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class EventBus extends IEventBus {

    @Getter
    private List<IListener> eventClasses = new ArrayList<>();

    @Override
    public void register(IListener events) {
        if (!eventClasses.contains(events))
            eventClasses.add(events);
    }

    @Override
    public void handle(IEvent event) {
        Map<IListener, List<Method>> methods = getValidMethods(event);

        for (IListener listener : methods.keySet()) {
            List<Method> ms = methods.get(listener);

            ms.forEach(m -> {
                try {
                    m.invoke(ms, event);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    ILogger.log(Level.WARN, "There was an issue invoking an event");
                    ILogger.log(Level.WARN, e, e.getMessage());
                }
            });
        }
    }

    private Map<IListener, List<Method>> getValidMethods(IEvent event) {
        Map<IListener, List<Method>> output = new HashMap<>();

        for (IListener listener : eventClasses) {
            for (Method m : listener.getClass().getMethods()) {
                if (m.isAnnotationPresent(IntegrationEvent.class)) {
                    if (m.getParameterCount() == 1 && m.getParameters()[0].getClass().isInstance(event.getClass())) {
                        if (output.containsKey(listener)) {
                            List<Method> methods = output.get(listener);
                            methods.add(m);

                            output.put(listener, methods);
                        } else {
                            output.put(listener, Collections.singletonList(m));
                        }
                    }
                }
            }
        }

        return output;
    }
}

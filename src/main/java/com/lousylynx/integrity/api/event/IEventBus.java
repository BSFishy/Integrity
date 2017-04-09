package com.lousylynx.integrity.api.event;

public abstract class IEventBus {

    public abstract void register(IListener events);

    public abstract void handle(IEvent event);
}

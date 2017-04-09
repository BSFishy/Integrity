package com.lousylynx.integrity.api;

import com.lousylynx.integrity.api.event.IEventBus;
import lombok.Data;

@Data
public abstract class IAPI {

    public final IEventBus EVENTBUS;

    public abstract void loadIntegrations();

    //public abstract void loadIntegration();
}

package com.lousylynx.integrity.api;

import com.lousylynx.integrity.api.event.IEventBus;
import com.lousylynx.integrity.api.integration.IIntegrationHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class IAPI {

    public IEventBus eventBus;
    public IIntegrationHandler integrationHandler;

    public abstract void loadIntegrations();

    //public abstract void loadIntegration();
}

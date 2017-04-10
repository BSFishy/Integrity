package com.lousylynx.integrity.core;

import com.lousylynx.integrity.api.IAPI;
import com.lousylynx.integrity.event.EventBus;
import com.lousylynx.integrity.integrations.IntegrationHandler;

public class IntegrityAPI extends IAPI {

    public IntegrityAPI() {
        super(new EventBus(), new IntegrationHandler());
    }

    @Override
    public void loadIntegrations() {
        integrationHandler.initialize();
    }
}

package com.lousylynx.integrity.core;

import com.lousylynx.integrity.api.IAPI;
import com.lousylynx.integrity.event.EventBus;

public class IntegrityAPI extends IAPI {

    public IntegrityAPI() {
        super(new EventBus());
    }

    @Override
    public void loadIntegrations() {

    }
}

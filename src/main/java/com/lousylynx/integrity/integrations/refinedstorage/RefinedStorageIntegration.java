package com.lousylynx.integrity.integrations.refinedstorage;

import com.lousylynx.integrity.api.integration.Integration;
import com.lousylynx.integrity.api.integration.ModIntegration;
import com.lousylynx.integrity.integrations.providers.RefinedStorageProvider;

import java.util.ArrayList;
import java.util.List;

public class RefinedStorageIntegration extends ModIntegration {
    public RefinedStorageIntegration() {
        super(new RefinedStorageProvider());
    }

    @Override
    public List<Integration> getIntegrations() {
        List<Integration> integrations = new ArrayList<>();

        return integrations;
    }
}

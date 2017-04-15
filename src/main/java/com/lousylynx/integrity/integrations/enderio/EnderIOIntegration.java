package com.lousylynx.integrity.integrations.enderio;

import com.lousylynx.integrity.api.integration.ModIntegration;
import com.lousylynx.integrity.integrations.enderio.conduits.ConduitIntegration;
import com.lousylynx.integrity.integrations.providers.EnderIOProvider;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EnderIOIntegration extends ModIntegration {

    public EnderIOIntegration() {
        super(new EnderIOProvider());
    }

    @Override
    public void setup() {
        integrations.add(new ConduitIntegration());
        integrations.add(new ModObjectIntegration());
    }
}

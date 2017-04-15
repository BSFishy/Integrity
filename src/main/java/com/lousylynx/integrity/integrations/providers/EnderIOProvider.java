package com.lousylynx.integrity.integrations.providers;

import com.lousylynx.integrity.api.integration.IntegrationProvider;
import crazypants.enderio.conduit.IConduit;
import crazypants.enderio.conduit.geom.Offset;
import crazypants.enderio.conduit.registry.ConduitRegistry;

public class EnderIOProvider extends IntegrationProvider {
    @Override
    public String getModid() {
        return "EnderIO";
    }

    public void registerConduit(Class<? extends IConduit> sup, Class<? extends IConduit> conduit) {
        ConduitRegistry.register(createConduitInfo(sup, conduit));
    }

    private ConduitRegistry.ConduitInfo createConduitInfo(Class<? extends IConduit> sup, Class<? extends IConduit> conduit) {
        ConduitRegistry.ConduitInfo info = new ConduitRegistry.ConduitInfo(sup, Offset.first(), Offset.first(),
                Offset.first(), Offset.first());
        info.addMember(conduit);
        return info;
    }
}

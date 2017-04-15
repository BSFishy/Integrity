package com.lousylynx.integrity.integrations.enderio.conduits;

import com.lousylynx.integrity.api.integration.Integration;
import com.lousylynx.integrity.integrations.enderio.ModObject;
import com.lousylynx.integrity.integrations.enderio.conduits.power.IInfinitePowerConduit;
import com.lousylynx.integrity.integrations.enderio.conduits.power.InfinitePowerConduit;
import com.lousylynx.integrity.integrations.providers.EnderIOProvider;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ConduitIntegration extends Integration {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        if (getConfigOption("conduits", "enabled", true, "Set this to true if you want Integrity conduits to be enabled at all").getBoolean()) {
            ModObject.preInit(event);

            if (getConfigOption("conduits", "infinitePower", true, "If this is enabled, an EnderIO conduit will be added that transfers infinite RF per tick").getBoolean()) {
                if (hasProvider()) {
                    // ILogger.info("Registering infinite power conduit");
                    ((EnderIOProvider) getProvider()).registerConduit(IInfinitePowerConduit.class, InfinitePowerConduit.class);
                }

                InfinitePowerConduit.initIcons();
            }
        }
    }

    @Override
    public void init(FMLInitializationEvent event) {
        if (getConfigOption("conduits", "enabled", true, "Set this to true if you want Integrity conduits to be enabled at all").getBoolean()) {
            ModObject.init(event);
        }
    }
}

package com.lousylynx.integrity.integrations;

import com.lousylynx.integrity.api.integration.IIntegrationHandler;
import com.lousylynx.integrity.integrations.enderio.EnderIOIntegration;
import com.lousylynx.integrity.integrations.refinedstorage.RefinedStorageIntegration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class IntegrationHandler extends IIntegrationHandler {

    private boolean initialized = false;

    @Override
    public void initialize() {
        if (initialized)
            return;

        integrations.add(new RefinedStorageIntegration());
        integrations.add(new EnderIOIntegration());

        integrations.forEach(mi -> {
            mi.setup();

            mi.getIntegrations().forEach(i -> {
                if (mi.hasProvider())
                    i.setup(mi.getModid(), mi.getProvider());
                else
                    i.setup(mi.getModid());
            });
        });

        initialized = true;
    }

    @Override
    public void preInitIntegrations(FMLPreInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> {
                i.preInit(e);

                if (i.getConfig().hasChanged())
                    i.getConfig().save();
            });
        });
    }

    @Override
    public void initIntegrations(FMLInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> {
                i.init(e);

                if (i.getConfig().hasChanged())
                    i.getConfig().save();
            });
        });
    }

    @Override
    public void postInitIntegrations(FMLPostInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> {
                i.postInit(e);

                if (i.getConfig().hasChanged())
                    i.getConfig().save();
            });
        });
    }
}

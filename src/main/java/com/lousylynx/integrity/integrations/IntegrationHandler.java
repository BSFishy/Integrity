package com.lousylynx.integrity.integrations;

import com.lousylynx.integrity.api.integration.IIntegrationHandler;
import com.lousylynx.integrity.integrations.refinedstorage.RefinedStorageIntegration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class IntegrationHandler extends IIntegrationHandler {

    @Override
    public void initialize() {
        integrations.add(new RefinedStorageIntegration());

        integrations.forEach(mi -> mi.getIntegrations().forEach(i -> i.setup(mi.getModid())));
    }

    @Override
    public void preInitIntegrations(FMLPreInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> i.preInit(e));
        });
    }

    @Override
    public void initIntegrations(FMLInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> i.init(e));
        });
    }

    @Override
    public void postInitIntegrations(FMLPostInitializationEvent e) {
        integrations.forEach(mi -> {
            if (mi.isLoaded()) mi.getIntegrations().forEach(i -> i.postInit(e));
        });
    }
}

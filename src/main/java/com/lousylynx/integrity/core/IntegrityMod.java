package com.lousylynx.integrity.core;

import com.lousylynx.integrity.api.IAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = IntegrityMod.modid, version = IntegrityMod.version, dependencies = IntegrityMod.dependencies)
public class IntegrityMod {

    public static final String modid = "integrity";
    public static final String version = "0.1.0";
    public static final String dependencies = "required-after:Forge@[12.18.3.2272,);after:EnderIO;after:refinedstorage";

    public static IAPI API = new IntegrityAPI();

    @Instance
    public static IntegrityMod INSTANCE;

    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        IntegrityConfigHandler.setup(e);
        IntegrityConfigHandler.setupIntegrityConfig();

        // Setup the integrations
        API.loadIntegrations();

        // Load the preInit event for all of the integrations
        API.integrationHandler.preInitIntegrations(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        // Load the init event for all of the integrations
        API.integrationHandler.initIntegrations(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        // Load the postInit event for all of the integrations
        API.integrationHandler.postInitIntegrations(e);
    }
}

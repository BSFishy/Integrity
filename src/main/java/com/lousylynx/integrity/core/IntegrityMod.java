package com.lousylynx.integrity.core;

import com.lousylynx.integrity.api.IAPI;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = IntegrityMod.modid, dependencies = IntegrityMod.dependencies)
public class IntegrityMod {

    public static final String modid = "integrity";
    public static final String dependencies = "required-after:Forge@[12.18.3.2272,);";

    public static final IAPI API = new IntegrityAPI();

    @Instance
    public static IntegrityMod INSTANCE;


    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {

    }

    @EventHandler
    public void init(FMLInitializationEvent e) {

    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {

    }
}

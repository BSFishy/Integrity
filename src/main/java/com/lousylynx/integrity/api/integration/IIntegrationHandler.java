package com.lousylynx.integrity.api.integration;

import lombok.Getter;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;
import java.util.List;

public abstract class IIntegrationHandler {

    @Getter
    protected static List<ModIntegration> integrations = new ArrayList<>();

    public abstract void initialize();

    public abstract void preInitIntegrations(FMLPreInitializationEvent e);

    public abstract void initIntegrations(FMLInitializationEvent e);

    public abstract void postInitIntegrations(FMLPostInitializationEvent e);
}

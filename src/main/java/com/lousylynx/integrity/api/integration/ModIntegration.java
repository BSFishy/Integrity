package com.lousylynx.integrity.api.integration;

import net.minecraftforge.fml.common.Loader;

import java.util.List;

public abstract class ModIntegration {

    private String firstModid = null;
    private String secondModid = null;

    public ModIntegration(String modid) {
        this.firstModid = modid;
    }

    public ModIntegration(String firstModid, String secondModid) {
        this.firstModid = firstModid;
        this.secondModid = secondModid;
    }

    public final boolean isLoaded() {
        return secondModid != null ? Loader.isModLoaded(firstModid) && Loader.isModLoaded(secondModid) : Loader.isModLoaded(firstModid);
    }

    public abstract List<Integration> getIntegrations();
}

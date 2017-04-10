package com.lousylynx.integrity.api.integration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

@RequiredArgsConstructor
@Data
public abstract class ModIntegration {

    private final String modid;
    private IntegrationProvider provider = null;

    public ModIntegration(IntegrationProvider provider) {
        modid = provider.getModid();
        this.provider = provider;
    }

    public final boolean isLoaded() {
        return provider != null ? Loader.isModLoaded(modid) && Loader.isModLoaded(provider.getModid()) : Loader.isModLoaded(modid);
    }

    public abstract List<Integration> getIntegrations();
}

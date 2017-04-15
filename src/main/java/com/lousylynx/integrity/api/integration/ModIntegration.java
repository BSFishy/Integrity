package com.lousylynx.integrity.api.integration;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.minecraftforge.fml.common.Loader;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public abstract class ModIntegration {

    private final String modid;
    private IntegrationProvider provider = null;
    @Getter
    protected List<Integration> integrations = new ArrayList<>();

    public ModIntegration(IntegrationProvider provider) {
        this.modid = provider.getModid();
        this.provider = provider;
    }

    public final boolean isLoaded() {
        return provider != null ? Loader.isModLoaded(modid) && Loader.isModLoaded(provider.getModid()) : Loader.isModLoaded(modid);
    }

    public boolean hasProvider() {
        return provider != null;
    }

    public abstract void setup();
}

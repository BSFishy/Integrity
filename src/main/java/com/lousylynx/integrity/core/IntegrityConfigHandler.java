package com.lousylynx.integrity.core;

import lombok.Getter;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Level;

import java.io.File;
import java.io.IOException;

public class IntegrityConfigHandler {

    @Getter
    private static File configFolder;
    @Getter
    private static Configuration integrityConfig;

    public static void setup(FMLPreInitializationEvent e) {
        IntegrityConfigHandler.configFolder = new File(e.getModConfigurationDirectory(), "integrity");

        if (!configFolder.exists())
            if (configFolder.mkdirs())
                ILogger.info("Successfully created the Integrity config folder");
            else
                ILogger.warn("There was an issue creating the Integrity config folder");
    }

    public static Configuration getConfig(String name) {
        File config = new File(configFolder, name + ".cfg");

        if (!config.exists())
            try {
                if (config.createNewFile())
                    ILogger.info("Successfully created the config file: " + name + ".cfg");
                else
                    ILogger.warn("There was an issue creating the config file for: " + name + ".cfg");
            } catch (IOException e) {
                ILogger.warn("There was an issue creating the config file for: " + name + ".cfg");
                ILogger.log(Level.WARN, e, e.getMessage());
            }

        return new Configuration(config);
    }

    public static Configuration getModConfig(String modid, String name) {
        File folder = new File(configFolder, modid);
        if (!folder.exists())
            if (folder.mkdir())
                ILogger.info("Successfully created the " + modid + " config folder");
            else
                ILogger.warn("There was an issue creating the " + modid + " config folder");

        File config = new File(folder, name + ".cfg");
        if (!config.exists())
            try {
                if (config.createNewFile())
                    ILogger.info("Successfully created the config file: " + name + ".cfg");
                else
                    ILogger.warn("There was an issue creating the config file for: " + name + ".cfg");
            } catch (IOException e) {
                ILogger.warn("There was an issue creating the config file for: " + name + ".cfg");
                ILogger.log(Level.WARN, e, e.getMessage());
            }

        return new Configuration(config);
    }

    public static void setupIntegrityConfig() {
        integrityConfig = getConfig("Integrity");
    }
}

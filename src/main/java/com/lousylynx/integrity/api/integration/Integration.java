package com.lousylynx.integrity.api.integration;

import com.lousylynx.integrity.core.IntegrityConfigHandler;
import lombok.Getter;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.regex.Pattern;

public abstract class Integration {

    @Getter
    private String modid;
    @Getter
    private IntegrationProvider provider;
    private Configuration inModFolderConfig;
    private Configuration notInModFolderConfig;

    public void setup(String modid) {
        setup(modid, provider);
    }

    public void setup(String modid, IntegrationProvider provider) {
        this.modid = modid;
        this.provider = provider;

        this.inModFolderConfig = IntegrityConfigHandler.getModConfig(getConfigFolderName(), getConfigFileName());
        this.notInModFolderConfig = IntegrityConfigHandler.getConfig(getConfigFileName());
    }

    public String getConfigFileName() {
        return modid;
    }

    public String getConfigFolderName() {
        return modid;
    }

    public boolean hasProvider() {
        return provider != null;
    }

    public void preInit(FMLPreInitializationEvent e) {
    }

    public void init(FMLInitializationEvent e) {
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    public Configuration getConfig() {
        return getConfig(true);
    }

    public Configuration getConfig(boolean inModFolder) {
        return inModFolder ? inModFolderConfig : notInModFolderConfig;
    }

    protected Property getConfigOption(String category, String key, boolean defaultValue) {
        return getConfigOption(category, key, defaultValue, true);
    }

    protected Property getConfigOption(String category, String key, boolean defaultValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue);
    }

    protected Property getConfigOption(String category, String key, boolean defaultValue, String comment) {
        return getConfigOption(category, key, defaultValue, comment, true);
    }

    protected Property getConfigOption(String category, String key, boolean defaultValue, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues) {
        return getConfigOption(category, key, defaultValues, true);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues, String comment) {
        return getConfigOption(category, key, defaultValues, comment, true);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength) {
        return getConfigOption(category, key, defaultValues, comment, isListLengthFixed, maxListLength, true);
    }

    protected Property getConfigOption(String category, String key, boolean[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, isListLengthFixed, maxListLength);
    }

    protected Property getConfigOption(String category, String key, int defaultValue) {
        return getConfigOption(category, key, defaultValue, true);
    }

    protected Property getConfigOption(String category, String key, int defaultValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue);
    }

    protected Property getConfigOption(String category, String key, int defaultValue, String comment) {
        return getConfigOption(category, key, defaultValue, comment, true);
    }

    protected Property getConfigOption(String category, String key, int defaultValue, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment);
    }

    protected Property getConfigOption(String category, String key, int defaultValue, String comment, int minValue, int maxValue) {
        return getConfigOption(category, key, defaultValue, comment, minValue, maxValue, true);
    }

    protected Property getConfigOption(String category, String key, int defaultValue, String comment, int minValue, int maxValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment, minValue, maxValue);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues) {
        return getConfigOption(category, key, defaultValues, true);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment) {
        return getConfigOption(category, key, defaultValues, comment, true);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue) {
        return getConfigOption(category, key, defaultValues, comment, minValue, maxValue, true);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, minValue, maxValue);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue, boolean isListLengthFixed, int maxListLength) {
        return getConfigOption(category, key, defaultValues, comment, minValue, maxValue, isListLengthFixed, maxListLength, true);
    }

    protected Property getConfigOption(String category, String key, int[] defaultValues, String comment, int minValue, int maxValue, boolean isListLengthFixed, int maxListLength, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, minValue, maxValue, isListLengthFixed, maxListLength);
    }

    protected Property getConfigOption(String category, String key, double defaultValue) {
        return getConfigOption(category, key, defaultValue, true);
    }

    protected Property getConfigOption(String category, String key, double defaultValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue);
    }

    protected Property getConfigOption(String category, String key, double defaultValue, String comment) {
        return getConfigOption(category, key, defaultValue, comment, true);
    }

    protected Property getConfigOption(String category, String key, double defaultValue, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment);
    }

    protected Property getConfigOption(String category, String key, double defaultValue, String comment, double minValue, double maxValue) {
        return getConfigOption(category, key, defaultValue, comment, minValue, maxValue, true);
    }

    protected Property getConfigOption(String category, String key, double defaultValue, String comment, double minValue, double maxValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment, minValue, maxValue);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues) {
        return getConfigOption(category, key, defaultValues, true);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment) {
        return getConfigOption(category, key, defaultValues, comment, true);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue) {
        return getConfigOption(category, key, defaultValues, comment, minValue, maxValue, true);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, minValue, maxValue);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue, boolean isListLengthFixed, int maxListLength) {
        return getConfigOption(category, key, defaultValues, comment, minValue, maxValue, isListLengthFixed, maxListLength, true);
    }

    protected Property getConfigOption(String category, String key, double[] defaultValues, String comment, double minValue, double maxValue, boolean isListLengthFixed, int maxListLength, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, minValue, maxValue, isListLengthFixed, maxListLength);
    }

    protected Property getConfigOption(String category, String key, String defaultValue) {
        return getConfigOption(category, key, defaultValue, true);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment) {
        return getConfigOption(category, key, defaultValue, comment, true);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, Pattern validationPattern) {
        return getConfigOption(category, key, defaultValue, comment, validationPattern, true);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, Pattern validationPattern, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment, validationPattern);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, String[] validValues) {
        return getConfigOption(category, key, defaultValue, comment, validValues, true);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, String[] validValues, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment, validValues);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues) {
        return getConfigOption(category, key, defaultValues, true);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment) {
        return getConfigOption(category, key, defaultValues, comment, true);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, Pattern validationPattern) {
        return getConfigOption(category, key, defaultValues, comment, validationPattern, true);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, Pattern validationPattern, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, validationPattern);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength, Pattern validationPattern) {
        return getConfigOption(category, key, defaultValues, comment, isListLengthFixed, maxListLength, validationPattern, true);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, boolean isListLengthFixed, int maxListLength, Pattern validationPattern, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, isListLengthFixed, maxListLength, validationPattern);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, Property.Type type) {
        return getConfigOption(category, key, defaultValue, comment, type, true);
    }

    protected Property getConfigOption(String category, String key, String defaultValue, String comment, Property.Type type, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValue, comment, type);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, Property.Type type) {
        return getConfigOption(category, key, defaultValues, comment, type, true);
    }

    protected Property getConfigOption(String category, String key, String[] defaultValues, String comment, Property.Type type, boolean inModFolder) {
        Configuration config = getConfig(inModFolder);
        return config.get(category, key, defaultValues, comment, type);
    }
}

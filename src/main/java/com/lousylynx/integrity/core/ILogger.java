package com.lousylynx.integrity.core;

import net.minecraftforge.fml.common.FMLLog;
import org.apache.logging.log4j.Level;

public class ILogger {

    public static void log(Level level, String format, String... message) {
        FMLLog.log(level, "[Integrity] " + format, (Object[]) message);
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warn(String message) {
        log(Level.WARN, message);
    }

    public static void log(Level level, Throwable t, String message) {
        FMLLog.log(level, t, message);
    }
}

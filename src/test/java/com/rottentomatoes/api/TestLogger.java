package com.rottentomatoes.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class TestLogger {

     private static final Logger LOGGER = LoggerFactory.getLogger(TestLogger.class);

    /**
     * Load properties from a file
     *
     * @param props
     * @param propertyFile
     */
    public static void loadProperties(Properties props, File propertyFile) {
        InputStream is = null;
        try {
            is = new FileInputStream(propertyFile);
            props.load(is);
        } catch (Exception ex) {
            LOGGER.warn("Failed to load properties file", ex);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                    LOGGER.warn("Failed to close properties file", ex);
                }
            }
        }
    }

    /**
     * Save properties to a file
     *
     * @param props
     * @param propertyFile
     * @param headerText
     */
    public static void saveProperties(Properties props, File propertyFile, String headerText) {
        OutputStream out = null;

        try {
            out = new FileOutputStream(propertyFile);
            if (headerText != null && !headerText.isEmpty()) {
                props.store(out, headerText);
            }
        } catch (FileNotFoundException ex) {
            LOGGER.warn("Failed to find properties file", ex);
        } catch (IOException ex) {
            LOGGER.warn("Failed to read properties file", ex);
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException ex) {
                    LOGGER.warn("Failed to close properties file", ex);
                }
            }
        }
    }

}

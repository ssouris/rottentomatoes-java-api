/*
 * Copyright 2015 Stathis Souris
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.yetanotherdevblog.rottentomatoes.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Properties;

import static org.junit.Assert.fail;

public final class TestConstants {

    private final static Logger LOGGER = LoggerFactory.getLogger(TestConstants.class);

    private static Properties props = new Properties();
    private final static String PROP_FIlENAME = "testing.properties";

    static {
        if (props.isEmpty()) {
            File f = new File(PROP_FIlENAME);
            if (f.exists()) {
                LOGGER.info("Loading properties from '{}'", PROP_FIlENAME);
                TestLogger.loadProperties(props, f);
            } else {
                LOGGER.info("Property file '{}' not found, creating dummy file.", PROP_FIlENAME);

                props.setProperty("api.key", "INSERT_YOUR_KEY_HERE");

                TestLogger.saveProperties(props, f, "Properties file for tests");
                fail("Failed to get key information from properties file '" + PROP_FIlENAME + "'");
            }
        }
    }

    // Non-instantiable class
    private  TestConstants() { }

    public final static String DEFAULT_COUNTRY = "us";
    public final static Integer PAGE_LIMIT = 1;
    public final static Integer PAGE = 1;

    public final static Integer THE_LONGEST_RIDE_IMDB_ID = 2726560;
    public final static String THE_LONGEST_RIDE_DESCRIPTION = "The Longest Ride";

    public static final Integer TOY_STORY3_RT_ID = 770672122;
    public static final String TOY_STORY3_TITLE = "Toy Story 3";

    /**
     * Define api.key property in testing.properties
     */
    public static final String API_KEY = props.getProperty("api.key");
}


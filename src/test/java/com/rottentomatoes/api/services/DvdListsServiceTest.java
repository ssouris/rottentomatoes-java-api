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

package com.rottentomatoes.api.services;

import com.rottentomatoes.api.RottenTomatoes;
import com.rottentomatoes.api.TestConstants;
import com.rottentomatoes.api.entities.RTMovies;
import com.rottentomatoes.api.entities.RTMoviesPage;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class DvdListsServiceTest {


    private DvdListsService dvdListsService;

    @Before
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        rt.setApiKey(TestConstants.API_KEY);
        dvdListsService = rt.dvdListsService();
    }

    @Test
    public void topRentals() {
        RTMovies topRentals = dvdListsService.topRentals(TestConstants.PAGE_LIMIT, TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(topRentals.movies).isNotNull();
        Assertions.assertThat(topRentals.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

    @Test
    public void currentReleases() {
        RTMoviesPage currentReleases = dvdListsService.currentReleases(
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(currentReleases.movies).isNotNull();
        Assertions.assertThat(currentReleases.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

    @Test
    public void upcoming() {
        RTMoviesPage upcoming = dvdListsService.upcoming(
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(upcoming.movies).isNotNull();
        Assertions.assertThat(upcoming.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

    @Test
    public void newReleases() {
        RTMoviesPage newReleases = dvdListsService.newReleases(
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(newReleases.movies).isNotNull();
        Assertions.assertThat(newReleases.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

}

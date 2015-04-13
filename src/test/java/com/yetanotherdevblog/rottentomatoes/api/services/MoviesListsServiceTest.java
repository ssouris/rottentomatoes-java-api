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

package com.yetanotherdevblog.rottentomatoes.api.services;

import com.yetanotherdevblog.rottentomatoes.api.RottenTomatoes;
import com.yetanotherdevblog.rottentomatoes.api.TestConstants;
import com.yetanotherdevblog.rottentomatoes.api.entities.RTMoviesPage;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class MoviesListsServiceTest {

    private MoviesListsService moviesService;

    @Before
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        rt.setApiKey(TestConstants.API_KEY);
        moviesService = rt.moviesService();

    }


    @Test
    public void boxOffice() {
        RTMoviesPage movies = moviesService.boxOffice(TestConstants.PAGE_LIMIT, TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(movies.movies).isNotNull();
        Assertions.assertThat(movies.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

    @Test
    public void inTheaters() {
        RTMoviesPage inTheaters = moviesService.inTheaters(TestConstants.PAGE_LIMIT, TestConstants.PAGE, TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(inTheaters.movies).isNotNull();
        Assertions.assertThat(inTheaters.movies.size()).isEqualTo(1);
    }

    @Test
    public void openingMovies() {
        RTMoviesPage openingMovies = moviesService.openingMovies(TestConstants.PAGE_LIMIT, TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(openingMovies.movies).isNotNull();
        Assertions.assertThat(openingMovies.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

    @Test
    public void upcomingMovies() {
        RTMoviesPage upcomingMovies = moviesService.upcomingMovies(TestConstants.PAGE_LIMIT, TestConstants.PAGE, TestConstants.DEFAULT_COUNTRY);
        Assertions.assertThat(upcomingMovies.movies).isNotNull();
        Assertions.assertThat(upcomingMovies.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }

}

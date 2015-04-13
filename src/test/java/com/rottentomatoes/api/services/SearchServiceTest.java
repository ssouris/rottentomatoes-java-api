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
import com.rottentomatoes.api.entities.RTMoviesPage;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class SearchServiceTest {

    private SearchService searchService;

    @Before
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        rt.setApiKey(TestConstants.API_KEY);
        searchService = rt.searchService();
    }

    @Test
    public void moviesSearch() {
        RTMoviesPage moviesSearch = searchService.movies(
                "Fast",
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE);
        Assertions.assertThat(moviesSearch).isNotNull();
        Assertions.assertThat(moviesSearch.total).isNotNull();
        Assertions.assertThat(moviesSearch.movies).isNotNull();
        Assertions.assertThat(moviesSearch.movies.size()).isEqualTo(TestConstants.PAGE_LIMIT);
    }
}

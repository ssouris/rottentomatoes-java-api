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
import com.rottentomatoes.api.entities.*;
import com.rottentomatoes.api.enumerations.AliasType;
import com.rottentomatoes.api.enumerations.ReviewType;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieDetailedInfoServiceTest {

    private MovieDetailedInfoService movieDetailedInfoService;

    @Before
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        rt.setApiKey(TestConstants.API_KEY);
        movieDetailedInfoService = rt.detailedInfoService();
    }

    @Test
    public void movieInfo() {
        RTMovie moviesInfo = movieDetailedInfoService.info(TestConstants.TOY_STORY3_RT_ID);
        assertThat(moviesInfo.title).isEqualTo(TestConstants.TOY_STORY3_TITLE);
    }

    @Test
    public void castInfo() {
        RTCasts moviesInfo = movieDetailedInfoService.castInfo(TestConstants.TOY_STORY3_RT_ID);
        assertThat(moviesInfo.cast.get(0).id).isEqualTo("162655641");
        assertThat(moviesInfo.cast.get(0).name).isEqualTo("Tom Hanks");
        assertThat(moviesInfo.cast.get(0).characters.get(0)).isEqualTo("Woody");
    }

    @Test
    public void movieClips() {
        RTClips movieClips = movieDetailedInfoService.clips(TestConstants.TOY_STORY3_RT_ID);
        assertThat(movieClips.clips.get(0).title).isEqualTo("Toy Story 3");
    }

    @Test
    public void movieReviews() {
        RTReviewsPage movieReviews = movieDetailedInfoService.reviews(
                TestConstants.TOY_STORY3_RT_ID,
                ReviewType.all,
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        assertThat(movieReviews.reviews).isNotNull();

        movieReviews = movieDetailedInfoService.reviews(
                TestConstants.TOY_STORY3_RT_ID,
                ReviewType.top_critic,
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        assertThat(movieReviews.reviews).isNotNull();

        movieReviews = movieDetailedInfoService.reviews(
                TestConstants.TOY_STORY3_RT_ID,
                ReviewType.dvd,
                TestConstants.PAGE_LIMIT,
                TestConstants.PAGE,
                TestConstants.DEFAULT_COUNTRY);
        assertThat(movieReviews.reviews).isNotNull();
    }

    @Test
    public void moviesSimilar() {
        RTMovies moviesSimilar = movieDetailedInfoService.similar(
                TestConstants.TOY_STORY3_RT_ID,
                1);
        Assertions.assertThat(moviesSimilar).isNotNull();
        Assertions.assertThat(moviesSimilar.movies).isNotNull();
        Assertions.assertThat(moviesSimilar.movies.size()).isEqualTo(1);
    }

    @Test
    public void movieAlias() {
        RTMovie aliasMovie = movieDetailedInfoService.movieAlias(
                AliasType.IMDB,
                TestConstants.THE_LONGEST_RIDE_IMDB_ID);
        Assertions.assertThat(aliasMovie).isNotNull();
        Assertions.assertThat(aliasMovie.title).isNotNull();
        Assertions.assertThat(aliasMovie.title).isEqualTo(TestConstants.THE_LONGEST_RIDE_DESCRIPTION);
    }

}

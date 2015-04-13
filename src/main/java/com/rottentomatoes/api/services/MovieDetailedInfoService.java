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

import com.rottentomatoes.api.entities.*;
import com.rottentomatoes.api.enumerations.AliasType;
import com.rottentomatoes.api.enumerations.ReviewType;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface MovieDetailedInfoService {

    /**
     * Detailed information on a specific movie specified by Id.
     * You can use the movies search endpoint or peruse the lists of movies/dvds to get the urls to movies.
     *
     * @param id Movie ID. You can use the movies search endpoint or peruse the
     *           lists of movies/dvds to get the Movie ID
     * @return
     */
    @GET("/movies/{id}.json")
    RTMovie info(
            @Path("id") Integer id
    );

    /**
     * Pulls the complete movie cast for a movie
     *
     * @param id
     * @return
     */
    @GET("/movies/{id}/cast.json")
    RTCasts castInfo(
            @Path("id") Integer id
    );

    /**
     *
     * @param id
     * @return
     */
    @GET("/movies/{id}/clips.json")
    RTClips clips(
            @Path("id") Integer id
    );

    /**
     * Retrieves the reviews for a movie. Results are paginated if they go past the specified page limit
     *
     * @param id
     * @param review_type (required=false, default='top_critic')
     * @param page_limit (required=false, default=20) The number of reviews to show per page
     * @param page	(required=false, default=1)	The selected page of reviews
     * @param country (required=false, default='us') Provides localized data for the selected country
     *                (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/movies/{id}/reviews.json")
    RTReviewsPage reviews(
            @Path("id") Integer id,
            @Query("review_type") ReviewType review_type,
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );


    /**
     * Shows similar movies for a movie. The example below shows a movie similar to Toy Story 3
     *
     * @param id
     * @param limit	(required=false, default:5) Limit the number of similar movies to show
     * @return
     */
    @GET("/movies/{id}/similar.json")
    RTMovies similar(
            @Path("id") Integer id,
            @Query("limit") Integer limit
    );

    /**
     * Provides a movie lookup by an id from a different vendor. Only supports imdb lookup at this time
     *
     * WARNING - This feature is Beta quality. Accuracy of the lookup is not promised
     * If you see inaccuracies, please report them in the forums
     *
     * @param type (required=false) alias type you want to look up - only imdb is supported at this time
     * @param id (required=false) The id you want to look up
     */
    @GET("/movie_alias.json")
    RTMovie movieAlias(
            @Query("type") AliasType type,
            @Query("id") Integer id);

}

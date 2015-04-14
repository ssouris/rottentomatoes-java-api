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

package com.yetanotherdevblog.rottentomatoes.api.services.lists;

import com.yetanotherdevblog.rottentomatoes.api.entities.RTMovies;
import com.yetanotherdevblog.rottentomatoes.api.entities.RTMoviesPage;
import retrofit.http.GET;
import retrofit.http.Query;

public interface MoviesListsService {


    /**
     * Displays Top Box Office Earning Movies, Sorted by Most Recent Weekend Gross Ticket Sales
     *
     * @param limit (required=false, default=10) Limits the number of movies returned
     * @param country (required=false, default='us') Provides localized data for the selected
     *                  country (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/movies/box_office.json")
    RTMoviesPage boxOffice(
            @Query("limit") Integer limit,
            @Query("country") String country
    );

    /**
     * Retrieves movies currently in theaters
     *
     * @param page_limit (default: 30, required=false)	The amount of movie search results to show per page
     * @param page	(default: 1, required=false) The selected page of movie search results
     * @param country (required=false, default='us') Provides localized data for the selected
     *                  country (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/movies/in_theaters.json")
    RTMoviesPage inTheaters(
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );

    /**
     * Retrieves current opening movies
     *
     * @param limit (required=false, default=16) Limits the number of opening movies returned
     * @param country (required=false, default='us') Provides localized data for the selected country
     *                (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/movies/opening.json")
    RTMovies opening(
            @Query("limit") Integer limit,
            @Query("country") String country
    );

    /**
     * Retrieves upcoming movies. Results are paginated if they go past the specified page limit
     *
     * @param page_limit (required=false, default=16) The amount of upcoming movies to show per page
     * @param page (required=false, default=1) The selected page of upcoming movies
     * @param country (required=false, default='us') Provides localized data for the selected country
     *                (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/movies/upcoming.json")
    RTMoviesPage upcoming(
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );

}

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

public interface DvdListsService {

    /**
     * Retrieves the current top dvd rentals
     *
     * @param limit	(required=false, default=10) Limits the number of top rentals returned
     * @param country (required=false, default='us') Provides localized data for the selected country
     *                  (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/dvds/top_rentals.json")
    RTMovies topRentals(
            @Query("limit") Integer limit,
            @Query("country") String country
    );

    /**
     * Retrieves current release dvds. Results are paginated if they go past the specified page limit
     *
     * @param page_limit (required=false, default=16) The amount of new release dvds to show per page
     * @param page (required=false, default=1) The selected page of current DVD releases
     * @param country (required=false, default='us')	Provides localized data for the selected country
     *                  (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/dvds/current_releases.json")
    RTMoviesPage currentReleases(
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );

    /**
     * Retrieves new release dvds. Results are paginated if they go past the specified page limit
     *
     * @param page_limit (required=false, default=16) The amount of new release dvds to show per page
     * @param page	(required=false, default=1) The selected page of new release DVDs
     * @param country (required=false, default='us') Provides localized data for the selected country
     *                  (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/dvds/new_releases.json")
    RTMoviesPage newReleases(
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );

    /**
     * Retrieves new release dvds. Results are paginated if they go past the specified page limit
     *
     * @param page_limit (required=false, default=16) The amount of upcoming dvds to show per page
     * @param page	(required=false, default=1) The selected page of upcoming DVDs
     * @param country	(required=false, default='us') Provides localized data for the selected country
     *                  (ISO 3166-1 alpha-2) if available. Otherwise, returns US data.
     * @return
     */
    @GET("/lists/dvds/upcoming.json")
    RTMoviesPage upcoming(
            @Query("page_limit") Integer page_limit,
            @Query("page") Integer page,
            @Query("country") String country
    );

}

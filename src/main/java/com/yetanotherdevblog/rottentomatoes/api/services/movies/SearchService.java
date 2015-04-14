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

package com.yetanotherdevblog.rottentomatoes.api.services.movies;

import com.yetanotherdevblog.rottentomatoes.api.entities.RTMoviesPage;
import retrofit.http.GET;
import retrofit.http.Query;

public interface SearchService {

    /**
     * The movies search endpoint for plain text queries. Allows you to search for movies!
     *
     * @param q (required=false) The plain text search query to search for a movie. Remember to URI encode this!
     * @param pageLimit (default: 30, required=false)	The amount of movie search results to show per page
     * @param page	(default: 1, required=false) The selected page of movie search results
     * @return
     */
    @GET("/movies.json")
    RTMoviesPage movies(
            @Query("q") String q,
            @Query("page_limit") Integer pageLimit,
            @Query("page") Integer page
    );

}

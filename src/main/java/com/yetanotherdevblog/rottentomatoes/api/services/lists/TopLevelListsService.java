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

import com.yetanotherdevblog.rottentomatoes.api.entities.LinksWrapper;
import retrofit.http.GET;

public interface TopLevelListsService {

    /**
     * Displays the top level lists available in the API.
     * We currently have movie lists and dvd lists available
     *
     * @return
     */
    @GET("/lists.json")
    LinksWrapper listsDirectory();

    /**
     * Shows the movie lists we have available
     *
     * @return
     */
    @GET("/lists/movies.json")
    LinksWrapper movieListsDirectory();

    /**
     * Shows the DVD lists we have available
     *
     * @return
     */
    @GET("/lists/dvds.json")
    LinksWrapper dvdListsDirectory();

}

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

package com.rottentomatoes.api.entities;

import java.util.List;

public class RTMovie {

    public Integer id;
    public String title;
    public Integer year;
    public List<String> genres;
    public String mpaa_rating;
    public String runtime;
    public String critics_consensus;
    public RTReleaseDates release_dates;
    public RTRatings ratings;
    public String synopsis;
    public RTPosters posters;
    public List<RTCast> abridged_cast;
    public List<RTDirector> abridged_directors;
    public String studio;
    public RTAlternativeIds alternate_ids;
    public RTLinks links;

}

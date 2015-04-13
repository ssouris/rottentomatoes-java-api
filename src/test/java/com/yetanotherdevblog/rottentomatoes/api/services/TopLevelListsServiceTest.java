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
import com.yetanotherdevblog.rottentomatoes.api.entities.LinksWrapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class TopLevelListsServiceTest {

    private TopLevelListsService topLevelListsService;

    @Before
    public void init() {
        RottenTomatoes rt = new RottenTomatoes();
        rt.setApiKey(TestConstants.API_KEY);
        topLevelListsService = rt.topLevelListsService();
    }

    @Test
    public void listsDirectory() {
        LinksWrapper listsDirectory = topLevelListsService.listsDirectory();
        Assertions.assertThat(listsDirectory.links.isEmpty()).isFalse();
    }

    @Test
    public void movieListsDirectory() {
        LinksWrapper movieListsDirectory = topLevelListsService.movieListsDirectory();
        Assertions.assertThat(movieListsDirectory.links.isEmpty()).isFalse();
    }
    @Test
    public void dvdListsDirectory() {
        LinksWrapper dvdListsDirectory = topLevelListsService.dvdListsDirectory();
        Assertions.assertThat(dvdListsDirectory.links.isEmpty()).isFalse();
    }

}

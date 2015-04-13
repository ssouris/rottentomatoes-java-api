# rottentomatoes-java-api
Java API for Rotten Tomatoes website

```java
// Create an instance of the service you wish to use
// you can keep this around
RottenTomatoes rt = new RottenTomatoes();
rt.setApiKey(TestConstants.API_KEY);
MoviesListsService moviesService = rt.dvdListsService();
//
// Call any of the available endpoints
RTMoviesPage inTheaters = moviesService.inTheaters(1, 1, "us");
RTMoviesPage openingMovies = moviesService.openingMovies(1, "us");
```

See test cases in `src/test/` for more examples.

License
-------

    Copyright 2015 Souris Stathis

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

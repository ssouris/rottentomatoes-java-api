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

package com.rottentomatoes.api;

import com.rottentomatoes.api.services.*;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

import java.util.concurrent.TimeUnit;

/**
 * Helper class for easy usage of the Rotten Tomateoes v1.0 API using retrofit.
 * <p>
 * Create an instance of this class, {@link #setApiKey(String)} and then call any of the service methods.
 * <p>
 * The service methods take care of constructing the required {@link retrofit.RestAdapter} and creating the service. You
 * can customize the {@link retrofit.RestAdapter} by overriding {@link #newRestAdapterBuilder()} and setting e.g.
 * your own HTTP client instance or thread executor.
 * <p>
 * Only one {@link retrofit.RestAdapter} instance is created upon the first and re-used for any consequent service
 * method call.
 */
public class RottenTomatoes {

    /**
     * Rotten Tomatoes API URL.
     */
    public static final String API_URL = "http://api.rottentomatoes.com/api/public/v1.0";

    /**
     * API key query parameter name.
     */
    public static final String PARAM_API_KEY = "apikey";

    private String apiKey;
    private boolean isDebug;
    private RestAdapter restAdapter;

    /**
     * Create a new manager instance.
     */
    public RottenTomatoes() {
    }

    /**
     * Set the TMDB API key.
     * <p>
     * The next service method call will trigger a rebuild of the {@link retrofit.RestAdapter}. If you have cached any
     * service instances, get a new one from its service method.
     *
     * @param value Your TMDB API key.
     */
    public RottenTomatoes setApiKey(String value) {
        this.apiKey = value;
        restAdapter = null;
        return this;
    }

    /**
     * Set the {@link retrofit.RestAdapter} log level.
     *
     * @param isDebug If true, the log level is set to {@link retrofit.RestAdapter.LogLevel#FULL}.
     *                Otherwise {@link retrofit.RestAdapter.LogLevel#NONE}.
     */
    public RottenTomatoes setIsDebug(boolean isDebug) {
        this.isDebug = isDebug;
        if (restAdapter != null) {
            restAdapter.setLogLevel(isDebug ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE);
        }
        return this;
    }

    /**
     * Create a new {@link retrofit.RestAdapter.Builder}. Override this to e.g. set your own client or executor.
     *
     * @return A {@link retrofit.RestAdapter.Builder} with no modifications.
     */
    protected RestAdapter.Builder newRestAdapterBuilder() {
        return new RestAdapter.Builder();
    }

    /**
     * Return the current {@link retrofit.RestAdapter} instance. If none exists (first call, API key changed),
     * builds a new one.
     * <p>
     * When building, sets the endpoint, a custom converter ({@link RottenTomatoesHelper#getGsonBuilder()})
     * and a {@link retrofit.RequestInterceptor} which adds the API key as query param.
     */
    protected RestAdapter getRestAdapter() {
        if (restAdapter == null) {
            RestAdapter.Builder builder = newRestAdapterBuilder();

            builder.setEndpoint(API_URL);
            builder.setConverter(new GsonConverter(RottenTomatoesHelper.getGsonBuilder().create()));
            builder.setRequestInterceptor(new RequestInterceptor() {
                public void intercept(RequestFacade requestFacade) {
                    requestFacade.addQueryParam(PARAM_API_KEY, apiKey);
                }
            });

            OkHttpClient client = new OkHttpClient();
            client.setConnectTimeout(10, TimeUnit.SECONDS);
            client.setReadTimeout(10, TimeUnit.SECONDS);
            client.setWriteTimeout(10, TimeUnit.SECONDS);
            builder.setClient(new OkClient(client));

            if (isDebug) {
                builder.setLogLevel(RestAdapter.LogLevel.FULL);
            }

            restAdapter = builder.build();
        }

        return restAdapter;
    }


    public MoviesListsService moviesService() {
        return getRestAdapter().create(MoviesListsService.class);
    }

    public MovieDetailedInfoService detailedInfoService() {
        return getRestAdapter().create(MovieDetailedInfoService.class);
    }

    public SearchService searchService() {
        return getRestAdapter().create(SearchService.class);
    }

    public DvdListsService dvdListsService() {
        return getRestAdapter().create(DvdListsService.class);
    }

    public TopLevelListsService topLevelListsService() {
        return getRestAdapter().create(TopLevelListsService.class);
    }
}


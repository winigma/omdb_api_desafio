package com.mybestmovies.omdb.controller.provider;

import android.content.SearchRecentSuggestionsProvider;

/**
 * Created by Wisley on 09/07/2015.
 */
public class RecentSearchContentApp extends SearchRecentSuggestionsProvider {

    public static final String AUTHORITY =
            RecentSearchContentApp.class.getName();
    public static final int MODE = DATABASE_MODE_QUERIES;

    public RecentSearchContentApp() {

        setupSuggestions(AUTHORITY, MODE);
    }
}


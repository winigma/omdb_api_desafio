package com.mybestmovies.omdb.controller;

import android.app.SearchManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.SearchRecentSuggestions;
import android.widget.ListView;

import com.mybestmovies.omdb.controller.provider.RecentSearchContentApp;
import com.mybestmovies.omdb.view.adapter.SuggesttionGlobalAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wisley
 */
public class ControllerRecentSearchGlobal {


    private final static String CONTENT = "content://";
    private final static String CONTENT_URI = CONTENT + RecentSearchContentApp.AUTHORITY + '/' + SearchManager.SUGGEST_URI_PATH_QUERY;
    private final static String ORDER_BY_LIMIT = "LIMIT 3";
    private final static int MAX_RESULT = 5;
    private Context mContext;
    private SearchRecentSuggestions mSugestions;

    public ControllerRecentSearchGlobal(final Context mContext) {
        this.mContext = mContext;
        this.mSugestions = getRecentSuggestions();
    }

    public SearchRecentSuggestions getRecentSuggestions() {
        return new SearchRecentSuggestions(mContext,
                RecentSearchContentApp.AUTHORITY,
                RecentSearchContentApp.MODE);
    }

    public Cursor getSuggestionCursor(final String query) {
        final ContentResolver contentResolver = mContext.getApplicationContext().getContentResolver();
        final Uri uri = Uri.parse(CONTENT_URI);
        return contentResolver.query(uri, null, null, new String[]{query}, ORDER_BY_LIMIT);
    }

    public List<String> getPlacesFromSuggestionCursor(final String query) {
        final Cursor cursor = getSuggestionCursor(query);
        final List<String> suggestions = new ArrayList<String>();

        if (cursor != null) {
            final int index = cursor.getColumnIndex(SearchManager.SUGGEST_COLUMN_TEXT_1);
            while (cursor.moveToNext() && suggestions.size() <= MAX_RESULT) {
                final String json = cursor.getString(index);
                //  final String placeBo = getPlaceFronJson(json);
                if(!isTagJSONValid(json) ){
                    suggestions.add(json);
                }
            }
        }


        return suggestions;
    }


    public SuggesttionGlobalAdapter getAdapter(final SuggesttionGlobalAdapter adapter, final List<String> query, final ListView listView) {

        SuggesttionGlobalAdapter suggestionAdapter = adapter;
        if (suggestionAdapter != null) {
            suggestionAdapter.getSuggestions().clear();
            suggestionAdapter.getSuggestions().addAll(query);
            suggestionAdapter.notifyDataSetChanged();
        } else {
            suggestionAdapter = new SuggesttionGlobalAdapter(mContext, query);
            listView.setAdapter(suggestionAdapter);
        }


        return suggestionAdapter;
    }

    public void saveSugestion(final String sugestion) {
        this.mSugestions.saveRecentQuery(sugestion, null);
    }

    public void claarHistory() {
        this.mSugestions.clearHistory();
    }

    public SearchRecentSuggestions getmSugestions() {
        return mSugestions;
    }

    public void setmSugestions(final SearchRecentSuggestions mSugestions) {
        this.mSugestions = mSugestions;
    }

    public boolean isTagJSONValid(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException ex) {

            try {
                new JSONArray(json);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }
}

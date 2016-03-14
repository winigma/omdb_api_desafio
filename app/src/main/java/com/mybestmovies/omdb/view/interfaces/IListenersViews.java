package com.mybestmovies.omdb.view.interfaces;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Wisley
 */
public interface IListenersViews {


    public Context getBaseContext();


    public Context getApplicationContext();


    public AssetManager getAssets();


    public String getString(final int resId);


    public Resources getResources();


    public View findViewById(final int id);


    public SharedPreferences getSharedPreferences(final String name, final int mode);
    
    public LayoutInflater getLayoutInflater();
}

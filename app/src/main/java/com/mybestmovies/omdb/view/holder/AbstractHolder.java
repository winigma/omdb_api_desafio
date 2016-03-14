package com.mybestmovies.omdb.view.holder;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;

import com.mybestmovies.omdb.view.interfaces.IListenersViews;


public abstract class AbstractHolder {

	protected IListenersViews activityListener;

	protected AbstractHolder(final IListenersViews activityHomeView) {
		super();
		this.activityListener = activityHomeView;
		initializeFields();
	}

	/**
	 * initialize fields and finds
	 */
	protected abstract void initializeFields();

	/**
	 * performing the search components from the interface implemented by any
	 * activity
	 * 
	 * @param resId
	 * @return {@link android.view.View}
	 */
	protected View getField(final int resId) {
		return activityListener.findViewById(resId);
	}
	
	protected Context getApplicationContext(){
		return activityListener.getApplicationContext();
	}
	
	protected Resources getResources(){
		return activityListener.getResources();
	}
	
	protected LayoutInflater getLayoutInflater(){
		return activityListener.getLayoutInflater();
	}

}

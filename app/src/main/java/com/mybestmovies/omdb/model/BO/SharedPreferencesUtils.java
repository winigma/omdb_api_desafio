package com.mybestmovies.omdb.model.BO;

/**
 * 
 * @author Wisley
 * 
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public final class SharedPreferencesUtils {

	private SharedPreferencesUtils() {

	}

	/**
	 * Write on SharedPreferences a String.
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return true if recorded, and false if not recorded.
	 */
	public static boolean writePreferences(final Context context,
			final String key, final String value) {
		boolean result = false;
		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		final Editor editor = sharedPreferences.edit();
		if (editor != null) {
			editor.putString(key, value);
			editor.commit();
			result = true;
		}

		return result;
	}

	/**
	 * Write on SharedPreferences a Integer.
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return true if recorded, and false if not recorded.
	 */
	public static boolean writePreferences(final Context context,
			final String key, final Integer value) {
		boolean result = false;
		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		final Editor editor = sharedPreferences.edit();
		if (editor != null) {
			editor.putInt(key, value);
			editor.commit();
			result = true;
		}
		return result;
	}
	
	/**
	 * Write on SharedPreferences a Boolean.
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return true if recorded, and false if not recorded.
	 */
	public static boolean writePreferences(final Context context,
			final String key, final Boolean value) {
		boolean result = false;
		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		final Editor editor = sharedPreferences.edit();
		if (editor != null) {
			editor.putBoolean(key, value);
			editor.commit();
			result = true;
		}
		return result;
	}

	/**
	 * Write on SharedPreferences a Boolean.
	 * 
	 * @param context
	 * @param key
	 * @param value
	 * @return true if recorded, and false if not recorded.
	 */
	public static boolean writePreferences(final Context context,
			final String key, final boolean value) {
		boolean result = false;
		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		final Editor editor = sharedPreferences.edit();
		if (editor != null) {
			editor.putBoolean(key, value);
			editor.commit();
			result = true;
		}
		return result;
	}
	
	/**
	 * Search a String value associated with a key in SharedPreferences.
	 * 
	 * @param context
	 * @param key
	 * @return result
	 */
	public static String getPreferencesString(final Context context,
			final String key) {
		String result;
		try {
			final SharedPreferences sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(context);
			result = sharedPreferences.getString(key, "");
		} catch (NullPointerException exception) {
			result = null;
		}
		return result;
	}

	/**
	 * Search a Integer value associated with a key in SharedPreferences.
	 * 
	 * @param context
	 * @param key
	 * @return result
	 */
	public static Integer getPreferencesInteger(final Context context,
			final String key) {
		Integer result;
		try {
			final SharedPreferences sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(context);
			result = sharedPreferences.getInt(key, 0);
		} catch (Exception exception) {
			result = null;
		}
		return result;
	}
	
	/**
	 * Search a Boolean value associated with a key in SharedPreferences.
	 * 
	 * @param context
	 * @param key
	 * @return result
	 */
	public static Boolean getPreferencesBoolean(final Context context,
			final String key) {
		Boolean result;
		try {
			final SharedPreferences sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(context);

			result = sharedPreferences.getBoolean(key, false);
		} catch (Exception exception) {
			result = false;
		}
		return result;
	}

	public static Boolean getPreferencesBoolean(final Context context,
			final String key,final boolean defaultValue) {
		Boolean result;
		try {
			final SharedPreferences sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(context);

			result = sharedPreferences.getBoolean(key, defaultValue);
		} catch (Exception exception) {
			result = false;
		}
		return result;
	}
	
	public static boolean remove(final Context context, final String key) {
		boolean result = false;
		try {
			final SharedPreferences sharedPreferences = PreferenceManager
					.getDefaultSharedPreferences(context);
			final Editor editor = sharedPreferences.edit();
			if (editor != null) {
				editor.remove(key);
				editor.commit();
				result = true; 	
			}
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public static boolean contains(final Context context, final String key) {
		final SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		return sharedPreferences.contains(key);
	}
	
}

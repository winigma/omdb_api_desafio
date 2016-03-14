package com.mybestmovies.omdb.controller.AssyncTasks;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.mybestmovies.omdb.controller.OMDBServiceController;
import com.mybestmovies.omdb.model.BO.Movie;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Wisley on 12/03/2016.
 */
public class ConnService extends AsyncTask<String, Void, Movie> {
    private static String URI = "http://www.omdbapi.com/?y=&plot=short&r=json&t=";
    HttpURLConnection urlConnection;
    OMDBServiceController mController;

    public ConnService(final OMDBServiceController mController) {
        this.mController = mController;

    }


    @Override
    protected Movie doInBackground(String... params) {

        String movie_title = "";
        String jsonString;

        for (String s : params) {
            movie_title += s;
        }

        movie_title = Uri.encode(movie_title);


        StringBuilder result = new StringBuilder();


        try {

            URL url = new URL(URI + movie_title);
            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));


            while ((jsonString = reader.readLine()) != null) {
                result.append(jsonString);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            return new Movie(result.toString());

        }
    }


    @Override
    protected void onPostExecute(Movie movie) {

        if (movie != null && movie.getYear() > 0) {


            mController.notifyConnectionFinish(movie);
            Log.i("sucess", "sucess");

        } else {
            mController.notifyError();
            Log.e("error","error");
        }

        super.onPostExecute(movie);
    }
}

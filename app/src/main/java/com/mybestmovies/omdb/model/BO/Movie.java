package com.mybestmovies.omdb.model.BO;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wisley on 11/03/2016.
 */
public class Movie implements Serializable {


    private String title;
    private String released;
    private String genre;
    private String director;
    private String writer;
    private String country;
    private String awards;
    private String poster;
    private String rate;
    private String actors;
    private String plot;

    private int year;
    private String duration;
    private int id;

    public Movie(int id,
                 String title,
                 String released,
                 String genre,
                 String director,
                 String writer,
                 String country,
                 String awards,
                 String poster,
                 String rate,
                 String actors,
                 String plot,
                 int year,
                 String duration) {
        this.id = id;
        this.released = released;
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.writer = writer;
        this.country = country;
        this.awards = awards;
        this.poster = poster;
        this.rate = rate;
        this.actors = actors;
        this.plot = plot;
        this.year = year;
        this.duration = duration;
    }



    public Movie(String jsonString) {
        try {
            JSONObject jO = new JSONObject(jsonString);
            this.title = jO.getString("Title");
            this.released = jO.getString("Released");
            this.genre = jO.getString("Genre");
            this.director = jO.getString("Director");
            this.writer = jO.getString("Writer");
            this.country = jO.getString("Country");
            this.awards = jO.getString("Awards");
            this.poster = jO.getString("Poster");
            this.rate = jO.getString("Rated");
            this.actors = jO.getString("Actors");
            this.plot = jO.getString("Plot");
            this.year = jO.getInt("Year");

            // zamiana 121 min na inta
            String dur = jO.getString("Runtime");
            Pattern p = Pattern.compile("[0-9]");
            Matcher m =p.matcher(dur);
            while(m.find()){
                dur = m.group();
            }

            this.duration = dur;
        } catch (JSONException e) {
            Log.e("error_JSONException", e.toString());
            e.printStackTrace();
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

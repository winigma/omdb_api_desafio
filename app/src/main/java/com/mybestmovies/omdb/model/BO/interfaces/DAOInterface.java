package com.mybestmovies.omdb.model.BO.interfaces;

import android.database.Cursor;

/**
 * Created by Wisley on 12/03/2016.
 */
public interface DAOInterface {
    public void insertMovie(final String title, final int year,  final String released,
                            final String duration, final String genre, final String director, final String writer,
                            final String actors, final String plot, final String country,
                            final String awards, final String poster, final String rate);

    public void removeMovie(final int id);

    public Cursor findAllMovies();

    public Cursor findMovieById(final int movie);

}

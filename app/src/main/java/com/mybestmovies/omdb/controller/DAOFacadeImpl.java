package com.mybestmovies.omdb.controller;

import android.database.Cursor;

import com.mybestmovies.omdb.controller.interfaces.DAOFacade;
import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.model.BO.MovieDAO;

import java.util.ArrayList;

/**
 * Created by Wisley on 12/03/2016.
 */
public class DAOFacadeImpl implements DAOFacade {


    @Override
    public void saveMovie(final MovieDAO dao, final Movie movie) {
        dao.insertMovie(
                movie.getTitle(),
                movie.getYear(),
                movie.getReleased(),
                movie.getDuration(),
                movie.getGenre(),
                movie.getDirector(),
                movie.getWriter(),
                movie.getActors(),
                movie.getPlot(),
                movie.getPlot(),
                movie.getAwards(),
                movie.getPoster(),
                movie.getRate()
        );
    }

    @Override
    public void deleteMovie(final MovieDAO dao, final Movie movie) {
        dao.removeMovie(movie.getId());
    }

    public static ArrayList<Movie> getAllFilms(final MovieDAO dbManager) {
        ArrayList<Movie> movies = new ArrayList<Movie>();

        Cursor c = dbManager.findAllMovies();
        while (c.moveToNext()) {
            Movie movie = new Movie(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("title")),
                    c.getString(c.getColumnIndex("released")),
                    c.getString(c.getColumnIndex("genre")),
                    c.getString(c.getColumnIndex("director")),
                    c.getString(c.getColumnIndex("writer")),
                    c.getString(c.getColumnIndex("country")),
                    c.getString(c.getColumnIndex("awards")),
                    c.getString(c.getColumnIndex("poster")),
                    c.getString(c.getColumnIndex("rate")),
                    c.getString(c.getColumnIndex("actors")),
                    c.getString(c.getColumnIndex("plot")),
                    c.getInt(c.getColumnIndex("year")),
                    c.getString(c.getColumnIndex("duration"))
            );
            movies.add(movie);
        }
        return movies;
    }

    public static Movie getFilm(final MovieDAO dbManager, final long id) {
        Cursor c = dbManager.findMovieById((int) id);

        Movie movie = null;

        while(c.moveToNext()) {
            movie = new Movie(
                    c.getInt(c.getColumnIndex("id")),
                    c.getString(c.getColumnIndex("title")),
                    c.getString(c.getColumnIndex("released")),
                    c.getString(c.getColumnIndex("genre")),
                    c.getString(c.getColumnIndex("director")),
                    c.getString(c.getColumnIndex("writer")),
                    c.getString(c.getColumnIndex("country")),
                    c.getString(c.getColumnIndex("awards")),
                    c.getString(c.getColumnIndex("poster")),
                    c.getString(c.getColumnIndex("rate")),
                    c.getString(c.getColumnIndex("actors")),
                    c.getString(c.getColumnIndex("plot")),
                    c.getInt(c.getColumnIndex("year")),
                    c.getString(c.getColumnIndex("duration"))
            );
        }
        return movie;
    }

}

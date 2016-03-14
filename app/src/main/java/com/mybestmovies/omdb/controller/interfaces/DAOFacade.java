package com.mybestmovies.omdb.controller.interfaces;

import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.model.BO.MovieDAO;

/**
 * Created by Wisley on 12/03/2016.
 */
public interface DAOFacade {

    public void saveMovie(final MovieDAO dao, final Movie movie);

    public void deleteMovie(final MovieDAO dao, final Movie movie);
}

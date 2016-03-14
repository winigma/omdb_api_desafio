package com.mybestmovies.omdb.controller;

import com.mybestmovies.omdb.application.OMDBApplication;
import com.mybestmovies.omdb.controller.interfaces.DAOFacade;
import com.mybestmovies.omdb.model.BO.Movie;

/**
 * Created by Wisley on 13/03/2016.
 */
public class ControllerRegisterMovie {

    DAOFacade daoFacade;

    public ControllerRegisterMovie(final DAOFacade daoImpl) {
        daoFacade = daoImpl;
    }

    /**
     * call method of insert register
     * @param movie
     */
    public void insert(final Movie movie) {
        daoFacade.saveMovie(OMDBApplication.getDbManager(), movie);
    }

    /**
     * call method delete register
     * @param movie
     */
    public void delete(final Movie movie) {

        daoFacade.deleteMovie(OMDBApplication.getDbManager(), movie);
    }



}

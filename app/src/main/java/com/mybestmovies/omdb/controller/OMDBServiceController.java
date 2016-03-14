package com.mybestmovies.omdb.controller;

import android.content.Context;
import android.os.AsyncTask;

import com.mybestmovies.omdb.controller.AssyncTasks.ConnService;
import com.mybestmovies.omdb.controller.interfaces.IPresenterDownloadMovie;
import com.mybestmovies.omdb.model.BO.Movie;

/**
 * Created by Wisley on 12/03/2016.
 */
public class OMDBServiceController {
    private IPresenterDownloadMovie mIPresentCallBack;
    private final Context mContext;
    private ConnService conn;

    public OMDBServiceController(final IPresenterDownloadMovie interfaces, final Context context) {
        this.mIPresentCallBack = interfaces;
        this.mContext = context;
    }

    public void notifyStart(String title){
        conn = new ConnService(this);
        mIPresentCallBack.notifyStart();
        if(conn.getStatus() != AsyncTask.Status.RUNNING){
            conn.execute(title);
        }
    }

    public void notifyConnectionFinish(final Movie movie) {
        mIPresentCallBack.notifyFinish(movie);
    }

    public void notifyError() {
        mIPresentCallBack.notifyError();
    }


}

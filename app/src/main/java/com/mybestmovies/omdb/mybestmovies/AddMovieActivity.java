package com.mybestmovies.omdb.mybestmovies;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.mybestmovies.omdb.controller.ControllerRegisterMovie;
import com.mybestmovies.omdb.controller.DAOFacadeImpl;
import com.mybestmovies.omdb.controller.OMDBServiceController;
import com.mybestmovies.omdb.controller.interfaces.IPresenterDownloadMovie;
import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.view.holder.HolderAddMovieActivity;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;

/**
 * Created by Wisley on 11/03/2016.
 */
public class AddMovieActivity extends AppCompatActivity implements IListenersViews, IPresenterDownloadMovie {


    private OMDBServiceController mController;
    private ControllerRegisterMovie mControllerActivity;
    private HolderAddMovieActivity mHolder;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_movie_activity);

        initActions();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initActions() {
        Log.i("enter", "enter in method");
        this.mHolder = new HolderAddMovieActivity(this);

        mController = new OMDBServiceController(this, this);

        mControllerActivity = new ControllerRegisterMovie(new DAOFacadeImpl());
        mHolder.getBtnSearch().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mController.notifyStart(mHolder.getInputName().getText().toString());

            }
        });

    }


    /**
     * pick search movie
     */
    @Override
    public void notifyStart() {

        progressDialog = new ProgressDialog(AddMovieActivity.this,
                android.support.design.R.style.Base_Theme_AppCompat_Light_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Search movie...");
        progressDialog.show();


    }


    /**
     * case sucess in search
     *
     * @param movie
     */
    @Override
    public void notifyFinish(Movie movie) {

        mControllerActivity.insert(movie);
        progressDialog.dismiss();
        hideMyKeyboard();
        AlertDialog.Builder builder =
                new AlertDialog.Builder(this, android.support.v7.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
        builder.setTitle(getResources().getString(R.string.dialog_btn_sucess));
        builder.setMessage(getResources().getString(R.string.dialog_msg_sucess));
        builder.setPositiveButton(getResources().getString(R.string.dialog_btn_ok), null);
        builder.show();

    }


    /**
     * case error in search of object
     */
    @Override
    public void notifyError() {

        progressDialog.dismiss();

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this, android.support.v7.appcompat.R.style.Base_Theme_AppCompat_Dialog_Alert);
        builder.setTitle(getResources().getString(R.string.dialog_btn_alert));
        builder.setMessage(getResources().getString(R.string.dialog_msg_error));
        builder.setPositiveButton(getResources().getString(R.string.dialog_btn_ok), null);
        builder.show();

        hideMyKeyboard();
    }

    private void hideMyKeyboard() {
        // Check if no view has focus:
        final View view = this.getCurrentFocus();
        if (view != null) {
            final InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(mHolder.getInputName().getWindowToken(), 0);
        }
    }



}

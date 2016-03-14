package com.mybestmovies.omdb.mybestmovies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.mybestmovies.omdb.application.OMDBApplication;
import com.mybestmovies.omdb.controller.DAOFacadeImpl;
import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.model.BO.SharedPreferencesUtils;
import com.mybestmovies.omdb.view.adapter.ListMoviesAdapter;
import com.mybestmovies.omdb.view.holder.HolderActivityMain;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;

import java.util.List;

/**
 * @author Wisley
 */
public class MainActivity extends AppCompatActivity implements IListenersViews {


    private ListMoviesAdapter mAdapter;
    private List<Movie> mList;
    private HolderActivityMain mHolder;

    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHolder = new HolderActivityMain(this);

        initializeMovies();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }


    /**
     * this method initilize objects and actions in views
     */
    void initializeMovies() {
        mHolder.getFab().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AddMovieActivity.class);

                startActivityForResult(intent, 777);

            }
        });
        mList = DAOFacadeImpl.getAllFilms(OMDBApplication.getDbManager());

        mAdapter = new ListMoviesAdapter(this, mList);
        mHolder.getMoviesDrawer().setAdapter(mAdapter);


        /**
         * checked if exists contents movies
         */
        if (noContent()) {
            mHolder.getNo_content().setVisibility(View.VISIBLE);
        } else {
            mHolder.getNo_content().setVisibility(View.GONE);

        }

        /**
         * load action in click item adapter
         */
        mHolder.getMoviesDrawer().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(), MovieDetailActivity.class);

                Movie movie = mAdapter.getItem(position);

                i.putExtra("id", movie.getId());

                ActivityOptionsCompat option = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, (View) view, "profile");
                ActivityCompat.startActivity(MainActivity.this, i, option.toBundle());
            }
        });
    }

    /**
     * case not exist movies one image dafault is visible to user.
     *
     * @return boolean
     */
    private boolean noContent() {
        if (mList == null || mList.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        /**
         * if request code is 777 adapter refresh rows
         */
        if (requestCode == 777) {
            mList.clear();
            mList = DAOFacadeImpl.getAllFilms(OMDBApplication.getDbManager());
            mAdapter.setmList(mList);
            mAdapter.notifyDataSetChanged();
        }


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (SharedPreferencesUtils.getPreferencesBoolean(MainActivity.this, "delete_ok")) {
            mList.clear();
            mList = DAOFacadeImpl.getAllFilms(OMDBApplication.getDbManager());
            mAdapter.setmList(mList);
            mAdapter.notifyDataSetChanged();
            SharedPreferencesUtils.writePreferences(getApplicationContext(), "delete_ok", false);

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.mybestmovies.omdb.mybestmovies/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.mybestmovies.omdb.mybestmovies/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

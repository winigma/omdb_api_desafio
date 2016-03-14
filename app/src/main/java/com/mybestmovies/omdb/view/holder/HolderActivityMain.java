package com.mybestmovies.omdb.view.holder;

import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.mybestmovies.omdb.mybestmovies.R;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;

/**
 * Created by Wisley on 12/03/2016.
 */
public class HolderActivityMain extends AbstractHolder {

    private ListView moviesDrawer;
    private ImageView no_content;
    FloatingActionButton fab;

    public HolderActivityMain(IListenersViews activityHomeView) {
        super(activityHomeView);
    }

    @Override
    protected void initializeFields() {
        this.moviesDrawer = (ListView) getField(R.id.moviesList);
        this.no_content = (ImageView)  getField(R.id.imageNotMovie);
        fab = (FloatingActionButton) getField(R.id.fab);


    }

    public ListView getMoviesDrawer() {
        return moviesDrawer;
    }

    public void setMoviesDrawer(ListView moviesDrawer) {
        this.moviesDrawer = moviesDrawer;
    }

    public ImageView getNo_content() {
        return no_content;
    }

    public void setNo_content(ImageView no_content) {
        this.no_content = no_content;
    }

    public FloatingActionButton getFab() {
        return fab;
    }

    public void setFab(FloatingActionButton fab) {
        this.fab = fab;
    }
}

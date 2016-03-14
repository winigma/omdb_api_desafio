package com.mybestmovies.omdb.view.holder;

import android.support.design.widget.FloatingActionButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mybestmovies.omdb.mybestmovies.R;
import com.mybestmovies.omdb.view.interfaces.IListenersViews;

/**
 * Created by Wisley on 13/03/2016.
 */
public class HolderDetailActivity extends AbstractHolder {


    private ImageView iv_Poster;
    private TextView tv_title;
    private TextView tv_released;
    private TextView tv_plot;
    private TextView tv_actors;
    private FloatingActionButton delete;



    public HolderDetailActivity(IListenersViews activityHomeView) {
        super(activityHomeView);
    }

    @Override
    protected void initializeFields() {

        this.iv_Poster = (ImageView) getField(R.id.iv_poster);
        this.tv_title = (TextView) getField(R.id.movie_title_name);
        this.tv_released = (TextView) getField(R.id.movie_released);
        this.tv_plot = (TextView) getField(R.id.movie_plot);
        this.tv_actors = (TextView) getField(R.id.movie_actors);
        this.delete = (FloatingActionButton) getField(R.id.fab_delete);


    }

    public ImageView getIv_Poster() {
        return iv_Poster;
    }

    public void setIv_Poster(ImageView iv_Poster) {
        this.iv_Poster = iv_Poster;
    }

    public TextView getTv_title() {
        return tv_title;
    }

    public void setTv_title(TextView tv_title) {
        this.tv_title = tv_title;
    }

    public TextView getTv_released() {
        return tv_released;
    }

    public void setTv_released(TextView tv_released) {
        this.tv_released = tv_released;
    }

    public TextView getTv_plot() {
        return tv_plot;
    }

    public void setTv_plot(TextView tv_plot) {
        this.tv_plot = tv_plot;
    }

    public TextView getTv_actors() {
        return tv_actors;
    }

    public void setTv_actors(TextView tv_actors) {
        this.tv_actors = tv_actors;
    }

    public FloatingActionButton getDelete() {
        return delete;
    }

    public void setDelete(FloatingActionButton delete) {
        this.delete = delete;
    }
}

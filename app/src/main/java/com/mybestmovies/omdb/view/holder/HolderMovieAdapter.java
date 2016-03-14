package com.mybestmovies.omdb.view.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mybestmovies.omdb.mybestmovies.R;

/**
 * Created by Wisley on 11/03/2016.
 */
public class HolderMovieAdapter {

    private TextView mTitle;
    private TextView mRelesed;
    private TextView mRated;
    private TextView mDuration;
    private ImageView mPoster;


    public HolderMovieAdapter(View view) {

        this.mTitle = (TextView) view.findViewById(R.id.movie_title);
        this.mRated = (TextView) view.findViewById(R.id.movie_rated);
        this.mDuration = (TextView) view.findViewById(R.id.movie_duration);
        this.mRelesed = (TextView) view.findViewById(R.id.movie_released);
        this.mPoster = (ImageView) view.findViewById(R.id.movie_poster);

    }

    public TextView getmTitle() {
        return mTitle;
    }

    public void setmTitle(TextView mTitle) {
        this.mTitle = mTitle;
    }

    public TextView getmRelesed() {
        return mRelesed;
    }

    public void setmRelesed(TextView mRelesed) {
        this.mRelesed = mRelesed;
    }

    public TextView getmRated() {
        return mRated;
    }

    public void setmRated(TextView mRated) {
        this.mRated = mRated;
    }

    public TextView getmDuration() {
        return mDuration;
    }

    public void setmDuration(TextView mDuration) {
        this.mDuration = mDuration;
    }

    public ImageView getmPoster() {
        return mPoster;
    }

    public void setmPoster(ImageView mPoster) {
        this.mPoster = mPoster;
    }
}

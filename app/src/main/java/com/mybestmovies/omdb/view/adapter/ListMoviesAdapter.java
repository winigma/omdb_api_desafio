package com.mybestmovies.omdb.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.mybestmovies.omdb.model.BO.Movie;
import com.mybestmovies.omdb.mybestmovies.R;
import com.mybestmovies.omdb.view.holder.HolderMovieAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wisley on 11/03/2016.
 */
public class ListMoviesAdapter extends BaseAdapter {


    private List<Movie> mList;
    private final Context mContext;
    LayoutInflater inflater;

    public ListMoviesAdapter(final Context context, final List<Movie> listBO) {

        mContext = context;
        this.mList = new ArrayList<Movie>();
        this.mList = listBO;
        this.inflater = LayoutInflater.from(this.mContext);


    }

    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Movie getItem(int position) {
        if (mList != null) {
            return mList.get(position);
        }
        return null;
    }



    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        HolderMovieAdapter mHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.movie_item, parent, false);
            mHolder = new HolderMovieAdapter(convertView);
            convertView.setTag(mHolder);
        } else {
            mHolder = (HolderMovieAdapter) convertView.getTag();
        }

        Movie currentItem = getItem(position);
        mHolder.getmTitle().setText(currentItem.getTitle());
        mHolder.getmRated().setText(currentItem.getRate());
        mHolder.getmDuration().setText(currentItem.getDuration());
        mHolder.getmRelesed().setText(currentItem.getReleased());
        Picasso.with(mContext).load(currentItem.getPoster()).error(R.drawable.no_movie).into(mHolder.getmPoster());


        return convertView;
    }

    public List<Movie> getmList() {
        return mList;
    }

    public void setmList(List<Movie> mList) {
        this.mList = mList;
    }
}

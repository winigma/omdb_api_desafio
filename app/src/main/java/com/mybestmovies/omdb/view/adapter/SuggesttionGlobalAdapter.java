package com.mybestmovies.omdb.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.mybestmovies.omdb.mybestmovies.R;

import java.util.List;

/**
 * Created by Wisley on 09/07/2015.
 */
public class SuggesttionGlobalAdapter extends BaseAdapter {

    private List<String> suggestions;

    private final LayoutInflater inflater;

    private SuggestionItemHolder holder;

    public SuggesttionGlobalAdapter(final Context context, final List<String> suggestions) {
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.suggestions = suggestions;
    }

    @Override
    public int getCount() {
        return this.suggestions.size();
    }

    @Override
    public Object getItem(int position) {
        return  this.suggestions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view ==null){
            view = inflater.inflate(R.layout.suggesttion_movie_item, parent, false);
            holder = new SuggestionItemHolder();
            holder.title = (TextView) view.findViewById(R.id.title_suggestion_place_item);
            view.setTag(holder);
        }else{
            holder = (SuggestionItemHolder) view.getTag();

        }

        holder.title.setText(suggestions.get(position));




        return view;
    }


    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }



    static class SuggestionItemHolder{
        TextView title;
    }
}

package com.mybestmovies.omdb.view.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.mybestmovies.omdb.mybestmovies.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wisley
 */
public class SearchAdapter extends CursorAdapter implements Filterable {
    private ArrayList<String> items;
    private ArrayList<String> orig;
    private Context mContext;

    public SearchAdapter(Context context, Cursor c, ArrayList<String> items) {
        super(context, c, false);
        this.mContext = context;
        this.items = items;
        orig = new ArrayList<String>();
        orig.addAll(items);
    }

    @Override
    public int getCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                constraint = constraint.toString().toLowerCase();
                FilterResults result = new FilterResults();

                if (constraint != null && constraint.toString().length() > 0) {
                    List<String> founded = new ArrayList<String>();
                    for (int i = 0; i < orig.size(); i++) {
                        if (orig.get(i)
                                .toString()
                                .toLowerCase()
                                .startsWith(
                                        constraint.toString().toLowerCase()))
                            founded.add(orig.get(i));
                    }
                    result.values = founded;
                    result.count = founded.size();
                } else {

                    synchronized (this) {
                        result.values = orig;
                        result.count = orig.size();
                    }
                }

                return result;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (items != null){
                    items.clear();
                    items = new ArrayList<String>();
                    items = (ArrayList) results.values;
                    notifyDataSetChanged();
                }

            }
        };
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        ViewHolder holder = new ViewHolder();
        View v = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        v = inflater.inflate(R.layout.suggesttion_movie_item, parent, false);
        holder.textView = (TextView) v.findViewById(R.id.title_suggestion_place_item);

        holder.textView.setTextColor(mContext.getResources().getColor(R.color.color_dark_gray));
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.textView.setText(items.get(cursor.getPosition()));

    }

    public static  class ViewHolder {
        public TextView textView;
    }

    public ArrayList<String> getItems() {
        return items;
    }
}

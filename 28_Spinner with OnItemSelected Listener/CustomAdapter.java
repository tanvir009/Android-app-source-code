package com.example.my;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    int [] flags;
    String[] countryNames;
    String[] population;
    private LayoutInflater layoutInflater;

    public CustomAdapter(Context context, int[] flags, String[] countryNames, String[] population) {
        this.context = context;
        this.flags = flags;
        this.countryNames = countryNames;
        this.population = population;
    }

    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
           LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           view = layoutInflater.inflate(R.layout.sample_view, null, false);

        }

        ImageView imageView = view.findViewById(R.id.imageViewId);
        imageView.setImageResource(flags[i]);

        TextView countryName = view.findViewById(R.id.countryNameId);
        countryName.setText(countryNames[i]);

        TextView countryDetails = view.findViewById(R.id.countryDetailsId);
        countryDetails.setText(population[i]);

        return view;
    }
}

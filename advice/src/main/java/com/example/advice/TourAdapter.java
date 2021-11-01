package com.example.advice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TourAdapter extends ArrayAdapter<Tour> {

    private int mColorResourceId;

    public TourAdapter(Context context, ArrayList<Tour> tours, int colorResourceId) {
        super(context, 0, tours);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Tour currentTour = getItem(position);

        TextView textView1 = (TextView) listItemView.findViewById(R.id.NAME);
        textView1.setText(currentTour.getname());

        TextView textView2 = (TextView) listItemView.findViewById(R.id.Descirption);
        textView2.setText(currentTour.getdescription());

        ImageView imageView1 = (ImageView) listItemView.findViewById(R.id.image);
        imageView1.setImageResource(currentTour.getImage());

        return listItemView;
    }
}
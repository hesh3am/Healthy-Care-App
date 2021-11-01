package com.example.advice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Healthyfood extends Fragment {
    public Healthyfood() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.advice_list, container, false);

        final ArrayList<Tour> tours = new ArrayList<Tour>();
        tours.add(new Tour(R.string.Vegetables,
                R.string.des_Vegetables, R.drawable.vegetable));
        tours.add(new Tour(R.string.Fruit,
                R.string.des_Fruit, R.drawable.fruits));
        tours.add(new Tour(R.string.WholeGrains,
                R.string.des_WholeGrains, R.drawable.wholegrains));
        tours.add(new Tour(R.string.Protein,
                R.string.des_Protein, R.drawable.protines));

        TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.primary_dark_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
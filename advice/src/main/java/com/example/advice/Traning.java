package com.example.advice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Traning extends Fragment {
    public Traning() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.advice_list, container, false);


        final ArrayList<Tour> tours = new ArrayList<Tour>();
        tours.add(new Tour(R.string.aerobic,
                R.string.des_aerobic, R.drawable.aerobex));
        tours.add(new Tour(R.string.strength,
                R.string.des_strength, R.drawable.strength));
        tours.add(new Tour(R.string.balance,
                R.string.des_balance, R.drawable.improvebalance));
        tours.add(new Tour(R.string.flexibility,
                R.string.des_flexibility, R.drawable.felexx));


        TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.primary_dark_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}

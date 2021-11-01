package com.example.advice;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class BodyCare extends Fragment {
    public BodyCare() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.advice_list, container, false);

        final ArrayList<Tour> tours = new ArrayList<Tour>();
        tours.add(new Tour(R.string.turmeric,
                R.string.des_turmeric, R.drawable.turmeric));
        tours.add(new Tour(R.string.Ginseng,
                R.string.des_Ginseng, R.drawable.ginsenge));
        tours.add(new Tour(R.string.LemonBalm,
                R.string.des_LemonBalm, R.drawable.lemon));
        tours.add(new Tour(R.string.Sage,
                R.string.des_Sage, R.drawable.sage));

        TourAdapter adapter = new TourAdapter(getActivity(), tours, R.color.primary_dark_color);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        return rootView;
    }
}
package com.chaudhry.najeeb.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Najeeb on 1/23/17.
 */
public class ParksFragment extends Fragment {

    public ParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_tourguide_list, container, false);

        // Create an array
        // Define array final because an anonymous class cannot access local varialbes in its enclosing
        // scope that are not declared final
        final ArrayList<TourGuide> tourGuide = new ArrayList<TourGuide>();

        //TourGuide tg = new TourGuide("John", "Palm ave", "1800");
        //myTourGuide.add(tg);
        // Above 2 lines are same as: myTourGuide.add(new new TourGuide("John", "Palm ave", 1800));

        //Add objects into above array
        tourGuide.add(new TourGuide("Hugh Taylor Birch State Park", "3109 E Sunrise Blvd",
                "Fort Lauderdale, FL 33304", "(954) 564-4521"));
        tourGuide.add(new TourGuide("Colee Hammock Park", "1500 Brickell Dr",
                "Fort Lauderdale, FL 33301", "(954) 828-7275"));
        tourGuide.add(new TourGuide("Riverwalk Linear Park", "20 N New River Dr",
                "Fort Lauderdale, FL 33301", "(954) 828-7275"));
        tourGuide.add(new TourGuide("Secret Woods Nature Center", "2701 W State Rd 84",
                "Fort Lauderdale, FL 33312", "(954) 357-8884"));
        tourGuide.add(new TourGuide("Holiday Park", "1000 E. Sunrise Boulevard",
                "Fort Lauderdale, FL 33304", "(954) 828-5385"));
        tourGuide.add(new TourGuide("Fort Lauderdale Beach Park", "1100 Seabreeze Blvd",
                "Fort Lauderdale, FL 33316", "(954) 828-7275"));
        tourGuide.add(new TourGuide("Snyder Park : Bark Park", "3299 SW 4th Ave",
                "Fort Lauderdale, FL 33315", "(954) 828-4585"));
        tourGuide.add(new TourGuide("Florence C Hardy Park", "25 SW 9th St",
                "Fort Lauderdale, FL 33301", "(954) 828-7275"));
        tourGuide.add(new TourGuide("Esplanade Park", "401 SW 2nd St",
                "Fort Lauderdale, FL 33312", "(954) 828-7275"));
        tourGuide.add(new TourGuide("Victoria Park", "2 N Victoria Park Rd",
                "Fort Lauderdale, FL 33301", "954-828-7275"));

        //Adapter knows how to create list items for each item in the list.
        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuide, R.color.category_parks);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        return rootView;
    }
}

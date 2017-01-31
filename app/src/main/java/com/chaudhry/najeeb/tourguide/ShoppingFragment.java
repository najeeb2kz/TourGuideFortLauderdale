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
public class ShoppingFragment extends Fragment {

    public ShoppingFragment() {
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
        tourGuide.add(new TourGuide("Galleria At Fort Lauderdale", "2414 E Sunrise Blvd",
                "Fort Lauderdale, FL 33304", "(954) 564-1015"));
        tourGuide.add(new TourGuide("Las Olas Riverfront", "300 SW 1st Ave",
                "Fort Lauderdale, FL 33301", "(954) 522-6556"));
        tourGuide.add(new TourGuide("Coral Ridge Mall", "3200 N Federal Hwy",
                "Fort Lauderdale, FL 33306", "(954) 537-2700"));
        tourGuide.add(new TourGuide("Westfield Broward", "8000 West Broward Blvd",
                "Plantation, FL 33388", "(954) 473-8100"));
        tourGuide.add(new TourGuide("Aventura Mall", "19501 Biscayne Blvd",
                "Aventura, FL 33180", "(305) 935-1110"));
        tourGuide.add(new TourGuide("Sawgrass Mills", "12801 W Sunrise Blvd",
                "Sunrise, FL 33323", "(954) 846-2300"));
        tourGuide.add(new TourGuide("Promenade At Coconut Creek", "4401 Lyons Rd",
                "Coconut Creek, FL 33073", "(954) 977-3704"));
        tourGuide.add(new TourGuide("Coral Square", "9469 W Atlantic Blvd",
                "Coral Springs, FL 33071", "(954) 755-5552"));
        tourGuide.add(new TourGuide("Pembroke Lakes Mall", "11401 Pines Blvd",
                "Pembroke Pines, FL 33026", "(954) 436-3311"));
        tourGuide.add(new TourGuide("Las Olas Riverfront", "300 SW 1st Ave",
                "Fort Lauderdale, FL 33301", "(954) 522-6556"));

        //Adapter knows how to create list items for each item in the list.
        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuide, R.color.category_Shopping);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        return rootView;
    }
}

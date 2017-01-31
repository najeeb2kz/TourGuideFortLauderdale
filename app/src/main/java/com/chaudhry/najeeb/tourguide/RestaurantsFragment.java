package com.chaudhry.najeeb.tourguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class RestaurantsFragment extends Fragment {

    public RestaurantsFragment() {
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
        tourGuide.add(new TourGuide("Nuevo’s Cubano’s", "925 North Andrews Ave",
                "Fort Lauderdale, FL 33311", "(954) 806-8375", R.drawable.ic_925));
        tourGuide.add(new TourGuide("Regina’s Farm", "1101 Middle St",
                "Fort Lauderdale, FL 33312", "(954) 465-1900", R.drawable.ic_regina));
        tourGuide.add(new TourGuide("Back Alley Bar & BBQ", "234 Almond Ave",
                "Fort Lauderdale, FL 33316", "(954) 652-1278", R.drawable.ic_back));
        tourGuide.add(new TourGuide("The Foxy Brown", "723 E Broward Blvd",
                "Fort Lauderdale, FL 33301", "(754) 200-4236", R.drawable.ic_foxy));
        tourGuide.add(new TourGuide("The Poke House", "666 N Federal Hwy",
                "Fort Lauderdale, FL 33304", "(754) 200-4555", R.drawable.ic_poke));
        tourGuide.add(new TourGuide("Market 17", "1850 SE 17th St",
                "Fort Lauderdale, FL 33316", "(954) 835-5507", R.drawable.ic_market));
        tourGuide.add(new TourGuide("Bar Red Beard", "3301 NE 33rd St",
                "Fort Lauderdale, FL 33308", "(754) 223-4665", R.drawable.ic_bar));
        tourGuide.add(new TourGuide("Sushi 4 Fun", "6322 N Andrews Ave",
                "Fort Lauderdale, FL 33309", "(954) 530-4181", R.drawable.ic_sushi));
        tourGuide.add(new TourGuide("Gilbert’s 17th Street Grill", "1821 Cordova Rd",
                "Fort Lauderdale, FL 33316", "(954) 768-8990", R.drawable.ic_gilbert));
        tourGuide.add(new TourGuide("Coconuts", "429 Seabreeze Blvd",
                "Fort Lauderdale, FL 33316", "(954) 525-2421", R.drawable.ic_coconuts));

        //Adapter knows how to create list items for each item in the list.
        TourGuideAdapter adapter = new TourGuideAdapter(getActivity(), tourGuide, R.color.category_restaurants);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        if (listView != null) {
            listView.setAdapter(adapter);
        }

        return rootView;
    }
}

package com.chaudhry.najeeb.tourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Najeeb on 1/23/17.
 */
public class TourGuideAdapter extends ArrayAdapter<TourGuide> {

    //Resource ID for background color for this list of words
    private int mColorResourceID;

    public TourGuideAdapter(Context context, ArrayList<TourGuide> tourGuide, int colorResourceID) {
        // Passing in 0 for resource id because we don't need to rely on superclass array adapter inflating
        // or creating list view for us, instead our getView method will manually handle the inflating of
        // the layout from the layout resource id for ourselves
        super(context, 0, tourGuide);
        mColorResourceID = colorResourceID;
    }

    //Provides a view for an AdapterView (ListView, GridView, etc.)
    //@param position The position in the list of data that should be displayed in the list item view.
    //@param convertView The recycled view to populate.
    //@param parent The parent ViewGroup that is used for inflation. List item will be added to parent view group.
    //@return The View for the position in the AdapterView.
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Currently listItemView is referencing root linear layout of list item layout
        View listItemView = convertView;
        if (listItemView == null) {  //Sometimes convertView view can be null. If null then create one to use
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //getItem(position) is defined in super class ArrayAdapter.  This method returns item in the list at given idex position
        TourGuide currentTourGuide = getItem(position);

        TextView name = (TextView) listItemView.findViewById(R.id.name);
        TextView address1 = (TextView) listItemView.findViewById(R.id.address1);
        TextView address2 = (TextView) listItemView.findViewById(R.id.address2);
        TextView phone = (TextView) listItemView.findViewById(R.id.phone);

        name.setText(currentTourGuide.getName());
        address1.setText(currentTourGuide.getAddress1());
        address2.setText(currentTourGuide.getAddress2());
        phone.setText(currentTourGuide.getPhone());

        //Find the ImageView in list_item.xml layout with the ID image
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.iconView);
        if (currentTourGuide.hasImage()) {
            iconView.setImageResource(currentTourGuide.getImageResourceId());
            //Make sure the view is visible
            iconView.setVisibility(View.VISIBLE);
        } else {
            iconView.setVisibility(View.GONE);  //GONE means view is hidden and doesn't take any space
        }

        //set background color on linear layout which contains two TextViews
        LinearLayout linearLayoutForTextViews = (LinearLayout) listItemView.findViewById(R.id.text_container); //Instead of LinearLayout, could have used View
        //Find color that resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        //Set background color of the container view
        linearLayoutForTextViews.setBackgroundColor(color);

        return listItemView;
    }
}

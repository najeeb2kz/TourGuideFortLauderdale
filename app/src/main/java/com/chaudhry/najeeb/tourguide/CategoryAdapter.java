package com.chaudhry.najeeb.tourguide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;


public class CategoryAdapter extends FragmentPagerAdapter {

    // Context of the app
    private Context mContext;

    private String[] tabTitles;

    private int[] imageResId = {
            R.drawable.ic_restaurant,
            R.drawable.ic_shopping,
            R.drawable.ic_theater,
            R.drawable.ic_park };

    // Constructor: Create a new object
    // param context is context of the app
    // param fm is the fragment manager that will keep each fragment's state in the adapter across swipes
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
        tabTitles = new String[] { mContext.getString(R.string.category_restaurants),
                mContext.getString(R.string.category_Shopping),
                mContext.getString(R.string.category_theaters),
                mContext.getString(R.string.category_parks)    };
    }


    // Return the fragment that should be displayed for the given page number
    // getItem(int position) which determines the fragment for each tab
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new RestaurantsFragment();
        } else if (position == 1) {
            return new ShoppingFragment();
        } else if (position == 2) {
            return new TheatersFragments();
        } else {
            return new ParksFragment();
        }
    }

    // Return total number of pages
    @Override
    public int getCount() { return 4; }

    // Get title of each page
    @Override
    public CharSequence getPageTitle(int position) {

        // getDrawable(int i) is deprecated, use getDrawable(int i, Theme theme) for min SDK >=21
        // or ContextCompat.getDrawable(Context context, int id) if you want support for older versions.
        // Drawable image = context.getResources().getDrawable(iconIds[position], context.getTheme());
        // Drawable image = context.getResources().getDrawable(imageResId[position]);
        Drawable image = ContextCompat.getDrawable(mContext, imageResId[position]);
        // setBounds(Rect) method must be called to tell Drawable where it is drawn and how large it should be
        // void setBounds (int left, int top, int right, int bottom)
        // getIntrinsicWidth() & getIntrinsicHeight() find the preferred size
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        // SpannableString in android is an excellent way to style strings in a TextView.
        SpannableString sb = new SpannableString("   \n" + tabTitles[position]);
        // ImageSpan (Drawable d, int verticalAlignment)
        // verticalAlignment: int: one of ALIGN_BOTTOM or ALIGN_BASELINE
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}

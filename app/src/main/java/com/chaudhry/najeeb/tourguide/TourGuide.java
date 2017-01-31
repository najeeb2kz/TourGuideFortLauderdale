package com.chaudhry.najeeb.tourguide;

/**
 * Created by Najeeb on 1/23/17.
 */
public class TourGuide {

    private String mName;
    private String mAddress1;
    private String mAddress2;
    private String mPhoneNumber;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;// Constant value that represents no image was provided

    // Constructor
    public TourGuide(String name, String address1, String address2, String phoneNumber) {
        mName = name;
        mAddress1 = address1;
        mAddress2 = address2;
        mPhoneNumber = phoneNumber;
    }

    // Constructor
    public TourGuide(String name, String address1, String address2, String phoneNumber, int imageResourceId) {
        mName = name;
        mAddress1 = address1;
        mAddress2 = address2;
        mPhoneNumber = phoneNumber;
        mImageResourceId = imageResourceId;
    }

    public String getName() { return mName; }

    public String getAddress1() { return mAddress1; }

    public String getAddress2() { return mAddress2; }

    public String getPhone() { return mPhoneNumber; }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    //Return whether or not there is an image
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;  //if mImageResourceId is not eqaual to -1 return true
    }

}

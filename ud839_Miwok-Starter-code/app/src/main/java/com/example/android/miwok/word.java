package com.example.android.miwok;

/**
 * Created by H on 10/16/2018.
 */

public class word {
    /** Default translation for the word */
    private String mDefaultTranslation;
    /** Miwok translation for the word */
    private String mMiwokTranslation;

    private static final int NO_IMAGE_PROVIDED = -1;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private  int mrecord;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public word(String defaultTranslation, String miwokTranslation, int record) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mrecord=record;
    }

    public word(String defaultTranslation, String miwokTranslation,int ImageResourceId,int record) {
            mDefaultTranslation = defaultTranslation;
            mMiwokTranslation = miwokTranslation;
            mImageResourceId = ImageResourceId ;
            mrecord = record;
        }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId(){
        return  mImageResourceId;
    }

    public int getMrecord() {
        return mrecord;
    }

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mMiwokTranslation='" + mMiwokTranslation + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mrecord=" + mrecord +
                '}';
    }

}

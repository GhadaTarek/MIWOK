package com.example.android.miwok;


import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by H on 10/16/2018.
 */

public class wordAdapter extends ArrayAdapter<word> {

    private int mColorResourceId;

    private int mrecord;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *  @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     */
    public wordAdapter(Activity context, ArrayList <word> words, int color) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0, words);
        mColorResourceId =color;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        word currentWord = getItem( position );

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwok = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwok.setText(currentWord.getMiwokTranslation() );

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultWord = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultWord.setText(currentWord.getDefaultTranslation());

        ImageView image = (ImageView) listItemView.findViewById( R.id.image );


        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            image.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            image.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            image.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        textContainer.setBackgroundColor( color );

        return listItemView;
    }
}

package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_list );


        final ArrayList<word> family = new ArrayList <word>( );
        family.add(new word("father", "әpә",R.drawable.family_father,R.raw.family_father));
        family.add(new word("mother", "әṭa",R.drawable.family_mother,R.raw.family_mother));
        family.add(new word("son", "angsi",R.drawable.family_son,R.raw.family_son));
        family.add(new word("daughter", "tune",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new word("older brother", "taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new word("younger brother", "chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new word("younger sister", "kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new word("grandmother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        wordAdapter adapter = new wordAdapter(FamilyActivity.this, family,R.color.category_family );

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word w = family.get(position);
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(FamilyActivity.this , w.getMrecord() );
                // Start the audio file
                mMediaPlayer.start();
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}

package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.word_list );


        final ArrayList<word> phrase = new ArrayList <word>( );
        phrase.add(new word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        phrase.add(new word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
        phrase.add(new word("My name is...", "oyaaset...",R.raw.phrase_my_name_is));
        phrase.add(new word("How are you feeling?", "michәksәs?",R.raw.phrase_how_are_you_feeling));
        phrase.add(new word("I’m feeling good.", "kuchi achit",R.raw.phrase_im_feeling_good));
        phrase.add(new word("Are you coming?", "әәnәs'aa?",R.raw.phrase_are_you_coming));
        phrase.add(new word("Yes, I’m coming.", "hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        phrase.add(new word("I’m coming.", "әәnәm",R.raw.phrase_yes_im_coming));
        phrase.add(new word("Let’s go.", "yoowutis",R.raw.phrase_lets_go));
        phrase.add(new word("Come here.", "әnni'nem",R.raw.phrase_come_here));

        wordAdapter adapter = new wordAdapter(PhrasesActivity.this , phrase,R.color.category_phrases );

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Word} object at the given position the user clicked on
                word w = phrase.get(position);
                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(PhrasesActivity.this , w.getMrecord() );
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

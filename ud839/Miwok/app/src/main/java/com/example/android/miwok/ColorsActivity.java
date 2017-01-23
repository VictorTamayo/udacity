package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    /** Handles playback of all the sound files **/
    private MediaPlayer mMediaPlayer;

    // manages focus of audio currently playing
    private AudioManager mAudioManager;

    /***
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     * */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener(){
                public void onAudioFocusChange(int focusChange){
                    switch(focusChange){
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                            /***
                             *the AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                             * short amount of time. the AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                             * out app is allowed to continue playing sound but at a lower volume. We'll
                             * treat both cases the same way because our app is playing short sound files.
                             * */

                            // pause Playback and reset player to the start of the file. That way, we can
                            // play the word from the beginning when we resume playback.
                            mMediaPlayer.pause();
                            mMediaPlayer.seekTo(0);
                            break;
                        case AudioManager.AUDIOFOCUS_GAIN:
                            //The AudioFocus_Gain case means we have regained focus and can
                            //resume playback
                            mMediaPlayer.start();
                            break;
                        case AudioManager.AUDIOFOCUS_LOSS:
                            // The AudioFocus_Loss case means we've lost audio focus and
                            // stop playback and cleanup resources
                            releaseMediaPlayer();
                            break;
                        default:break;

                    }
                }
            };

    /**
     * This listener gets triggered when the{@link MediaPlayer} has completed
     *  playing the audio file
     **/
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> colors = new ArrayList<Word>();
        colors.add(new Word("red","wetetti",R.drawable.color_red,R.raw.color_red));
        colors.add(new Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        colors.add(new Word("brown","takaakki",R.drawable.color_brown,R.raw.color_brown));
        colors.add(new Word("gray","topoppi",R.drawable.color_gray,R.raw.color_gray));
        colors.add(new Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        colors.add(new Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        colors.add(new Word("dusty yellow","topiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        colors.add(new Word("mustard yellow","chiwiitә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));

        WordAdapter itemAdapter = new WordAdapter(this,colors,R.color.category_colors);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the {@link Word} object at the given position the user clicked on
                Word word = colors.get(position);

                // Request audio focus so inorder to play the audio file. The app needs to play
                // short audio files, so we will request audio focus for a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now


                    // Release the media player if it currently exists because we are about to
                    // with the current word
                    releaseMediaPlayer();

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getSoundForWord());

                    // start the audio file
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

    }


    @Override
    protected void onStop() {
        super.onStop();

        // When the activity is stoppped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
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

}

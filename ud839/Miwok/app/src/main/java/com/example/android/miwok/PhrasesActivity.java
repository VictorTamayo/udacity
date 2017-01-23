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

public class PhrasesActivity extends AppCompatActivity {
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
                             *the AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus
                             * for a short amount of time. the AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK
                             * case means that out app is allowed to continue playing sound but at
                             * a lower volume. We'll treat both cases the same way because our app
                             * is playing short sound files.
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
    private MediaPlayer.OnCompletionListener mCompletionListener =
            new MediaPlayer.OnCompletionListener() {
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

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?","minto wukusus",
                R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?","tinnә oyaase'nә",
                R.raw.phrase_what_is_your_name));
        words.add(new Word("My name is...","oyaaset...",R.raw.phrase_my_name_is));
        words.add(new Word("How are you feeling?","michәksәs?",
                R.raw.phrase_how_are_you_feeling));
        words.add(new Word("i'm feeling good","kuchi achit",R.raw.phrase_im_feeling_good));
        words.add(new Word("Are you coming?","әәnәs'aa?",R.raw.phrase_are_you_coming));
        words.add(new Word("Yes,I'm coming.","hәә’ әәnәm",R.raw.phrase_yes_im_coming));
        words.add(new Word("I'm coming.","әәnәm",R.raw.phrase_im_coming));
        words.add(new Word("Let's go.","yoowutis",R.raw.phrase_lets_go));
        words.add(new Word("Come here.","әnni'nem",R.raw.phrase_come_here));

        //find the root view for the whole layout

        WordAdapter itemAdapter = new WordAdapter(this,words,R.color.category_phrases);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(itemAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get the {@link Word} object at the given position the user clicked on
                Word word = words.get(position);

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
                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getSoundForWord());

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

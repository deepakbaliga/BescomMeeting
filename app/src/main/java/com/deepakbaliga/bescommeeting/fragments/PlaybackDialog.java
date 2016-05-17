package com.deepakbaliga.bescommeeting.fragments;


import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.ToggleButton;

import com.deepakbaliga.bescommeeting.R;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlaybackDialog extends DialogFragment implements Runnable {


    private MediaPlayer mp;
    private String file;
    private ToggleButton toggleButton;
    private SeekBar seekBar;

    public void setFile(String file) {
        this.file = file;
    }

    public PlaybackDialog() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_playback_dialog, container, false);
        toggleButton = (ToggleButton) view.findViewById(R.id.togglebutton);
        seekBar = (SeekBar) view.findViewById(R.id.media_seekbar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mp != null && fromUser){
                    mp.seekTo(progress);

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean on = ((ToggleButton) v).isChecked();

                Log.e("STATE", on+"");

                if (on) {
                    mp.pause();

                } else {
            mp.start();

                }

            }
        });
         mp = new MediaPlayer();
        try {
            mp.setDataSource(file);
            mp.prepare();
            mp.start();
            seekBar.setProgress(0);
            seekBar.setMax(mp.getDuration());
            new Thread(this).start();
        } catch (IOException e) {
            e.printStackTrace();

        }

        return view;
    }


    @Override
    public void onPause() {

        if(mp != null) {
            mp.pause();
            toggleButton.toggle();
        }
        super.onPause();

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        mp.stop();
        super.onDismiss(dialog);

    }




    @Override
    public void run() {
        int currentPosition= 0;
        int total = mp.getDuration();
        while (mp!=null && currentPosition<total) {
            try {
                Thread.sleep(1000);
                currentPosition= mp.getCurrentPosition();
            } catch (InterruptedException e) {
                return;
            } catch (Exception e) {
                return;
            }
            seekBar.setProgress(currentPosition);
        }
    }
}

package com.example.irfanfahmiwijaya.fixtubes;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.VideoView;

public class modul_live_mekah extends AppCompatActivity {
    // Declare variables
    VideoView videoview;

    ProgressDialog mDialog;
    ImageButton btnplaypause;

    // Insert your Video URL
    String VideoURL = "https://www.youtube.com/watch?v=5Bm0OjOkR78";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modul_live_mekah);

        // Find your VideoView in your video_main.xml layout
        videoview = (VideoView) findViewById(R.id.videoview);
        btnplaypause = (ImageButton) findViewById(R.id.btn_play_pause);

        btnplaypause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog = new ProgressDialog(modul_live_mekah.this);
                mDialog.setMessage("Please Wait...");
                mDialog.setCanceledOnTouchOutside(false);
                mDialog.show();

                try {
                    if(!videoview.isPlaying()){
                        // Get the URL from String VideoURL
                            Uri video = Uri.parse(VideoURL);
                            videoview.setVideoURI(video);
                            videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    btnplaypause.setImageResource(R.drawable.ic_play);

                                }
                            });
                    }else{
                        videoview.pause();
                        btnplaypause.setImageResource(R.drawable.ic_play);
                    }

                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }

                videoview.requestFocus();
                videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        mDialog.dismiss();
                        mediaPlayer.setLooping(true);
                        videoview.start();
                        btnplaypause.setImageResource(R.drawable.ic_play);
                    }
                });


            }
        });






        videoview.requestFocus();
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                videoview.start();
            }
        });
    }




}

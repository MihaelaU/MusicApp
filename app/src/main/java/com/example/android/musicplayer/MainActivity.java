package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4;
    int seek;
    private double startTime = 0;
    private double finalTime = 0;
    private SeekBar seekbar;

    float volume = 0.5f;

    public static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);

        b1 = (Button) findViewById(R.id.play);
        b2 = (Button) findViewById(R.id.pause);
        b3 = (Button) findViewById(R.id.volume_down);
        b4 = (Button) findViewById(R.id.volume_up);

        b1.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Toast.makeText(getApplicationContext(), "Playing sound", Toast.LENGTH_SHORT).show();
                                      mediaPlayer.start();
                                      b1.setEnabled(true);
                                      b2.setEnabled(true);

                                      finalTime = mediaPlayer.getDuration();
                                      startTime = mediaPlayer.getCurrentPosition();

                                      if (oneTimeOnly == 0) {
                                          oneTimeOnly = 1;
                                      }
                                  }
                              });

        b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Pausing sound", Toast.LENGTH_SHORT).show();
                        mediaPlayer.pause();
                    }
                });

        b3.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      Toast.makeText(getApplicationContext(), "Volume Down", Toast.LENGTH_SHORT).show();
                                        volume = volume - 0.05f;
                                      if (volume <= 0f) {
                                          volume = 0f;
                                      }
                                      mediaPlayer.setVolume(volume, volume);
                                  }
                              });

        b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Volume Up", Toast.LENGTH_SHORT).show();
                            volume = volume + 0.05f;
                            if (volume >= 1f) {
                                volume = 1f;
                        }
                        mediaPlayer.setVolume(volume, volume);
                    }
                });
        }
    }











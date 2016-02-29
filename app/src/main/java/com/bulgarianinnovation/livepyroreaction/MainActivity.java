package com.bulgarianinnovation.livepyroreaction;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean firstPlay = true;
    private ImageView button;
    private MediaPlayer mp;
    private SoundPool sp;
    private int[] rawRef = { R.raw.quote1, R.raw.quote2, R.raw.quote3, R.raw.quote4, R.raw.quote5, R.raw.quote6,
                             R.raw.quote7, R.raw.quote8, R.raw.quote9, R.raw.quote10, R.raw.quote11, R.raw.quote12,
                             R.raw.quote13, R.raw.quote14, R.raw.quote15, R.raw.quote16, R.raw.quote17, R.raw.quote18,
                             R.raw.quote18, R.raw.quote19, R.raw.quote20, R.raw.quote21, R.raw.quote22, R.raw.quote23,
                             R.raw.quote24, R.raw.quote25, R.raw.quote26, R.raw.quote27, R.raw.quote28, R.raw.quote29,
                             R.raw.quote30, R.raw.quote31, R.raw.quote32, R.raw.quote33, R.raw.quote34, R.raw.quote35,
                             R.raw.quote36, R.raw.quote37, R.raw.quote38, R.raw.quote39, R.raw.quote40, R.raw.quote41,
                             R.raw.quote42, R.raw.quote43, R.raw.quote44, R.raw.quote45 };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        button = (ImageView) findViewById(R.id.main_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r = getRandom();
                if (firstPlay) {
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                    firstPlay = false;
                }
                else {
                    mp.stop();
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                }
                mp.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_rate:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    private int getRandom() {
        return new Random().nextInt(46);
    }
}

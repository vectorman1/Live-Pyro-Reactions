package com.bulgarianinnovation.livepyroreaction;

import android.graphics.Typeface;
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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean firstPlay = true;
    private ImageView button;
    private MediaPlayer mp;
    private SoundPool sp;
    private TextView tv;
    private TextView credit;
    private int[] rawRef = { R.raw.quote1, R.raw.quote2, R.raw.quote3, R.raw.quote4, R.raw.quote5, R.raw.quote6,
                             R.raw.quote7, R.raw.quote8, R.raw.quote9, R.raw.quote10, R.raw.quote11, R.raw.quote12,
                             R.raw.quote13, R.raw.quote14, R.raw.quote15, R.raw.quote16, R.raw.quote17, R.raw.quote18,
                             R.raw.quote19, R.raw.quote20, R.raw.quote21, R.raw.quote22, R.raw.quote23, R.raw.quote24,
                             R.raw.quote25, R.raw.quote26, R.raw.quote27, R.raw.quote28, R.raw.quote29, R.raw.quote30,
                             R.raw.quote31, R.raw.quote32, R.raw.quote33, R.raw.quote34, R.raw.quote35, R.raw.quote36,
                             R.raw.quote37, R.raw.quote38, R.raw.quote39, R.raw.quote40, R.raw.quote41, R.raw.quote42,
                             R.raw.quote43, R.raw.quote44, R.raw.quote45 };

    private String[] quoteText = {
            "Do you smoke weed?", //1
            "Crying in the corner for 2 weeks straight.", //2
            "This kid's going next level, clearly.", //3
            "This could actually be runners-up for one of the saddest YouTube videos I've ever watched.", //4
            "You want to keep that out of public eye.", //5
            "That alone is just amazing.", //6
            "This cringe, it needs to be contained because it's just going to kill us all at this rate.", //7
            "These names, they're so like, overly descriptive.", //8
            "I can already feel the cringe building up in my body.", //9
            "I actually want to die. Kill me please, kill me.", //10
            "Ah, this is great, already 5 seconds in and I've got to bite my fist.", //11
            "Congratulations, you played yourself.", //12
            "This has been on so many different websites.", //13
            "He is a meme.", //14
            "Be sure to like that video.", //15
            "I honestly don't understand.", //16
            "It makes about as much sense as this.", //17
            "What?! There's a pedophile inside the studio?", //18
            "I gave it an overall meme/10 IGN rating", //19 --
            "That was a sympathy like by the way, a like out of sympathy.", //20
            "I present to you, the roasting of Pyrocynical.", //21
            "Both should just be put to the electric chair.", //22
            "There is no way I am not going to make a video on you, let's be fair.", //23 --
            "I've been given death threats on the Internet, by kids.", //24
            "Legally I can't call the police on him now.", //25
            "No no, no more.", //26
            "Guys, I smoke tea but I am trying to come off it you know? I got my tea patches on my arm.", //27
            "I am not giving into the addiction.", //28
            "He'll be smoking a literal teabag of weed.", //29
            "Someone please make me a Chrome extension where they click on my face and it says various quotes that I've said.", //30
            "Just take your existence and end it this evening, mate.", //31
            "I am still on-guard.. Alerts still raised on that topic.", //32
            "In other countries you've got wars raging on, people losing their homes, their lives, their money, everything. And in other countries you've just got this kid sitting on his computer.", //33
            "Give me a small loan of a million dollars.", //34
            "No fun allowed.", //35 --
            "Let people do what they want and if everyone is enjoying themselves then everyone is better off.", //36
            "You need to sit down with a big piece of paper, titled \"My Life\" and just rethink it all, mate.", //37
            "It has reached the point where it hurts to wake up at the morning", //38
            "I am actually really terrified.", //39
            "There it is! There it is! ANOTHER ONE! ANOTHER ONE!", //40
            "Now, I can't complain.", //41
            "Much love, much love.", //42
            "Oh... Oh... No... No...", //43
            "There's at least a 100% chance I'll lose my life if this continues.", //44
            "Mom, come look at this. Come look at this." //45
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Typeface tfc = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/cardif.TTF");


        button = (ImageView) findViewById(R.id.main_button);
        tv = (TextView) findViewById(R.id.text_quote);
        credit = (TextView) findViewById(R.id.credit);

        tv.setTypeface(tfc);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                credit.setVisibility(View.VISIBLE);
                int r = getRandom();
                if (firstPlay) {
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                    firstPlay = false;
                } else {
                    mp.stop();
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                }
                tv.setText(String.format("\"%s\"", quoteText[r]));
                mp.start();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        }
        return super.onOptionsItemSelected(item);
    }
    private int getRandom() {
        return new Random().nextInt(45);
    }
}

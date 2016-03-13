package com.bulgarianinnovation.livepyroreaction;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
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
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean firstPlay = true;
    private ImageView button;
    private MediaPlayer mp;
    private TextView tv;
    private TextView credit;
    private int[] rawRef = { R.raw.quote1, R.raw.quote2, R.raw.quote3, R.raw.quote4, R.raw.quote5, R.raw.quote6,
                             R.raw.quote7, R.raw.quote8, R.raw.quote9, R.raw.quote10, R.raw.quote11, R.raw.quote12,
                             R.raw.quote13, R.raw.quote14, R.raw.quote15, R.raw.quote16, R.raw.quote17, R.raw.quote18,
                             R.raw.quote19, R.raw.quote20, R.raw.quote21, R.raw.quote22, R.raw.quote23, R.raw.quote24,
                             R.raw.quote25, R.raw.quote26, R.raw.quote27, R.raw.quote28, R.raw.quote29, R.raw.quote30,
                             R.raw.quote31, R.raw.quote32, R.raw.quote33, R.raw.quote34, R.raw.quote35, R.raw.quote36,
                             R.raw.quote37, R.raw.quote38, R.raw.quote39, R.raw.quote40, R.raw.quote41, R.raw.quote42,
                             R.raw.quote43, R.raw.quote44, R.raw.quote45, R.raw.quote46, R.raw.quote47, R.raw.quote48,
                             R.raw.quote49, R.raw.quote50, R.raw.quote51, R.raw.quote52, R.raw.quote53, R.raw.quote54,
                             R.raw.quote55, R.raw.quote56, R.raw.quote57, R.raw.quote58, R.raw.quote59, R.raw.quote60,
                             R.raw.quote61, R.raw.quote62, R.raw.quote63, R.raw.quote64, R.raw.quote65, R.raw.quote66,
                             R.raw.quote67, R.raw.quote68, R.raw.quote69 };

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
            "You need to sit down with a big piece of paper, titled \"Your Life\" and just rethink it all, mate.", //37
            "It has reached the point where it hurts to wake up at the morning", //38
            "I am actually really terrified.", //39
            "There it is! There it is! ANOTHER ONE! ANOTHER ONE!", //40
            "Now, I can't complain.", //41
            "Much love, much love.", //42
            "Oh... Oh... No... No...", //43
            "There's at least a 100% chance I'll lose my life if this continues.", //44
            "Mom, come look at this. Come look at this.", //45
            "I'm just a misunderstood 14-year-old, just leave me alone guys.", //46
            "Don't let negativity bring you down, it's not worth it. I hope you are OK.", //47
            "No one gives one, mate.", //48
            "Who is this person?", //49
            "My child has sexual fantasies about anthropomorphic tails. Please just kill me.", //50
            "So congratulations, you're not the bottom of the gene pool. You're just incredibly close to it.", //51
            "What's that son? You've got crippling depression and you want to kill yourself? Just get some bubble liquid and you'll make everything better.", //52
            "It's so bad!", //53
            "But little did they know, Pyro was the killer.", //54
            "I do speak the ruski, yes.", //55
            "It's amazing how we haven't all killed ourselves yet.", //56
            "It's about as depressing as it sounds honestly.", //57
            "That is a pedo, that is a pedo, hiding in a bush, with his loudspeaker.", //58
            "They seem way too overenthusiastic.", //59
            "I'm pretty sure I'd be put on DramaAlert if I did that, just saying.", //60
            "Yeah it looks like a blast you know, running around in circles.", //61
            "I could be inside, gettin my double XP on Call of Duty.", //62
            "I'm just a middle-aged man in a park, filming kids.", //63
            "You need the kazoo. If you can't take part in this episode, you're a fucking faggot, you should just go kill yourself.", //64
            "I love to stab people in GTA Online.", //65
            "Ah, it's so good!", //66
            "Lalala follow me into the woods. Lalala don't tell your parents where you are. Lalala show me your penis. Lalala...", //67
            "You're gonna wish you never asked.", //68
            "You can just feel the pure alpha-male, radiating from this man." //69
    };
    public int r;
    public ClipboardManager clipboardManager;
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
        clipboardManager = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        tv.setTypeface(tfc);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit.setVisibility(View.VISIBLE);
                r = getRandom();
                if (firstPlay) {
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                    firstPlay = false;
                } else {
                    mp.stop();
                    mp.release();
                    mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
                }
                tv.setText(String.format("\"%s\"", quoteText[r]));
                mp.start();
            }
        });
    }
    private int getRandom() {
        return new Random().nextInt(69);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_rate:
                rateApp();
                break;
            case R.id.action_share:
                shareQuote();
                break;
            case R.id.action_replay:
                replayQuote();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void replayQuote() {
        if (!firstPlay && !mp.isPlaying()) {
            mp = MediaPlayer.create(getApplicationContext(), rawRef[r]);
            mp.start();
        }
    }

    private void shareQuote() {
        /*if (!firstPlay) {
            ClipData clipData = ClipData.newPlainText("quote", quoteText[r] + "\n" + "- Pyrocynical");
            clipboardManager.setPrimaryClip(clipData);
            Toast.makeText(MainActivity.this, "Quote added to clipboard.", Toast.LENGTH_SHORT).show();
        }*/
        if (!firstPlay) {
            Intent share = new Intent(Intent.ACTION_SEND);
            share.putExtra(Intent.EXTRA_TEXT, quoteText[r] + "\n" + "- Pyrocynical");
            share.setType("text/plain");
            startActivity(Intent.createChooser(share, "Share to:"));
        }
    }

    public void rateApp()
    {
        try
        {
            Intent rateIntent = rateIntentForUrl("market://details");
            startActivity(rateIntent);
        }
        catch (ActivityNotFoundException e)
        {
            Intent rateIntent = rateIntentForUrl("http://play.google.com/store/apps/details");
            startActivity(rateIntent);
        }
    }
    private Intent rateIntentForUrl(String url)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(String.format("%s?id=%s", url, getPackageName())));
        int flags = Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_MULTIPLE_TASK;
        if (Build.VERSION.SDK_INT >= 21)
        {
            flags |= Intent.FLAG_ACTIVITY_NEW_DOCUMENT;
        }
        else
        {
            //noinspection deprecation
            flags |= Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET;
        }
        intent.addFlags(flags);
        return intent;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.exit(0);
    }
}

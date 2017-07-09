package com.jokedisplayer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    public static final String JOKE_EXTRA = DisplayActivity.class.getSimpleName() + ".jokextra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        String joke = getIntent().getStringExtra(JOKE_EXTRA);
        ((TextView) findViewById(R.id.textView)).setText(joke);
    }
}

package com.fydp.yuvan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Yuvan on 16-01-23.
 */
public class Login extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        String username = getIntent().getStringExtra("Username");

        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(username);
    }

    public void logoutClick(View v)
    {
        if (v.getId() == R.id.Blogout)
        {
            Intent i = new Intent(Login.this, MainActivity.class);
            startActivity(i);
        }
    }
}

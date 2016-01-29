package com.fydp.yuvan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    DatabaseHelper helper = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void loginClick(View v)
    {
        if (v.getId() == R.id.Blogin)
        {
            EditText a = (EditText) findViewById(R.id.TFusername);
            String user = a.getText().toString();

            EditText b = (EditText) findViewById(R.id.TFpassword);
            String pass = b.getText().toString();

            String password = helper.searchPassword(user);

            if (pass.equals(password))
            {
                Intent i = new Intent(MainActivity.this, Login.class);
                i.putExtra("Username", user);
                startActivity(i);
            }

            else
            {
                //pop-up message
                Toast temp = Toast.makeText(MainActivity.this, "Username or Password is incorrect.", Toast.LENGTH_SHORT);
                temp.show();
            }
        }
    }

    public void createClick(View v)
    {
        if (v.getId() == R.id.Bcreate)
        {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
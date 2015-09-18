package com.example.richard.parcial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenuActivity extends Activity {
    private String incomingMessage;
    private TextView welcomeMessageText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        welcomeMessageText = (TextView) findViewById(R.id.welcome_message);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        incomingMessage = extras.getString("user");
        this.setWelcomeMessage(incomingMessage);
    }

    public void setWelcomeMessage(String string){
        welcomeMessageText.setText(getResources().getString(R.string.welcomeMessageString) + ' ' + string);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClickHandler(View view){
        String whereToGo = view.getTag().toString();
        Intent intent = new Intent("com.example.richard.parcial." + whereToGo);
        startActivity(intent);
    }
}

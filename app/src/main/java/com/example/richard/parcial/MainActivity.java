package com.example.richard.parcial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
    private final String USUARIO = "admin";
    private final String PASS = "admin";
    private String username, password;
    private int counter = 7;
    EditText loginUserEdit, loginPassEdit;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginUserEdit = (EditText) findViewById(R.id.user);
        loginPassEdit = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);
    }

    public void handleClickAction(View view){
        username = loginUserEdit.getText().toString();
        password = loginPassEdit.getText().toString();
        this.authenticate(username, password);
    }

    private void authenticate(String username, String Password){
        Intent menuIntent = new Intent(this, MenuActivity.class);
        if(username.equals(this.USUARIO) && password.equals(this.PASS)){
            menuIntent.putExtra("user", username);
            Toast.makeText(getApplicationContext(), R.string.redirecting, Toast.LENGTH_SHORT).show();
            startActivity(menuIntent);
        }else{
            counter--;
            if(counter <= 0){
                loginButton.setEnabled(false);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

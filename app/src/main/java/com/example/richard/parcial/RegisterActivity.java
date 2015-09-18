package com.example.richard.parcial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class RegisterActivity extends Activity {

    private Spinner typeSpinner, sexSpinner;
    private EditText registerName, registerPhone, registerBirth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        typeSpinner = (Spinner) findViewById(R.id.contact_type);
        sexSpinner = (Spinner) findViewById(R.id.contact_sex);
        registerName = (EditText) findViewById(R.id.register_contact_name);
        registerPhone = (EditText) findViewById(R.id.register_contact_phone);
        registerBirth = (EditText) findViewById(R.id.register_contact_birth);
        this.setSpinnerAdapter(typeSpinner, R.array.register_contact_type);
        this.setSpinnerAdapter(sexSpinner, R.array.register_contact_sex);
    }

    private void setSpinnerAdapter(Spinner spinner, int arr){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, arr, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);
    }

    public void guardar(){}

    public void limpiarCampos(View v){
        registerName.setText("");
        registerPhone.setText("");
        registerBirth.setText("");
    }

    public void regreso(View view){
        this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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

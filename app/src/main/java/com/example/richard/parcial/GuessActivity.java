package com.example.richard.parcial;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GuessActivity extends Activity {

    private int numero_aleatorio;
    private int oportunidades;

    private EditText campo_numero;
    private TextView texto_mensaje;
    private Button boton_adivinar;
    private Button boton_reiniciar;
    private TextView texto_instrucciones, texto_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess);

        campo_numero = (EditText) findViewById(R.id.numeroAleatorio);
        texto_mensaje = (TextView) findViewById(R.id.mensaje);
        boton_adivinar = (Button) findViewById(R.id.botonAdivinar);
        boton_reiniciar = (Button) findViewById(R.id.botonReiniciar);
        texto_instrucciones = (TextView) findViewById(R.id.instrucciones);
        texto_hint = (TextView) findViewById(R.id.hint);

        comenzarJuego();
    }

    public void reiniciarJuego(View v) {
        comenzarJuego();
    }

    private void comenzarJuego() {
        numero_aleatorio = (int) ((Math.random() * 999) + 1);
        oportunidades = 5;

        campo_numero.setText("");
        texto_mensaje.setText("");

        campo_numero.setVisibility(View.VISIBLE);
        boton_adivinar.setVisibility(View.VISIBLE);
        boton_reiniciar.setVisibility(View.GONE);
        texto_instrucciones.setVisibility(View.VISIBLE);
    }

    private void terminarJuego(){
        campo_numero.setVisibility(View.GONE);
        boton_adivinar.setVisibility(View.GONE);
        boton_reiniciar.setVisibility(View.VISIBLE);
        texto_instrucciones.setVisibility(View.GONE);
    }

    private String hint(int number){
        int resto = Math.abs(numero_aleatorio - number);
        if (resto > 1 && resto <= 10) {
            return "estas muy cerca!";
        }else if(resto > 10 && resto <= 20){
            return "te estas acercando";
        }else{
            return "estas muy lejos";
        }

    }

    public void adivinarNumero(View v) {
        int numero = Integer.parseInt(campo_numero.getText().toString());

        if (numero > 100 || numero < 1) {
            Toast t = Toast.makeText(this, getResources().getString(R.string.guess_no_number), Toast.LENGTH_SHORT);
            t.show();
        } else {
            if (oportunidades > 1) {
                texto_hint.setText(this.hint(numero));
                if (numero == numero_aleatorio) {
                    texto_mensaje.setText(getResources().getString(R.string.guess_gratz));
                    terminarJuego();
                } else {
                    oportunidades--;
                    if (oportunidades == 1) {
                        texto_mensaje.setText(getResources().getString(R.string.guess_last));
                    } else {
                        texto_mensaje.setText(getResources().getString(R.string.guess_opportunity_first) + ' ' + oportunidades + ' ' + getResources().getString(R.string.guess_opportunity_last));
                    }
                }
            } else {
                texto_mensaje.setText(getResources().getString(R.string.guess_sorry) + ' ' + numero_aleatorio);
                texto_hint.setText("");
                terminarJuego();
            }
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guess, menu);
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

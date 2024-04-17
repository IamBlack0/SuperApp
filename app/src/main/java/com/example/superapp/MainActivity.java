package com.example.superapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.superapp.Dialog.CustomDialog;

import java.util.List;

import kotlin.collections.ArrayDeque;


public class MainActivity extends AppCompatActivity {
    EditText txtNum1;
    EditText txtNum2;
    EditText txtNum3;

    RadioButton diurno;
    RadioButton matutino;
    RadioButton nocturno;

    Spinner grupo;

    CheckBox checkboxResultadoEnDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.InicializarControles();
    }

    private void InicializarControles(){
        txtNum1 = (EditText) findViewById(R.id.txtNum1);
        txtNum2 = (EditText) findViewById(R.id.txtNum2);
        txtNum3 = (EditText) findViewById(R.id.txtNum3);
        diurno = (RadioButton) findViewById(R.id.radioDiurno);
        matutino = (RadioButton) findViewById(R.id.radioMatutino);
        nocturno = (RadioButton) findViewById(R.id.radioNocturno);
        checkboxResultadoEnDialog = findViewById(R.id.checkbox);
        grupo = (Spinner) findViewById(R.id.spnGrupo);
        this.LlenarSpinner();

    }







    @SuppressLint("SetTextI18n")
    public void CalcularOperacion(View view) {
        try{
            String nombre = txtNum1.getText().toString();
            int edad =  Integer.parseInt(txtNum2.getText().toString());
            String curso = txtNum3.getText().toString();
            String horario = "";
            String profesor ="Juan Zamora";
            String group = String.format(grupo.getSelectedItem().toString());


            if (diurno.isChecked()) {
                horario = "Diurno";
            } else if (matutino.isChecked()) {
                horario = "Matutino";
            } else if (nocturno.isChecked()) {
                horario = "Nocturno";
            } else {
                Toast.makeText(this, "Manito, elige tu horario mi loco", Toast.LENGTH_SHORT).show();
                return;
            }

           if (checkboxResultadoEnDialog.isChecked()){
               CustomDialog dialog = new CustomDialog("Bienvenido " + nombre + "\nAl curso de " + curso + "\nTienes " + edad + " años\nAdemás tiene un turno en horario " + horario + " en el grupo "+ group + "\nCon el profesor " + profesor);
               dialog.show(getSupportFragmentManager(), "TAB");

               dialog.show(getSupportFragmentManager(),"tag");

               checkboxResultadoEnDialog.setChecked(false);

           }else{
               CustomDialog dialog = new CustomDialog("Bienvenido " + nombre + "\nAl curso de " + curso + "\nTienes " + edad + " años\nAdemás tiene un turno en horario " + horario + " en el grupo "+ group);
               dialog.show(getSupportFragmentManager(), "TAB");
               dialog.show(getSupportFragmentManager(),"tag");

               checkboxResultadoEnDialog.setChecked(false);
           }


        }
        catch (Exception e)
        {
            Toast.makeText(this,"Error, Escoge una opcion",  Toast.LENGTH_SHORT).show();
        }
    }

    private List<String> ObtenerNumero(){
        List<String> numero = new ArrayDeque<>();
        numero.add("1LS131");
        numero.add("1LS132");
        numero.add("1LS133");
        numero.add("1LS134");
        numero.add("1LS135");
        numero.add("1LS136");
        numero.add("1LS137");
        numero.add("1LS138");
        numero.add("1LS139");
        numero.add("1LS140");
        return numero;
    }

    private void LlenarSpinner(){
        List<String> numero = this.ObtenerNumero();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, numero);
        grupo.setAdapter(adapter);
    }
}

package com.example.appsaludar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText txt_Nombre;
    EditText txt_Edad;
    EditText txt_Celular;
    EditText txt_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_Nombre= findViewById(R.id.txtNombre);
        txt_Edad= findViewById(R.id.txtEdad);
        txt_Celular=findViewById(R.id.txtCelular);
        txt_email=findViewById(R.id.txtEmail);
    }
    public void saludar(View view){
        if(validarCampos()){
            Toast.makeText(this,"Hola "+getNombre() + ", eres un "+comprobarEdad(), Toast.LENGTH_LONG).show();

        }
    }
    public String getNombre(){
        return txt_Nombre.getText().toString();
    }
    public int getEdad(){
        return Integer.parseInt(txt_Edad.getText().toString());
    }
    public String getCelular(){
        return txt_Celular.getText().toString();
    }
    public String getEmail(){
        return txt_email.getText().toString();
    }
    public boolean validarCampos(){
        if(getNombre().isEmpty()){
            txt_Nombre.setError("campo requerido");
            return false;
        }
        if(getCelular().isEmpty()){
            txt_Celular.setError("campo requerido");
            return false;
        }
        if(txt_Edad.getText().toString().isEmpty()){
            txt_Edad.setError("campo requerido");
            return false;
        }
        if(getEmail().isEmpty()){
            txt_email.setError("campo requerido");
            return false;
        }
        if(getEdad()<0 && getEdad()>99){
            txt_Edad.setError("ingrese edad entre 0 a 99");
            return false;
        }
        if(getNombre().length()>50){
            txt_Nombre.setError("cantidad de caracteres debe ser menor que 50");
            return false;
        }
        if(getCelular().length()!=9){
            txt_Celular.setError("cantidad de digitos debe ser igual a 9");
            return false;
        }
        if(!validarCorreo(getEmail())){
            txt_email.setError("correo no valido");
            return false;
        }

        return true;
    }

    boolean validarCorreo(String email){
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    String comprobarEdad(){
        if(getEdad()>=0 && getEdad()<=2){
            return "eres un bebe";
        }
        else if (getEdad()>=3 && getEdad()<=12){
            return "eres un niño";
        } else if (getEdad()>=13 && getEdad()<=18) {
            return "eres un adolescente";
        } else if (getEdad()>=19 && getEdad()<=50) {
            return "eres un adulto";
        } else if (getEdad()>50) {
            return "eres un anciano";
        }
        return "";
    }
    }
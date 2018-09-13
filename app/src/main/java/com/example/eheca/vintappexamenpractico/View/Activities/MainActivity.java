package com.example.eheca.vintappexamenpractico.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.eheca.vintappexamenpractico.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Ir a Proyectos
    public void proyectos(View view){
        startActivity(new Intent(this, Proyectos.class));
    }
}

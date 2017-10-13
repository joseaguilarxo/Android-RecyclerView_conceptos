package com.joseaguilar.recyclerview_en_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joseaguilar.recyclerview_en_activity.Adapters.AdapterRecycler;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //RECYCLER VIEW (SIMPLE Y GRILLA) EN UNA ACTIVIDAD
    // La secuencia de la programacion de esto se basa en lo siguiente:
    // 1ro: Añadir dependencia : com.android.support:recyclerview-v7:x.x.x  (en las "x" va la version de tu build.gradle)
    // 2do: Crear un Layout .xml , como molde --> todo lo que vaya aca se mostrara en el recycler
    // 2do: Crear y Programar el ADAPTER (se recomienda crear un adapter por cada elemento que va a utilizar: " AdapterPersona-AdapterRopa")
    // 3ro: Programar La Actividad

    //-------------ANTES DE SEGUIR LOS SIGUIENTES PASOS, TIENE QUE ESTAR TERMINADO EL ADAPTER---------------------

    //Una vez ya hecho todo en el Adapter, pasaremos en programar la actividad.
    // Paso 1: Creamos ArrayList<String>  y creamos la referencia entre molde y recyclerview
    ArrayList<String> listDatos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =(RecyclerView)findViewById(R.id.RecyclerId);

        //Paso 2: Establecemos formato en la que tendra nuestro recyclerview
        //recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));  //De esta forma nuestro recyclerview en este caso tiene el formato simple de forma horizontal - vertical
        recyclerView.setLayoutManager(new GridLayoutManager(this,2)); //De esta forma nuestro recyclerview tendra la forma de lista de grilla en 2 segmentos


        //Paso 3: Ahora presentamos la informacion en el recycler
        listDatos= new ArrayList<>();
        for (int i =0;i<=50;i++){
            listDatos.add("DATO: "+i+"");
        }

        //Paso 4: enviamos los datos al adaptador
        AdapterRecycler adapter = new AdapterRecycler(listDatos);
        // Paso 5: enviamos datos al recycler
        recyclerView.setAdapter(adapter);
    }
}

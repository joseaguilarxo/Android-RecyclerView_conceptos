package com.joseaguilar.recyclerview_en_activity.Adapters;

/*
* Paso 1: Lo primero que se tiene que hacer es realizar un extends recyclerView.Adapter<"nombreaclaseadapter.ViewHolderXXX">(En xxx va el nombre que deseas)
* Paso 2: Los errores pediran implementar una serie de metodos , importar
* Paso 3: Crear Arraylist  para hacer referencia a la lista del molde ; se le crea su constructor
* Paso 4: Vinculamos elemento del molde con el recyclerview (Ir a ViewHolderDatos)
* Paso 5: Referenciamos elemento del molde con el adaptador (Ir a onCreateViewHolder)
* Paso 6: Ahora configuramos el getItemCount para que recepcione la cantidad de datos recibira en la listaDatos (Ir a getItemcount)
* Paso 7: Ahora establecemos la conexion entre onBindViewHolder y ViewHolderDatos (Ir a onBindViewHolder)
*
* ----Hasta aca ya estaria terminado la creacion del adapter para el RecyclerView simple.
*  Ahora tenemos que ir al MainActivity
* */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.joseaguilar.recyclerview_en_activity.R;

import java.util.ArrayList;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.ViewHolderDatos> {

    ArrayList<String> listaDatos;

    public AdapterRecycler(ArrayList<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    //-------------------------------------------------------------------------------------
    //Apartado onCreateViewHolder: vincula el elemento del molde con el adaptador
    @Override
    public AdapterRecycler.ViewHolderDatos onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.molde_recyclerview,null,false);
        return  new ViewHolderDatos(view);

    }
    //-------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------
    //Apartado onBindViewHolder: es el encargado de realizar la conexion de nuestro adaptador con la clase ViewHolderDatos
    @Override
    public void onBindViewHolder(AdapterRecycler.ViewHolderDatos holder, int position) {
holder.asignarDatos(listaDatos.get(position));
    }
    //-------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------
    //Apartado getItemCount: realiza el conteo de elementos que tenga la lista
    @Override
    public int getItemCount() {
        return listaDatos.size();
    }
    //-------------------------------------------------------------------------------------


    //-------------------------------------------------------------------------------------
    //APARTADO ViewHolderDatos: este apartado es el mas importante , ya que esta es una referencia a la clase donde lanzaremos el recyclerview
    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView dato;
        public ViewHolderDatos(View itemView) {
            super(itemView);
            dato=(TextView)itemView.findViewById(R.id.idDato);
        }

        public void asignarDatos(String datos) {
            dato.setText(datos);
        }
    }
    //-------------------------------------------------------------------------------------
}

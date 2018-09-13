package com.example.eheca.vintappexamenpractico.View.Adapters;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.eheca.vintappexamenpractico.Model.Construccion;
import com.example.eheca.vintappexamenpractico.R;
import com.example.eheca.vintappexamenpractico.ViewModel.ConstruccionViewModel;
import com.example.eheca.vintappexamenpractico.databinding.ItemListProyectoBinding;

import java.util.List;

//Esta clase sirve para mostrar en forma de lista las Construcciones en el reciclerView
public class ConstruccionAdapter  extends Adapter<ConstruccionAdapter.ConstruccionViewHolder>{
    //Recibe la lista de construcciones que va a ser mostrada
    private Activity parent;
    private List<Construccion> construcciones;
    public ConstruccionAdapter(Activity parent, List<Construccion> construcciones){
        this.parent = parent;
        this.construcciones = construcciones;
    }
    public void setConstrucciones(List<Construccion> construcciones){
        this.construcciones = construcciones;
        notifyDataSetChanged();
    }

    //Ayuda a inflar los objetos que aparecerán en la lista de construcciones
    @Override
    public ConstruccionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListProyectoBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()), R.layout.item_list_proyecto, parent, false
        );
        return new ConstruccionViewHolder(binding);
    }

    //Enlaza los datos de las construcciones
    @Override
    public void onBindViewHolder(@NonNull ConstruccionViewHolder holder, int position) {
        ItemListProyectoBinding binding = holder.getBinding();
        Construccion construccion = construcciones.get(position);

        //Crea una instacia de la Vista Modelo de objeto construcción
        //Establece la vista modelo en el enlace de datos
        binding.setCVM(new ConstruccionViewModel(parent , construccion));
    }
    //Regresa el tamaño total de la lista
    @Override
    public int getItemCount() {
        return construcciones.size();
    }

    //Esta clase es el ViewHolder de clase ConstruccionAdapter
    public static class ConstruccionViewHolder extends ViewHolder{
        ItemListProyectoBinding binding;
        public ConstruccionViewHolder(ItemListProyectoBinding binding){
            super(binding.cardProyecto);
            this.binding = binding;
        }
        public ItemListProyectoBinding getBinding(){
            return binding;
        }
    }
}

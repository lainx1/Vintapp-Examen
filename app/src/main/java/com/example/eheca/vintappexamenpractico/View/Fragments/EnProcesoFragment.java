package com.example.eheca.vintappexamenpractico.View.Fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eheca.vintappexamenpractico.Data.GetRest;
import com.example.eheca.vintappexamenpractico.Model.Construccion;
import com.example.eheca.vintappexamenpractico.R;
import com.example.eheca.vintappexamenpractico.View.Adapters.ConstruccionAdapter;
import com.example.eheca.vintappexamenpractico.databinding.FragmentEnProcesoBinding;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;

import java.util.ArrayList;

//Este Fragmento muestra las construcciones que se encuentran en proceso
public class EnProcesoFragment extends Fragment {
    //Declara ConstruccionAdaoter para agregarlo al RecyclerView mas tarde
    private ConstruccionAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Crea una instancia de ConstruccionAdapter
        adapter = new ConstruccionAdapter(getActivity(), new ArrayList<Construccion>());

        //Muestra las Construcciones en el RecyclerView

        FragmentEnProcesoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_en_proceso, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(binding.getRoot().getContext());

        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        //Ejecuta la consulta de las construcciones
        GetRest getRest = new GetRest(new GetRest.AlTerminarInterface() {
            @Override
            public void alTerminar(ArrayList<Construccion> construcciones) {
                ArrayList<Construccion> finalizados = new ArrayList<>();
                finalizados.addAll(construcciones);
                //Filtra las construcciones para mostrar solaménte las finalizadas
                CollectionUtils.filter(finalizados, new Predicate<Construccion>() {
                    @Override
                    public boolean evaluate(Construccion construccion) {
                        return construccion.getStatus().equals("Process");
                    }
                });

                adapter.setConstrucciones(finalizados);
            }
        });
        getRest.execute();
    }

}

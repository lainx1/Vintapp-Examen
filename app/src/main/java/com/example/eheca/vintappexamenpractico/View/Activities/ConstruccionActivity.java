package com.example.eheca.vintappexamenpractico.View.Activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.eheca.vintappexamenpractico.Model.Construccion;
import com.example.eheca.vintappexamenpractico.R;
import com.example.eheca.vintappexamenpractico.ViewModel.ConstruccionViewModel;
import com.example.eheca.vintappexamenpractico.VintappExamenApp;
import com.example.eheca.vintappexamenpractico.databinding.ActivityConstruccionBinding;

public class ConstruccionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Enlaza la Activity con ConstruccionViewModel
        ActivityConstruccionBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_construccion);

        ConstruccionViewModel CVM = ((VintappExamenApp) getApplication()).getCVM();
        binding.setCVM(CVM);
    }
}

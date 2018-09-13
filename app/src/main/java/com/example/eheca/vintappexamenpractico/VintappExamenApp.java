package com.example.eheca.vintappexamenpractico;

import android.app.Application;

import com.example.eheca.vintappexamenpractico.ViewModel.ConstruccionViewModel;

public class VintappExamenApp extends Application {
    //Esta clase ayuda a pasar el ConstruccionViewModel hacia ConstruccionActivity
    private ConstruccionViewModel CVM;
    public VintappExamenApp(){}
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public ConstruccionViewModel getCVM() {
        return CVM;
    }

    public void setCVM(ConstruccionViewModel CVM) {
        this.CVM = CVM;
    }
}

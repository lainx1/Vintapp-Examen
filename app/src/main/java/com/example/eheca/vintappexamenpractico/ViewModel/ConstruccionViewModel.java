package com.example.eheca.vintappexamenpractico.ViewModel;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.eheca.vintappexamenpractico.Model.Construccion;
import com.example.eheca.vintappexamenpractico.View.Activities.ConstruccionActivity;
import com.example.eheca.vintappexamenpractico.VintappExamenApp;

import org.joda.time.LocalDate;

import java.text.DecimalFormat;

public class ConstruccionViewModel extends BaseObservable{

    private Construccion construccion;
    private Activity parent;
    //Recibe una instancia del objeto construcción
    public ConstruccionViewModel(Activity parent, Construccion construccion){
        this.parent = parent;
        this.construccion = construccion;
    }
    //Muestra el nombre de la construccion
    @Bindable
    public String getNombre(){
        return construccion.getNombre();
    }
    //Miestra el año de finalización
    @Bindable
    public String getAFinalizacion(){
        return  "Año de finalización: " + construccion.getaFinalizacion();
    }
    //Muestra el área de la construccion
    @Bindable
    public String getArea(){
        return  "Área: " + construccion.getArea() + " m2";
    }
    //Muestra el precio de la construccion
    @Bindable
    public String getPrecio(){
        //Formatea el precio a dos decimales
        DecimalFormat df  = new DecimalFormat("#.00");
        return "Cotización: $" + df.format(construccion.getPrecio());
    }
    //Devuelve la url de la imagen de la construccion
    @Bindable
    public String getPreview(){
        return construccion.getGaleria().get(0);
    }

    //Muestra la vista previa de la construcción
    @BindingAdapter({"app:image"})
    public static void loadPreview(ImageView view, String preview){
        Glide.with(view.getContext())
                .load(preview)
                .centerCrop()
                .into(view);
    }
    //Obtiene la descripcion 1
    @Bindable
    public String getDescripcion1(){
        return construccion.getDescripcion().get(0) == null ? "" : construccion.getDescripcion().get(0);
    }
    //Obtiene la descripcion 2
    @Bindable
    public String getDescripcion2(){
        return construccion.getDescripcion().get(1) == null ? "" : construccion.getDescripcion().get(1);
    }
    //Obtiene la descripcion 3
    @Bindable
    public String getDescripcion3(){
        return construccion.getDescripcion().get(2) == null ? "" : construccion.getDescripcion().get(2);
    }
    //Obtiene el beneficio 1
    @Bindable
    public String getBeneficio1(){
        return construccion.getBeneficios().get(0) == null ? "" : construccion.getBeneficios().get(0);
    }
    //Obtiene el beneficio 2
    @Bindable
    public String getBeneficio2(){
        return construccion.getBeneficios().get(1) == null ? "" : construccion.getBeneficios().get(1);
    }
    //Obtiene el beneficio 3
    @Bindable
    public String getBeneficio3(){
        return construccion.getBeneficios().get(2) == null ? "" : construccion.getBeneficios().get(2);
    }
    //Obtiene la licencia
    @Bindable
    public String getLicencia(){
        return "Licencia: " + construccion.getLicencia();
    }
    //Obtiene la constructora
    @Bindable
    public String getConstructora(){
        return "Constructora: " + construccion.getConstructora();
    }
    //Obtiene la fecha de entrega
    @Bindable
    public String getFechaEntrega(){
        LocalDate fecha = construccion.getEntregaProgramada();
        return "Entrega programada: " + fecha.getDayOfMonth() + " de " + fecha.getMonthOfYear() + " del " + fecha.getYear();
    }
    //Obtiene el avance de la obra
    @Bindable
    public String getAvance(){
        return "Avance de la obra: % " + construccion.getAvance();
    }
    //Obtiene la ubicacion
    @Bindable
    public String getUbicacion(){
        return construccion.getUbicacion();
    }
    //Muestra los detalles de a construccion
    public void irADetalles(View view){
        ((VintappExamenApp)parent.getApplication()).setCVM(this);
        view.getContext().startActivity(new Intent(view.getContext(), ConstruccionActivity.class));
    }
}

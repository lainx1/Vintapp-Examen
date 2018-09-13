package com.example.eheca.vintappexamenpractico.Data;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import com.example.eheca.vintappexamenpractico.Model.Construccion;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

//Esta clase consume el API Rest
public class GetRest extends AsyncTask<Void, Void, ArrayList<Construccion>>{
    //Url del Api rest
    public String sql = "https://chapin.vintapp.mx/projectsNoLogin";
    private AlTerminarInterface alTerminarInterface;


    public interface AlTerminarInterface{
        //Esta interfaz se ejecuta al terminar de consumir el API Rest
        void alTerminar(ArrayList<Construccion> construcciones);
    }
    public GetRest(AlTerminarInterface alTerminarInterface){
        this.alTerminarInterface = alTerminarInterface;
    }
    @Override
    protected ArrayList<Construccion> doInBackground(Void... voids) {
        //Crea un nuevo ArrayList para guardar las construcciones del API Rest
        ArrayList<Construccion> construcciones = new ArrayList<>();


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url;
        HttpURLConnection conn;

        try {
            //Crea la conexion hacia el API Rest
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");
            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            StringBuffer response = new StringBuffer();
            String json;

            while ((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            //Crea el Json con los datos para ser utilizados
            json = response.toString();

            JSONArray ja = new JSONArray(json);

            //Obtiene los datos del JSON
            for (int i = 0; i < ja.length(); i++){
                //Crea un JSonObject
                JSONObject jo = ja.getJSONObject(i);
                //Crea un object Construccion
                Construccion construccion = new Construccion();

                //Obtiene los datos del json
                String nombre = jo.getString("name");
                String fecha = jo.getString("limitDate");
                String estado = jo.getString("status");
                String licencia = jo.getString("license");
                String constructora = jo.getString("builder");

                int area = jo.getInt("area");

                Double avamce = jo.getDouble("progress");
                Double cotizacion = jo.getDouble("price");

                JSONArray desc =  jo.getJSONArray("description");
                ArrayList<String> descripcion = new ArrayList<>();
                for (int x = 0; x < desc.length(); x ++){
                    descripcion.add(desc.getString(0));
                }

                JSONArray benef =  jo.getJSONArray("services");
                ArrayList<String> beneficios = new ArrayList<>();
                for (int x = 0; x < benef.length(); x ++){
                    beneficios.add(benef.getString(0));
                }

                JSONArray galeriaJson = jo.getJSONArray("gallery");
                ArrayList<String> galeria = new ArrayList();
                for (int x = 0; x < galeriaJson.length(); x ++){
                    String imagenUrl = "https://chapin.vintapp.mx/" + galeriaJson.getString(x);
                    galeria.add(imagenUrl);
                }

                JSONObject objectoDireccion =  jo.getJSONObject("address");
                String ubicacion = objectoDireccion.getString("suburb");

                //Coloca los valores al objeto Construccion
                construccion.setNombre(nombre);
                construccion.setArea(area);
                construccion.setaFinalizacion(convertirAFecha(fecha).getYear());
                construccion.setEntregaProgramada(convertirAFecha(fecha));
                construccion.setPrecio(cotizacion);
                construccion.setGaleria(galeria);
                construccion.setStatus(estado);
                construccion.setBeneficios(beneficios);
                construccion.setDescripcion(descripcion);
                construccion.setAvance(avamce);
                construccion.setConstructora(constructora);
                construccion.setLicencia(licencia);
                construccion.setUbicacion(ubicacion);
                //Agrega Construcción al ArrayList
                construcciones.add(construccion);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return construcciones;
    }

    @Override
    protected void onPostExecute(ArrayList<Construccion> construcciones) {
        super.onPostExecute(construcciones);
        alTerminarInterface.alTerminar(construcciones);
    }
    //Ayuda a convertir en LocalDate la fecha del JSON
    private LocalDate convertirAFecha(String fecha){
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDate date = org.joda.time.LocalDate.parse(fecha, formatter);
        return date;
    }
}

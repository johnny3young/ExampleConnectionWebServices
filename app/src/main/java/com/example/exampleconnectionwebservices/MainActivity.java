package com.example.exampleconnectionwebservices;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        //Para manejar la conexión SIN ponerla adentro de una FUNCIÓN por lo que no es muy útil
        // no podemos hacer comparaciones (nos limita)
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if (networkInfo != null && networkInfo.isConnected()){
//
//        }else {
//
//        }

        if (isOnLine()){
        //RECORADR que la tarea NO SE DEBE realizar la petición (conexión) en el hilo principal

        }else {
            Toast.makeText(this, "No hay conexión a la red", Toast.LENGTH_SHORT).show();
        }
    }

    //Creamos el MÉTODO para validar la conexión a internet o el recurso requerido
    public boolean isOnLine(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    }

    //Para crear otro hilo, se usa la clase Asyntask
    public class MyTask extends AsyncTask <String, String, String>{


        @Override
        protected String doInBackground(String... strings) {
            String content = null;
            return content;
        }
    }
}

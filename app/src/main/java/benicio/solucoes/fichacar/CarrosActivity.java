package benicio.solucoes.fichacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import benicio.solucoes.fichacar.databinding.ActivityCarrosBinding;
import benicio.solucoes.fichacar.databinding.ActivityMainBinding;

public class CarrosActivity extends AppCompatActivity {

    private static final String TAG = "pimba";
    List<CarroModel> carros = new ArrayList<>();
    ActivityCarrosBinding mainBinding;
    RecyclerView r;
    AdapterCarro adapterCarro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityCarrosBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        carros.add(new CarroModel("Fusca", "https://estacaoraridades.com.br/images/anuncio/volkswagen-fusca-1500-i63t2h/volkswagen-fusca-1500-i63t2h-seq-1-16-classico-0339.jpg", "Motor 1.6L, 4 cilindros", "15000.0"));
        carros.add( new CarroModel("Civic", "https://s2-autoesporte.glbimg.com/8AsyIQCc2_sNbOsJXNUPQI87qYw=/0x0:1920x1080/924x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/U/M/0AQABNTsW6kmItO0mGaQ/sem-titulo.jpg", "Motor 2.0L, 4 cilindros", "60000.0"));
        carros.add(new CarroModel("Gol", "https://s2-autoesporte.glbimg.com/3EgKP_GD7pf7-BmNtHVJT6qg1HU=/0x0:1400x912/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/R/M/K7kos5QGafxzSGEkFP7Q/dsc06181.jpg", "Motor 1.0L, 3 cilindros", "25000.0"));
        carros.add(new CarroModel("Corolla", "https://s2-autoesporte.glbimg.com/ZU8JYXo4qpzgP0zxrzY7VUkx9Bs=/0x0:5000x3547/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2018/1/5/1bt31aS0AZbmStrGk3zQ/corolla-gli-2019.jpg", "Motor 1.8L, 4 cilindros", "70000.0"));
        carros.add(new CarroModel("Jeep Renegade", "https://s2-autoesporte.glbimg.com/ASHCKdg1i7UoXYntmgbtUa5YaJI=/0x0:8340x5560/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/B/q/AYnNw5T7CCtAm9GYue0g/renegade-moab-002.jpeg", "Motor 1.6L, 4 cilindros", "55000.0"));

        r = mainBinding.carrosRecycler;

        r.setLayoutManager(new LinearLayoutManager(this));
        r.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);
        adapterCarro = new AdapterCarro(carros, this);
        r.setAdapter(adapterCarro);

        mainBinding.favoritos.setOnClickListener( view -> startActivity(new Intent(this, FavoritosActivity.class)));


    }

    @SuppressLint("NotifyDataSetChanged")
    public void filtrar(View view){
        String filtro = mainBinding.pesquisa.getText().toString();

        Log.d(TAG, "filtrar2: " + filtro);
        if (!filtro.isEmpty()){
            List<CarroModel> carrosFiltrados = new ArrayList<>();
            for ( CarroModel carro: carros){
                Log.d(TAG, "filtrar2: " + carro.getNomeCarro().trim().toLowerCase());
                Log.d(TAG, "filtrar1: " + filtro.trim().toLowerCase());

                if ( carro.getNomeCarro().trim().toLowerCase().equals(filtro.trim().toLowerCase())){
                    carrosFiltrados.add(carro);
                }
            }

            carros.clear();
            carros.addAll(carrosFiltrados);
            adapterCarro.notifyDataSetChanged();
        }else{
            carros.clear();
            carros.add(new CarroModel("Fusca", "https://estacaoraridades.com.br/images/anuncio/volkswagen-fusca-1500-i63t2h/volkswagen-fusca-1500-i63t2h-seq-1-16-classico-0339.jpg", "Motor 1.6L, 4 cilindros", "15000.0"));
            carros.add( new CarroModel("Civic", "https://s2-autoesporte.glbimg.com/8AsyIQCc2_sNbOsJXNUPQI87qYw=/0x0:1920x1080/924x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/U/M/0AQABNTsW6kmItO0mGaQ/sem-titulo.jpg", "Motor 2.0L, 4 cilindros", "60000.0"));
            carros.add(new CarroModel("Gol", "https://s2-autoesporte.glbimg.com/3EgKP_GD7pf7-BmNtHVJT6qg1HU=/0x0:1400x912/888x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_cf9d035bf26b4646b105bd958f32089d/internal_photos/bs/2022/R/M/K7kos5QGafxzSGEkFP7Q/dsc06181.jpg", "Motor 1.0L, 3 cilindros", "25000.0"));
            carros.add(new CarroModel("Corolla", "https://s2-autoesporte.glbimg.com/ZU8JYXo4qpzgP0zxrzY7VUkx9Bs=/0x0:5000x3547/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2018/1/5/1bt31aS0AZbmStrGk3zQ/corolla-gli-2019.jpg", "Motor 1.8L, 4 cilindros", "70000.0"));
            carros.add(new CarroModel("Jeep Renegade", "https://s2-autoesporte.glbimg.com/ASHCKdg1i7UoXYntmgbtUa5YaJI=/0x0:8340x5560/1008x0/smart/filters:strip_icc()/i.s3.glbimg.com/v1/AUTH_59edd422c0c84a879bd37670ae4f538a/internal_photos/bs/2020/B/q/AYnNw5T7CCtAm9GYue0g/renegade-moab-002.jpeg", "Motor 1.6L, 4 cilindros", "55000.0"));
            adapterCarro.notifyDataSetChanged();
        }
    }
}
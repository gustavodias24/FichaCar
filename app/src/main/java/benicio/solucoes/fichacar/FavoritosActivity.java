package benicio.solucoes.fichacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import benicio.solucoes.fichacar.databinding.ActivityFavoritosBinding;
import benicio.solucoes.fichacar.databinding.ActivityInfosCarroBinding;

public class FavoritosActivity extends AppCompatActivity {

    ActivityFavoritosBinding mainBinding;
    RecyclerView r;
    AdapterCarro adapterCarro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityFavoritosBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        r = mainBinding.carrosRecycler;

        r.setLayoutManager(new LinearLayoutManager(this));
        r.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        r.setHasFixedSize(true);
        List<CarroModel> carros = CarroUtils.returnFav(this);
        if ( carros == null){ carros = new ArrayList<>();}
        adapterCarro = new AdapterCarro(carros, this);
        r.setAdapter(adapterCarro);

    }
}
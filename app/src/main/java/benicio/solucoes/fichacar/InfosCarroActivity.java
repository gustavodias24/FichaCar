package benicio.solucoes.fichacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import benicio.solucoes.fichacar.databinding.ActivityCarrosBinding;
import benicio.solucoes.fichacar.databinding.ActivityInfosCarroBinding;

public class InfosCarroActivity extends AppCompatActivity {

    ActivityInfosCarroBinding mainBinding;
    Bundle b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityInfosCarroBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        b = getIntent().getExtras();

        mainBinding.ficaText.setText(b.getString("dados", ""));
        Picasso.get().load(b.getString("image", "")).into(mainBinding.imagemCarro);

        mainBinding.favoritas.setOnClickListener( view -> {
            List<CarroModel> listaAntiga = CarroUtils.returnFav(this);

            if (listaAntiga == null){
                listaAntiga = new ArrayList<>();
            }

            listaAntiga.add(new CarroModel(b.getString("dados", ""), b.getString("image", ""), "", ""));

            CarroUtils.atualizarFav(listaAntiga, this);

            Toast.makeText(this, "Favoritado", Toast.LENGTH_SHORT).show();
        });
    }
}
package benicio.solucoes.fichacar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import benicio.solucoes.fichacar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        mainBinding.next.setOnClickListener( view -> startActivity(new Intent(this, CarrosActivity.class)));

        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] siglasEstados = {
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR",
                "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, siglasEstados);

        autoCompleteTextView.setAdapter(adapter);


        mainBinding.autoCompleteTextView.setOnClickListener( view -> autoCompleteTextView.showDropDown());
        autoCompleteTextView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedSiglaEstado = (String) parent.getItemAtPosition(position);
            autoCompleteTextView.setText(selectedSiglaEstado);

            Toast.makeText(MainActivity.this, "Estado selecionado: " + selectedSiglaEstado, Toast.LENGTH_SHORT).show();
        });
    }
}
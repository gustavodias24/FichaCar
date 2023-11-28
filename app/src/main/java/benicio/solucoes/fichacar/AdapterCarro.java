package benicio.solucoes.fichacar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class AdapterCarro extends RecyclerView.Adapter<AdapterCarro.MyViewHolder> {

    List<CarroModel> carros;
    Context c;

    public AdapterCarro(List<CarroModel> carros, Context c) {
        this.carros = carros;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.carro_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        CarroModel carro = carros.get(position);

        Picasso.get().load(carro.fotoCarro).into(holder.imageCarro);

        holder.nomeCarro.setText(carro.nomeCarro);

        holder.itemView.getRootView().setOnClickListener( view -> {
            Intent i = new Intent(c, InfosCarroActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.putExtra("dados", carro.toString());
            i.putExtra("image", carro.getFotoCarro());
            c.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return carros.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCarro;
        TextView nomeCarro;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCarro = itemView.findViewById(R.id.imageCarro);
            nomeCarro = itemView.findViewById(R.id.nomeCarro);

        }
    }
}

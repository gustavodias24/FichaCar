package benicio.solucoes.fichacar;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.session.MediaSession;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CarroUtils {
    public static  final String prefs = "carros";
    public static final String name = "favoritos";


    public static void atualizarFav(List<CarroModel> carros , Context c){
        SharedPreferences preferences = c.getSharedPreferences(prefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        Gson gson = new Gson();
        editor.putString(name,gson.toJson(carros)).apply();
    }

    public static List<CarroModel> returnFav(Context c){
        SharedPreferences preferences = c.getSharedPreferences(prefs, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        Type type = new TypeToken<List<CarroModel>>(){}.getType();

        return gson.fromJson(preferences.getString(name, ""), type);
    }
}

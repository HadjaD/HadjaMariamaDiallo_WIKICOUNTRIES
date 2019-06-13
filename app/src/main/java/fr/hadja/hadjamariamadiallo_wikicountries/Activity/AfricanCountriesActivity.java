package fr.hadja.hadjamariamadiallo_wikicountries.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Adapter.CountriesDisplayAdapter;
import fr.hadja.hadjamariamadiallo_wikicountries.Controller.CountriesDisplayController;
import fr.hadja.hadjamariamadiallo_wikicountries.Controller.CountriesDisplayControllerAFRICA;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Continent;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.CountryApi;
import fr.hadja.hadjamariamadiallo_wikicountries.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AfricanCountriesActivity extends AppCompatActivity {

    private RecyclerView countryList;
    private CountriesDisplayAdapter adapter;
    private List<Country> countries = new ArrayList<>();
    String BASE_URL = /*"https://github.com/HadjaD/Android_projet_3AS2_ESIEA/tree/master/"*/"https://restcountries.eu/rest/v2/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_countries_recycler);
        countryList = findViewById(R.id.country_recycler);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        countryList.setAdapter(adapter);
        //Debut de l'affichage des pays
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        CountriesDisplayControllerAFRICA controller = new CountriesDisplayControllerAFRICA(this,
                sharedPreferences, Continent.AFRICA);
        controller.start();

    }

    public void displayCountries(List<Country> countries){
        countryList = findViewById(R.id.country_recycler);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        adapter = new CountriesDisplayAdapter(countries);
        countryList.setAdapter(adapter);

    }
}

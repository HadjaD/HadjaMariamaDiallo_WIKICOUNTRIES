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
        this.countries = new ArrayList<>();
        setContentView(R.layout.all_countries_recycler);
        this.countryList = findViewById(R.id.country_recycler);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        /*ArrayList<String> codes = new ArrayList<>();
        codes.add("224");codes.add("223");
        this.countries.add(new Country("Guinee", "22",
                "Conakry", "Ouest", "Ouest", "10 million",
                "GN", "Zone", "224GN", "https://restcountries.eu/data/png.svg") );

        this.countries.add(new Country("Mali", "223",
                "Conakry", "Ouest", "Ouest", "10 million",
                "GN", "Zone", "224GN", "https://restcountries.eu/data/png.svg") );
        adapter = new CountriesDisplayAdapter(this.countries);
        countryList.setAdapter(adapter);*/
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        CountryApi countryApi = retrofit.create(CountryApi.class);
        Call<List<Country>> call =  countryApi.getAfricanCountries("status:open");
        //countries.add(new Country());

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
                if(response.isSuccessful()) {
                    System.out.println("Taille de la réponse avant:   "+countries.size());
                    countries.addAll(response.body());
                    System.out.println("Taille de la réponse apres:   "+countries.size());

                }else{
                    System.out.println("Reponse non successful:   "+countries.size());
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getApplicationContext(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                countryList.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t)
            {
                t.printStackTrace();
            }
        });


    }

    /*public void displayCountries(List<Country> countries){
        countryList = findViewById(R.id.country_recycler);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        adapter = new CountriesDisplayAdapter(countries);
        countryList.setAdapter(adapter);

    }*/
}

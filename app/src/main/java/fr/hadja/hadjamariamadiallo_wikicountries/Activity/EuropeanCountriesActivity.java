package fr.hadja.hadjamariamadiallo_wikicountries.Activity;

import android.content.Context;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Adapter.CountriesDisplayAdapter;
import fr.hadja.hadjamariamadiallo_wikicountries.Controller.CountriesDisplayController;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Continent;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.R;

public class EuropeanCountriesActivity extends AppCompatActivity {

    private RecyclerView countryList;
    private CountriesDisplayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_countries_recycler);
        //Debut de l'affichage des pays
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        CountriesDisplayController controller = new CountriesDisplayController(this,
                sharedPreferences, Continent.EUROPE);
        controller.start();

    }
    public void displayCountries(List<Country> countries){
        countryList = findViewById(R.id.country_recycler);
        countryList.setLayoutManager(new LinearLayoutManager(this));
        countryList.setHasFixedSize(true);
        countryList.setHasFixedSize(true);
        adapter = new CountriesDisplayAdapter(countries);
        countryList.setAdapter(adapter);

    }

}


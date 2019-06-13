package fr.hadja.hadjamariamadiallo_wikicountries.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Activity.AsianCountriesActivity;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Continent;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.CountryApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesDisplayControllerASIA implements Callback<List<Country>> {
    private AsianCountriesActivity view;
    private SharedPreferences sharedPreferences;
    private Continent continent;
    private Continent cont = null;
    String BASE_URL = "https://restcountries.eu/rest/v2/region/";

    public CountriesDisplayControllerASIA(AsianCountriesActivity view,
                                      SharedPreferences sharedPreferences,
                                      Continent continent) {
        this.view = view;
        this.sharedPreferences = sharedPreferences;
        this.continent = continent;
    }

    public void start() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        CountryApi countryApi = retrofit.create(CountryApi.class);
        Call<List<Country>> call = countryApi.getAsianCountries("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        if (response.isSuccessful()) {
            List<Country> countries = response.body();
            //storeData(countries);
            view.displayCountries(countries);

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Country>> call, Throwable t) {

    }

    private void storeData(List<Country> countries) {
        Gson gson = new Gson();
        String data = gson.toJson(countries);
        sharedPreferences
                .edit()
                .putString("cle_string", data)
                .apply();
    }

    private List<Country> getDataFromCache() {
        String data = sharedPreferences.getString("cle_string", "");
        if (data != null && !TextUtils.isEmpty(data)) {
            Type listType = new TypeToken<List<Country>>() {
            }.getType();
            List<Country> countries = new Gson().fromJson(data, listType);
            return countries;
        }
        return new ArrayList<>();
    }
}


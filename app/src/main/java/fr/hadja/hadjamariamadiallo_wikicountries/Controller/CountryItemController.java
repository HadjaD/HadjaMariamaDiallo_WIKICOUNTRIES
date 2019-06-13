package fr.hadja.hadjamariamadiallo_wikicountries.Controller;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import fr.hadja.hadjamariamadiallo_wikicountries.Activity.CountryItemActivity;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.Country;
import fr.hadja.hadjamariamadiallo_wikicountries.Model.CountryApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountryItemController implements Callback<List<Country>> {

    private CountryItemActivity view;
    private SharedPreferences sharedPreferences;
    private String countryName;
    String BASE_URL = "https://restcountries.eu/rest/v2/";

    public CountryItemController(CountryItemActivity view,
                                 SharedPreferences sharedPreferences,
                                 String countryName) {
        this.sharedPreferences = sharedPreferences;
        this.countryName = countryName;
        this.view = view;
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
        Call<List<Country>> call = countryApi.getCountry(countryName);
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {
        if(response.isSuccessful()) {
            Country country = response.body().get(0);
            storeData(country);
            view.displayCountryInformations(country);
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Country>> call, Throwable t) {
        Country country = getDataFromCache();
        //view.displayCountryInformations(country);
        t.printStackTrace();
    }
    private void storeData(Country country) {
        Gson gson = new Gson();
        String data = gson.toJson(country);
        sharedPreferences
                .edit()
                .putString("cle_string" + countryName, data)
                .apply();
    }

    private Country getDataFromCache() {
        String country = sharedPreferences.getString("cle_string"  + countryName, "");
        if(country != null && !TextUtils.isEmpty(country)){
            Type listType = new TypeToken<Country>(){}.getType();
            Country pays = new Gson().fromJson(country, listType);
            return pays;
        }
        return new Country();
    }
}

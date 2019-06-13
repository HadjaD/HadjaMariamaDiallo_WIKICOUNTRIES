package fr.hadja.hadjamariamadiallo_wikicountries.Model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CountryApi {

    @GET("all")
    Call<List<Country>> getAfricanCountries(@Query("q") String status);
   /* @GET("countries.json")
    Call<List<Country>> getEuropeanCountries();
    @GET("countries.json")
    Call<List<Country>> getAsianCountries();*/
    /*@GET("name")
    Call<Country> getCountry(@Query("q") String country);*/
}

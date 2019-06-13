package fr.hadja.hadjamariamadiallo_wikicountries.Model;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CountryApi {

    @GET("africa")
    Call<List<Country>> getAfricanCountries(@Query("q") String status);
    @GET("europe")
    Call<List<Country>> getEuropeanCountries(@Query("q") String status);
    @GET("asia")
    Call<List<Country>> getAsianCountries(@Query("q") String status);
    @GET("name/{name}")
    Call<List<Country>> getCountry(@Path("name") String country);
}

package com.example.ivan.frommax;
import com.example.ivan.frommax.PersonModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MurzinmaApi {

    @GET("/api/people.php")
    Call<PersonModel> getData();
}

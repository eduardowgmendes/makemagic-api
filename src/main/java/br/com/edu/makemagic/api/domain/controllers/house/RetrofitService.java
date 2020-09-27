package br.com.edu.makemagic.api.domain.controllers.house;

import br.com.edu.makemagic.api.domain.entities.House;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RetrofitService {

    @GET("v1/houses?")
    Call<List<House>> retrieveAllHouses(@Query("key") String key);

}

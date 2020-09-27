package br.com.edu.makemagic.api.domain.controllers.house;

import br.com.edu.makemagic.api.domain.entities.House;
import br.com.edu.makemagic.api.domain.entities.datatransferobject.HouseDTO;
import br.com.edu.makemagic.api.configuration.ExceptionHandling;
import br.com.edu.makemagic.api.exceptions.ObjectNotFoundException;
import br.com.edu.makemagic.api.utils.URIUtils;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HouseService {

    @Autowired
    private HouseRepository repository;

    private RetrofitService retrofitService;

    public HouseService() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URIUtils.UriConstants.BASE_URL).addConverterFactory(GsonConverterFactory.create()).client(httpClient.build()).build();

        retrofitService = retrofit.create(RetrofitService.class);
    }

    public List<HouseDTO> findAllHouses() {
        try {
            Call<List<House>> listCall = retrofitService.retrieveAllHouses(URIUtils.UriConstants.API_KEY);
            Response<List<House>> execute = listCall.execute();
            return execute.body().stream().map(HouseDTO::create).collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException(ExceptionHandling.ERROR_GENERAL);
        }
    }

    public List<HouseDTO> getAllHouses() {
        return repository.findAll().stream().map(HouseDTO::create).collect(Collectors.toList());
    }

    public HouseDTO getHouseById(String id) {
        return repository.findById(id).map(HouseDTO::create).orElseThrow(() -> new ObjectNotFoundException(ExceptionHandling.ERROR_NOT_FOUND));
    }

}

package org.example.retrofit;

import org.example.response.ReniecResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ReniecService {
    
    @GET("/v2/reniec/dni")
    Call<ReniecResponse> getPersonaReniec(
            @Header("Authorization") String token
            , @Query("numero") String numero);
}

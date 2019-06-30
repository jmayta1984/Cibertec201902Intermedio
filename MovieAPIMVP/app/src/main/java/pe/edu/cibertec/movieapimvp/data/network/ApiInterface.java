package pe.edu.cibertec.movieapimvp.data.network;

import pe.edu.cibertec.movieapimvp.data.network.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("?")
    Call<Movie> searchMovie(@Query("apikey") String apikey, @Query("t") String name);

}

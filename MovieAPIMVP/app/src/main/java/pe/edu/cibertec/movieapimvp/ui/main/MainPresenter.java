package pe.edu.cibertec.movieapimvp.ui.main;

import pe.edu.cibertec.movieapimvp.data.network.ApiClient;
import pe.edu.cibertec.movieapimvp.data.network.ApiInterface;
import pe.edu.cibertec.movieapimvp.data.network.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.MainPresenter {

    MainContract.MainView mainView;

    public MainPresenter(MainContract.MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void searchMovie(String name) {
        String apikey = "6fc43ba7";
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Movie> methodSearch = apiInterface.searchMovie(apikey, name);

        methodSearch.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if (response.isSuccessful()) {
                    Movie movie = response.body();
                    MainPresenter.this.mainView.showMovie(movie);
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {

            }
        });
    }
}

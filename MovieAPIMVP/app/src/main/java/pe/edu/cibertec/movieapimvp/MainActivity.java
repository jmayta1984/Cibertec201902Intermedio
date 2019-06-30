package pe.edu.cibertec.movieapimvp;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextInputEditText etMovie;
    Button btSearch;
    TextView tvTitle, tvYear, tvPlot;
    ImageView ivPoster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMovie = findViewById(R.id.etMovie);
        btSearch = findViewById(R.id.btSearch);
        tvTitle = findViewById(R.id.tvTitle);
        tvYear = findViewById(R.id.tvYear);
        tvPlot = findViewById(R.id.tvPlot);

        ivPoster = findViewById(R.id.ivPoster);

        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String apikey = "6fc43ba7";
                String name = etMovie.getText().toString();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://www.omdbapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                MovieInterface movieInterface = retrofit.create(MovieInterface.class);
                Call<Movie> methodSearch = movieInterface.searchMovie(apikey, name);

                methodSearch.enqueue(new Callback<Movie>() {
                    @Override
                    public void onResponse(Call<Movie> call, Response<Movie> response) {
                        if (response.isSuccessful()) {
                            Movie movie = response.body();

                            tvTitle.setText(movie.getTitle());
                            tvYear.setText(movie.getYear());
                            tvPlot.setText(movie.getPlot());

                            Glide.with(MainActivity.this)
                                    .load(movie.getPoster())
                                    .into(ivPoster);
                        }
                    }

                    @Override
                    public void onFailure(Call<Movie> call, Throwable t) {

                    }
                });


            }
        });


    }
}
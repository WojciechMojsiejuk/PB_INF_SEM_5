package pl.edu.pb.booksearchengine;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {

    @GET("search.json")
    Call<BookContainer> findBooks(@Query("q") String query);

    @GET("search.json")
    Call<BookDetailsContainer> findBookDetails(@Query("q") String query);
}

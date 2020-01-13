package pl.edu.pb.booksearchengine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailsActivity extends AppCompatActivity {
    private static final String IMAGE_URL_BASE = "http://covers.openlibrary.org/b/id/";
    public static final String EXTRA_BOOK_POSITION = "bookPosition";

//    public static final String EXTRA_BOOK_COVER = "bookCover";
//    public static final String EXTRA_BOOK_TITLE = "bookTitle";
//    public static final String EXTRA_BOOK_AUTHORS = "bookAuthors";
//    public static final String EXTRA_BOOK_SUBJECTS = "bookSubjects";
//    public static final String EXTRA_BOOK_PUBLISH_YEAR = "bookPublishYear";
//    public static final String EXTRA_BOOK_LANGUAGES = "bookLanguages";


    private ImageView coverImageView;
    private TextView titleTextView;
    private TextView authorTextView;
    private TextView subjectsTextView;
    private TextView publishYearTextView;
    private TextView languagesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        coverImageView = findViewById(R.id.details_book_cover);
        titleTextView = findViewById(R.id.details_book_title);
        authorTextView = findViewById(R.id.details_book_authors);
        subjectsTextView = findViewById(R.id.details_book_subjects);
        publishYearTextView = findViewById(R.id.details_book_publish_year);
        languagesTextView = findViewById(R.id.details_book_languages);

        if (getIntent().hasExtra(EXTRA_BOOK_POSITION)) {
            showDetails(MainActivity.books.get(Integer.parseInt(getIntent().getSerializableExtra(EXTRA_BOOK_POSITION).toString())));
        } else {
            Snackbar.make(findViewById(R.id.linear), "Something went wrong... Please try later!",
                    Snackbar.LENGTH_LONG).show();
        }
    }

//    private void fetchBooksData(String finalQuery) {
//        BookService bookService = RetrofitInstance.getRetrofitInstance().create(BookService.class);
//
//        Call<BookDetailsContainer> bookApiCall = bookService.findBookDetails(finalQuery);
//
//        bookApiCall.enqueue(new Callback<BookDetailsContainer>() {
//            @Override
//            public void onResponse(Call<BookDetailsContainer> call, Response<BookDetailsContainer> response) {
//                showDetails(response.body().getBookList());
//            }
//
//            @Override
//            public void onFailure(Call<BookDetailsContainer> call, Throwable t) {
//                Snackbar.make(findViewById(R.id.linear), "Something went wrong... Please try later!",
//                        Snackbar.LENGTH_LONG).show();
//            }
//        });
//    }

    private void showDetails(Book book) {
        BookDetails bookDetails = (BookDetails) book;

        Picasso.with(getApplicationContext())
                .load(IMAGE_URL_BASE + bookDetails.getCover() + "-L.jpg")
                .placeholder(R.drawable.ic_book_black_24dp).into(coverImageView);

        if (bookDetails.getTitle() != null)
            titleTextView.setText(bookDetails.getTitle());
        if (bookDetails.getAuthors() != null)
            authorTextView.setText(bookDetails.getAuthors().toString());
        if (bookDetails.getSubjects() != null)
            subjectsTextView.setText(bookDetails.getSubjects().toString());
        publishYearTextView.setText(Integer.toString(bookDetails.getPublishYear()));
        if (bookDetails.getLanguages() != null)
            languagesTextView.setText(bookDetails.getLanguages().toString());
    }
}

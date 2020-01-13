package pl.edu.pb.booksearchengine;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDetailsContainer {
    @SerializedName("docs")
    private List<BookDetails> bookList;

    public void setBookList(List<BookDetails> bookList) {
        this.bookList = bookList;
    }

    public List<BookDetails> getBookList() {
        return bookList;
    }
}

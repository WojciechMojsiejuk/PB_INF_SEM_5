package pl.edu.pb.booksearchengine;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BookDetails extends Book {
    @SerializedName("subject")
    private List<String> subjects;
    @SerializedName("first_publish_year")
    private int publishYear;
    @SerializedName("language")
    private List<String> languages;

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSubjects() { return subjects; }

    public int getPublishYear() { return publishYear; }

    public List<String> getLanguages() { return languages; }
}

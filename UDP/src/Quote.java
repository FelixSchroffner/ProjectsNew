import com.google.gson.Gson;

public class Quote {
    private String quote;
    private String author;

    public Quote(String quote, String author) {
        this.quote = quote;
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public String getAuthor() {
        return author;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static Quote fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, Quote.class);
    }
}

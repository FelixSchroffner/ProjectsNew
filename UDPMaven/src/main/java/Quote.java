import com.google.gson.Gson;

//Wird als Datenklasse implementiert, um das JSON-Objekt zu erstellen
//Die toJson()-Methode konvertiert ein Quote-Objekt in ein JSON-Objekt
// und die fromJson()-Methode konvertiert ein JSON-Objekt in ein Quote-Objekt zurück

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


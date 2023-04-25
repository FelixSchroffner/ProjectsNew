import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Die QuoteService-Klasse liest die Textdatei, erstellt Quote-Objekte und speichert sie
// in der quotes-Liste. Sie hat auch eine Methode getNumQuotes(), um die Anzahl der Zitate
// zurückzugeben, und eine Methode getRandomQuote(), um ein zufälliges Zitat zurückzugeben.
public class QuoteService {
    private List<Quote> quotes = new ArrayList<>();
    private Random random = new Random();

    public QuoteService(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] parts = line.split("-");
                if (parts.length == 2) {
                    quotes.add(new Quote(parts[0].trim(), parts[1].trim()));
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumQuotes() {
        return quotes.size();
    }

    public Quote getRandomQuote() {
        int index = random.nextInt(quotes.size());
        return quotes.get(index);
    }
}



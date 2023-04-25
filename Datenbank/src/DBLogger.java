import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class DBLogger {
    private static final Logger logger = Logger.getLogger("MyLog");
    private static FileHandler fh;

    static {
        try {
            fh = new FileHandler("DBLog.log", true);
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        logger.log(Level.INFO, message);
    }
}

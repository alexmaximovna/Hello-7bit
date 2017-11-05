package formatter;
import java.io.BufferedReader;

/**
 * Created by Сандра on 04.11.2017.
 */

/**
 * интерфейс для класса Reader
 */
public interface IReader {
    BufferedReader readFromFile(final String nameFile);
    boolean hasChar();
    char readChar();
}

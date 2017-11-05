package formatter;

/**
 * Created by Сандра on 04.11.2017.
 */

/**
 * Интерфейс для класса Writer
 */
public interface IWriter {
    void  toWriteFile(String nameFile);
    void  toCloseWrite(char symb);
    void writeChar(char symb);
}

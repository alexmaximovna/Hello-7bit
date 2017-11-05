package formatter;

import java.io.*;

/**
 * Класс для чтения файла посимвольно
 */
abstract class CharReader implements IReader{
    /**
     *Функция считывает текст из файла в буферный поток
      * @param nameFile-имя файла,с исходным текстом
     * @return возвращает буферный поток с считанным текстом
     * @throws IOException-Ошибки ввода-вывода
     */
    public static BufferedReader readFromFile(final String nameFile) throws IOException {
            File originFile = new File(nameFile);
            if (!originFile.exists()) {
                throw new FileNotFoundException();
            }
            return new BufferedReader(new FileReader(nameFile));
        }
    }


package BaseMethods;
import java.io.*;
/**
 * Класс ,работающий с файлом
 * @autor Александра Плотникова
 * @version 1.0
 */
public class FileWorker {
    /**
     * @param fileName - имя файла,куда будет записан результат и строку,содержащую отформатированный текст.
     * Функция записывает отформатированный код в файл
     */
    public static void writeInFile(String fileName, String text) {

        File file = new File(fileName);

        try {

            if (!file.exists()) {
                file.createNewFile();
            }


            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {

                out.print(text);
            } finally {

                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Функция читает код с файла
     * @param fileName -получает имя файла,откуда будет считан код.
     * @return возвращает код для форматирвоания,в виде строки
     */
    public static StringBuilder readFromFile(String fileName) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();
        File file = new File(fileName);
       exists(fileName);

        try {

            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {

                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {

                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return sb;
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException(file.getName());
        }
    }
    }
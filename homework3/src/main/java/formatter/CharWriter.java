package formatter;
import java.io.*;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс для записи форматированного текста в файл
 */
 abstract class CharWriter implements IWriter {
    private static FileWriter finalFile;

    /**
     * Функция создает файл,в который будет записан отформатированный текст
     * @param nameFile-имя файла для отформатированного текста
     * @return-возвращение соданного файла
     * @throws IOException ошибка ввода/вывода
     */
    public static FileWriter create(final String nameFile) throws IOException{
        finalFile = new FileWriter(nameFile);
         return(finalFile);
     }

    /**
     *
     * @param symb-текущщий символ для записи
     * @param output-файл для записи
     * @throws IOException ошибка ввода/вывода
     */
    public static void  toWriteFile(char symb,FileWriter output)throws IOException{
        finalFile=output;
        finalFile.write(symb);
    }

    /**
     * Функция закрвает поток
     * @param output-файл для записи
     * @throws IOException ошибка ввода/вывода
     */
    public static void toCloseWrite(FileWriter output)throws IOException{
        finalFile=output;
      finalFile.close();
    }

    }


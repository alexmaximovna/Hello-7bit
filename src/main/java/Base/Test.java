package Base;

import BaseMethods.FileWorker;
import BaseMethods.FormattingCodeJava;
/**
 * Класс ,форматирующий код
 * @autor Александра Плотникова
 * @version 1.0
 */
public class Test {
    /**
     * fileIn-строка,в которой находится неотформатированный код.Этот код представляет собой содержание произвольной функции
     * fileOut-строка,в которой находится отформатированный код.
     */
        public static void main (String [] args) {
            String fileIn = args[0];
            String fileOut = args[1];
            String temp = FormattingCodeJava.deleteSpace(fileIn);
            FileWorker.writeInFile(fileOut, temp);
        }

}

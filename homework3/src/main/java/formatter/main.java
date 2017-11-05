package formatter;

import java.io.IOException;

/**
 * Класс,хранящий имена файлов
 */

 final class Testing {
     static String firstFile;
     static String secondFile;

     public static String getFirstFileName() {
         return firstFile;
     }
     public static String getSecondFileName() {
         return secondFile;
     }
     public static void main( String[] args) {
            firstFile= args[0];
            secondFile=args[1];
            try {
                FormatCode.checkSymb(CharReader.readFromFile(firstFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


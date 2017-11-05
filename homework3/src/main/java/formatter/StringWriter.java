package formatter;

/**
 * Created by Сандра on 04.11.2017.
 */

/**
 * Класс для записи форматированного текста в файл с помощью строки
 */
abstract class StringWriter implements IWriter {
    private static StringBuilder builder = new StringBuilder();

    /**
     * Функция изменяет тип строки,с  StringBuilder  в  String
     * @return возвращает строку типа String
     */
        public String toString() {

            return builder.toString();
        }

    /**
     * Функция записывает символв троку типа  StringBuilder
     * @param symb-символ строки
     */
        public void writeChar(char symb) {
            builder.append(symb);
            System.out.println(symb);
        }
    }


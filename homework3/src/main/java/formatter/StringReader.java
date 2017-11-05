package formatter;

/**
 * Created by Сандра on 04.11.2017.
 */
/**
 * Класс для чтения файла посимвольно
 */
abstract class StringReader implements IReader {

    private String str;
    private int index = 0;

    public StringReader(String str) {

        this.str = str;
    }

    /**
     * Функция проверяет на конец строки
     * @return возвращает true,если индекс символа меньше длины строки
     */
    public boolean hasChar() {

        return index < str.length();
    }

    /**
     * Функция возвращает элемент,соответствующий номеру в строке
     * @return возвращает элемент соответствующему порядку в строке
     */
    public char readChar() {
        return str.charAt(index++);
    }
}

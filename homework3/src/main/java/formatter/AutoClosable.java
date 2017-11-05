package formatter;

/**
 * Created by Сандра on 05.11.2017.
 */
public interface AutoClosable {
    /**
     * Функция закрывает поток
     * @throws Exception-ошибка,в случае не выполнения этой фуекции
     */
    public void close() throws Exception;
}

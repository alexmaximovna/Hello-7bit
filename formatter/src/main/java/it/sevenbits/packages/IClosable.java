package it.sevenbits.packages;


/**
 * Class interface extends AutoCloseable
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws Exception;
}
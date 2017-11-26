package it.sevenbits.app.io.closable;


/**
 * Class interface extends AutoCloseable
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws ClosableException;
}
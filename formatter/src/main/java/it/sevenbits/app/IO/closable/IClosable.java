package it.sevenbits.app.IO.closable;


/**
 * Class interface extends AutoCloseable
 */
public interface IClosable extends AutoCloseable {
    @Override
    void close() throws ClosableException;
}
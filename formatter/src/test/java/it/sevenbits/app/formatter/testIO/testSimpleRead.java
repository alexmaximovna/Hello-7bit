package it.sevenbits.app.formatter.testIO;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testSimpleRead {
    @Test
    public void  testSimpleRead() throws ReaderException {
        IReader reader=new StringReader("abc");
        assertTrue(reader.hasChar());
        assertEquals('a',reader.nextChar());
        assertTrue(reader.hasChar());
        assertEquals('b',reader.nextChar());
        assertTrue(reader.hasChar());
        assertEquals('c',reader.nextChar());


    }
}

package it.sevenbits.app.formatter;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSimpleWrite {
    @Test
    public void testSimpleWrite (){
        IWriter writer=new StringWriter();
        writer.writeString("abc");
        assertEquals("abc",writer.toString());
    }
}

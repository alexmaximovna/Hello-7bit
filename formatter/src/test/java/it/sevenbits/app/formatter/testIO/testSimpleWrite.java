package it.sevenbits.app.formatter.testIO;

import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSimpleWrite {
    private IWriter writer;
    @Before public void clear(){
         writer=new StringWriter();

    }
    @Test
    public void testSimpleWrite (){
        //IWriter writer=new StringWriter();
        writer.writeString("abc");
        assertEquals("abc",writer.toString());
    }
}

package it.sevenbits.app.formatter;

import it.sevenbits.app.formatter.implementation.FormatCode;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.implementation.Lexer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSimpleFormat {
    @Test
    public void testSimpleFormat () throws FormatterException,ReaderException,LexerException{
        IReader reader= new StringReader("a;\n"+
                "   b");
        IWriter writer = new StringWriter();

        ILexer lexer=new Lexer(reader);

        IFormatter formatter = new FormatCode();
        formatter.format(lexer,writer);

        assertEquals(
                "a;\n"+"b",writer.toString()
        );
    }
}

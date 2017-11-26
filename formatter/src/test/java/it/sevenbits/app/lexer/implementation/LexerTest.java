package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.FormatCode;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LexerTest {
    private IFormatter formatter;

    @Before
    public void setUp() {

        formatter = new FormatCode();
    }

    @Test
    void test() throws LexerException {
        IReader in = new StringReader("{a=1;b=2;}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out);
        } catch (Exception e) {
            throw new LexerException("error of lexer", e);
        }
        assertEquals("{\n" +
                "\ta=1;\n" +
                "\tb=2;\n" +
                "}\n", out.toString());

    }
}
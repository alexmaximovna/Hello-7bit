package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.FormatterException;
import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FormatterTest {
    private IFormatter formatter;
    @Before
    public void setUp() throws Exception {
        formatter = new FormatCode();
    }

    @Test
    public void firstTest() throws FormatterException {
        IReader in = new StringReader("public void test(){int a = 3;if(a>0){a++;a++;}a--;}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out) ;
        } catch (Exception e) {
            throw new FormatterException("error of formatting",e);
        }
        assertEquals("public void test(){\n" +
                "\tint a = 3;\n" +
                "\tif(a>0){\n" +
                "\t\ta++;\n" +
                "\t\ta++;\n" +
                "\t}\n" +
                "a--;\n" +
                "}\n", out.toString());
    }
}


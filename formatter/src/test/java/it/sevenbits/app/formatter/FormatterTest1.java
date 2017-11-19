package it.sevenbits.app.formatter;

import it.sevenbits.app.IO.reader.IReader;
import it.sevenbits.app.IO.reader.Implemetation.StringReader;
import it.sevenbits.app.IO.writer.IWriter;
import it.sevenbits.app.IO.writer.Implementation.StringWriter;
import it.sevenbits.app.formatter.implementation.FormatCode;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;
import org.junit.Before;
import org.junit.Test;

import java.util.Formatter;

import static org.junit.Assert.assertEquals;

/**
 * Test for it.sevenbits.app.formatter
 */

public class FormatterTest1{

    private IFormatter formatter;

    @Before
    public void setUp() {

        formatter = new FormatCode();
    }

    @Test
    public void firstTest() throws FormatterException {
        IReader in = new StringReader("public void test(){int a = 3;if(a>0){a++;a++;}a--;}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out) ;
        } catch (FormatterException e) {
           new FormatterException("error of formatting",e);
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

    @Test
    public void secondTest() {
        IReader in = new StringReader("{a=1;b=2;}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out) ;
        } catch (FormatterException e) {
            new FormatterException("error of formatting",e);
        }
        assertEquals("{\n" +
                "\ta=1;\n" +
                "\tb=2;\n" +
                "}\n", out.toString());
    }
    @Test
    public void thirdTest() {
        IReader in = new StringReader("File file = new File(filename);if (!file.exists()){a=1;}try{String text = FileWorker.it.sevenbits.packages.reader(filename);}catch (Exception e) {System.err.println ();}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out) ;
        } catch (FormatterException e) {
            new FormatterException("error of formatting",e);
        }
        assertEquals("File file = new File(filename);\n" +
                "if (!file.exists()){\n" +
                "\ta=1;\n" +
                "}\n" +
                "try{\n" +
                "String text = FileWorker.it.sevenbits.packages.reader(filename);\n" +
                "}\n" +
                "catch (Exception e) {\n" +
                "System.err.println ();\n" +
                "}\n", out.toString());
    }
    @Test
    public void fourthTest(){
        IReader in = new StringReader("{{a=20;b=2;c=9;}}");
        IWriter out = new StringWriter();
        ILexer lexer = new Lexer(in);
        try {
            formatter.format(lexer, out) ;
        } catch (FormatterException e) {
            new FormatterException("error of formatting",e);
        }
        assertEquals("{\n" +
                "\t{\n" +
                "\t\ta=20;\n" +
                "\t\tb=2;\n" +
                "\t\tc=9;\n" +
                "\t}\n" +
                "}\n", out.toString());
    }
}
package it.sevenbits.app.formatter.testFormatter;

import it.sevenbits.app.formatter.IFormatter;
import it.sevenbits.app.formatter.implementation.FormatCode;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.io.writer.implementation.StringWriter;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.implementation.Lexer;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testSimpleFSM {

        private String inStr, outStr = "";
        private StringReader stringReader;
        private StringWriter stringWriter;
        private IFormatter formatter;
        private ILexer lexer;

        @Test
        public void testSpaces() throws Exception {
            inStr = "test spaces";
            stringReader = new StringReader(inStr);
            stringWriter = new StringWriter();
            formatter = new FormatCode();
            lexer = new Lexer(stringReader);
            formatter.format(lexer, stringWriter);
            outStr = stringWriter.toString();
            assertEquals("test spaces",
                    outStr);
        }
        @Test
        public void testOpenBracket() throws Exception {
        inStr = "werte{ wrr;";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("werte{\n" +
                        "    wrr;\n",
                outStr);
    }

       @Test
        public void testSemicolon() throws Exception {
            inStr = "werte;";
            stringReader = new StringReader(inStr);
            stringWriter = new StringWriter();
            formatter = new FormatCode();
            lexer = new Lexer(stringReader);
            formatter.format(lexer, stringWriter);
            outStr = stringWriter.toString();
            assertEquals("werte;\n",
                    outStr);
        }
         @Test
    public void testOnePairBrackets() throws Exception {
        inStr = "/test{ test}";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("/test{\n" +
                        "    test\n" +
                        "}\n",
                outStr);
    }
    @Test
    public void testTwoPairBrackets() throws Exception {
        inStr = "/test{{test}}";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("/test{\n" +
                        "    {\n" +
                        "        test\n"+
                        "    }\n"+
                        "}\n",
                outStr);
    }
    @Test
    public void testThreePairBrackets() throws Exception {
        inStr = "/test{ {test{}}}";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("/test{\n" +
                        "    {\n" +
                        "        test{\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n",
                outStr);
    }
    @Test
    public void testBracketWithSemicolon() throws Exception {
        inStr = "/test{test;}";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("/test{\n" +
                        "    test;\n" +
                        "}\n",
                outStr);
    }
    @Test
    public void testTwoPairBracketsWithSemicolon() throws Exception {
        inStr = "/test{{test;}}";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals("/test{\n" +
                        "    {\n" +
                        "        test;\n"+
                        "    }\n"+
                        "}\n",
                outStr);
    }
    @Test
    public void testMultiComment() throws Exception {
        inStr = "/*test{}}\n" +
               "test*/";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals(inStr,
                outStr);
    }
    @Test
    public void testOneComment() throws Exception {
        inStr = "//test;{]";
        stringReader = new StringReader(inStr);
        stringWriter = new StringWriter();
        formatter = new FormatCode();
        lexer = new Lexer(stringReader);
        formatter.format(lexer, stringWriter);
        outStr = stringWriter.toString();
        assertEquals(inStr,
                outStr);
    }
}

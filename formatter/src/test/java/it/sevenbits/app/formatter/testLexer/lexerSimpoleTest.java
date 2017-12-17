package it.sevenbits.app.formatter.testLexer;

import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.implementation.Lexer;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class lexerSimpoleTest {

        private String inStr;
        private StringReader stringReader;
        private ILexer lexer;

        @Test
        public void testOpenCurly() throws LexerException,ReaderException {
            inStr = "{";
            stringReader = new StringReader(inStr);
            lexer = new Lexer(stringReader);
            assertEquals(new Token("openBracket", "{").toString(),
                    lexer.readToken().toString());
        }
        @Test
        public void testClosingCurly() throws LexerException, ReaderException {
            inStr = "}";
            stringReader = new StringReader(inStr);
            lexer = new Lexer(stringReader);
            assertEquals(new Token("closeBracket", "}").toString(),
                    lexer.readToken().toString());
        }
        @Test
        public void testSemicolon() throws LexerException, ReaderException {
            inStr = ";";
            stringReader = new StringReader(inStr);
            lexer = new Lexer(stringReader);
            assertEquals(new Token("semicolon", ";").toString(),
                    lexer.readToken().toString());
        }
        @Test
        public void testChar() throws LexerException, ReaderException {
        inStr = "d";
        stringReader = new StringReader(inStr);
        lexer = new Lexer(stringReader);
        assertEquals(new Token("char", "d").toString(),
                lexer.readToken().toString());
    }

    @Test
    public void testCommentOneLine() throws LexerException,ReaderException {
        inStr = "//test{}}";
        stringReader = new StringReader(inStr);
        lexer = new Lexer(stringReader);
        assertEquals(new Token("commentOneLine", "//test{}}").toString(),
                lexer.readToken().toString());
    }

    @Test
    public void testCommentMulti() throws LexerException,ReaderException {
        inStr = "/*test;} {fcjng}*/";
        stringReader = new StringReader(inStr);
        lexer = new Lexer(stringReader);
        assertEquals(new Token("commentMulti", "/*test;} {fcjng}*/").toString(),
                lexer.readToken().toString());
    }
}

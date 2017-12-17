package it.sevenbits.app.formatter.testLexer;

import it.sevenbits.app.io.reader.IReader;
import it.sevenbits.app.io.reader.ReaderException;
import it.sevenbits.app.io.reader.implemetation.StringReader;
import it.sevenbits.app.lexer.ILexer;
import it.sevenbits.app.lexer.LexerException;
import it.sevenbits.app.lexer.ICommand;
import it.sevenbits.app.lexer.ICommandRepository;
import it.sevenbits.app.lexer.IStateTransitions;
import it.sevenbits.app.lexer.implementation.Lexer;
import it.sevenbits.app.token.IToken;
import it.sevenbits.app.token.implementation.Token;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class LexerTest {
    @Test
    public void testSimpleTokenize() throws LexerException, ReaderException{
        IReader reader= new StringReader("a;\n"+
                "   b");
        ILexer lexer=new Lexer(reader);

        assertTrue(lexer.hasMoreTokens());
        IToken token=lexer.readToken();
        assertEquals("char",token.getName());
        assertEquals("a",token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token=lexer.readToken();
        assertEquals("semicolon",token.getName());
        assertEquals(";",token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token=lexer.readToken();
        assertEquals("newLine",token.getName());
        assertEquals("\n",token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token=lexer.readToken();
        assertEquals("space",token.getName());
        assertEquals("   ",token.getLexeme());

        assertTrue(lexer.hasMoreTokens());
        token=lexer.readToken();
        assertEquals("char",token.getName());
        assertEquals("b",token.getLexeme());

        assertFalse(lexer.hasMoreTokens());


    }


}

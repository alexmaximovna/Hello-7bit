package it.sevenbits.app.formatter;


import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.token.IToken;

import java.util.Formatter;

public interface ICommand {
    void execute(IToken token, IContext context) throws WriterException;
}

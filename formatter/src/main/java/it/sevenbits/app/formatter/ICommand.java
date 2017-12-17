package it.sevenbits.app.formatter;


import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.token.IToken;


/**
 * ICommand
 */
public interface ICommand {
    /**
     * Execute
     * @param token token
     * @param context context
     * @throws WriterException WriterException
     */
    void execute(IToken token, IContext context) throws WriterException;
}

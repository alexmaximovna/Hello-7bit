package it.sevenbits.app.lexer;

/**
 * interface ICommand
 */
public interface ICommand {
    /**
     * execute
     * @param c symbol
     * @param context context
     */
    void execute(char c , IContext context);
}

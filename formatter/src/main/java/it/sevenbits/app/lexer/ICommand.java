package it.sevenbits.app.lexer;

public interface ICommand {

    void execute(char c, IContext context);
}

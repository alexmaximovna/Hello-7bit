package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.Pair;
import it.sevenbits.app.formatter.ICommand;
import it.sevenbits.app.formatter.ICommandRepository;
import it.sevenbits.app.token.IToken;


import java.util.HashMap;
import java.util.Map;

/**
 * Class of CommandRepository
 */
public class CommandRepository implements ICommandRepository {
    private int level = 0;

    private Map<Pair<State, String>, ICommand> commands = new HashMap<>();

    /**
     * Constructor of CommandRepository
     */
    public CommandRepository() {



        commands.put(new Pair<>(new State("default"), null),
                (token, context) -> context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "space"),
                (token, context) -> context.writeLexeme(" "));
        commands.put(new Pair<>(new State("default"), "newline"),
                (token, context) -> { });
        commands.put(new Pair<>(new State("default"), "semicolon"),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                });
        commands.put(new Pair<>(new State("default"), "openBracket"),
                (token, context) -> {

                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                    level++;
                });
        commands.put(new Pair<>(new State("default"), "closeBracket"),
                (token, context) -> {

                    context.writeNewLine();

                    if (level >= 1) {
                    context.writeSpace(level - 1);
                    } else {
                        context.writeSpace(level);
                    }

                    context.writeLexeme(token.getLexeme());

                    if (level == 0 || level == 1) {
                         context.writeNewLine();

                    }
                    level--;
                });
        commands.put(new Pair<>(new State("newline"), null),
                (token, context) -> {
                   context.writeSpace(level);
                   context.writeLexeme(token.getLexeme());
                });
        commands.put(new Pair<>(new State("newline"), "newline"),
                (token, context) -> {  });
        commands.put(new Pair<>(new State("newline"), "space"),
                (token, context) -> {  });
        commands.put(new Pair<>(new State("newline"), "openBracket"),
                (token, context) -> {
            context.writeSpace(level);
            context.writeLexeme(token.getLexeme());
            context.writeNewLine();
            level++;
                });
        commands.put(new Pair<>(new State("newline"), "closeBracket"),
                (token, context) -> {
                    level--;
                    context.writeSpace(level);
                    context.writeLexeme(token.getLexeme());
                    if (level == 0) {
                        context.writeNewLine();
                    }
                });
        commands.put(new Pair<>(new State("closeBracketState"), null),
                ((token, context) -> {

                    context.writeLexeme(" ");
                    context.writeLexeme(token.getLexeme());
                }));
        commands.put(new Pair<>(new State("closeBracketState"), "space"),
                (token, context) -> { });
        commands.put(new Pair<>(new State("closeBracketState"), "closeBracket"),
                ((token, context) -> {
                   level--;
                   context.writeNewLine();
                   context.writeSpace(level);
                   context.writeLexeme(token.getLexeme());

                    if (level == 0) {
                        context.writeNewLine();
                    }
                }));
    }




    @Override

    public ICommand getCommand(final State state, final IToken token) {
        ICommand command = commands.get(new Pair<>(state, token.getName()));
        if (command == null) {
            command = commands.get(new Pair<>(state, (String) null));
        }
        return command;
    }
}

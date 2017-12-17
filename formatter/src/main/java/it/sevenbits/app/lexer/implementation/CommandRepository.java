package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.Pair;
import it.sevenbits.app.lexer.ICommand;
import it.sevenbits.app.lexer.ICommandRepository;


import java.util.HashMap;
import java.util.Map;

/**
 * class CommandRepositoryLexer
 */
public class CommandRepository implements ICommandRepository {

    private Map<Pair<State, Object>, ICommand> commands = new HashMap<>();

    /**
     * Constructor of CommandRepository
     */
    public CommandRepository() {
        //default
        commands.put(new Pair<>(new State("default"), null),
                (c, context) -> {

                    context.appendLexeme(c);
                    context.setTokenName("char");
                });
        commands.put(new Pair<>(new State("default"), ';'),
                (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("semicolon");
                });
        commands.put(new Pair<>(new State("default"), '\n'),
                (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("newLine");
                });
        commands.put(new Pair<>(new State("default"), ' '),
                (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("space");
                });
        commands.put(new Pair<>(new State("default"), '{'),
                (c, context) -> {
                    context.appendLexeme(c);
                    context.setTokenName("openBracket");
                });
        commands.put(new Pair<>(new State("default"), '}'),
                (c, context) -> {
                    context.setTokenName("closeBracket");
                    context.appendLexeme(c);
                });
        //comment
        commands.put(new Pair<>(new State("comment"), '*'),
                (c, context) -> {
                    context.setTokenName("commentMulti");
                    context.appendLexeme(c);
                });
        commands.put(new Pair<>(new State("comment"), '/'),
                (c, context) -> {
                    context.setTokenName("commentOneLine");
                    context.appendLexeme(c);
                });

        commands.put(new Pair<>(new State("comment"), null),
                (c, context) -> context.appendPostpone(c));
        //otherComment
        commands.put(new Pair<>(new State("commentMulti"), null),
                (c, context) -> context.appendLexeme(c));
        commands.put(new Pair<>(new State("commentEndMulti"), null),
                (c, context) -> context.appendLexeme(c));
        commands.put(new Pair<>(new State("commentOneLine"), null),
                (c, context) -> context.appendLexeme(c));
        //space
        commands.put(new Pair<>(new State("spacing"), ' '),
                (c, context) -> {
                    context.appendLexeme(c);
                });
        commands.put(new Pair<>(new State("spacing"), null),
                (c, context) -> {
                    context.appendPostpone(c);
                });


    }


    /**
     * Function getCommand
     * @param state State
     * @param c char
     * @return command
     */
    public ICommand getCommand(final State state, final char c) {
        if (commands.containsKey(new Pair<>(state, c))) {
            return commands.get(new Pair<>(state, c));
        } else {
            return commands.get(new Pair<>(state, (Character) null));
        }

    }
}

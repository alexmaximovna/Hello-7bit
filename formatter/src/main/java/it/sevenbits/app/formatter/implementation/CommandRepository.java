package it.sevenbits.app.formatter.implementation;

import it.sevenbits.app.formatter.ICommand;
import it.sevenbits.app.formatter.ICommandRepository;
import it.sevenbits.app.formatter.implementation.State;
import it.sevenbits.app.io.writer.IWriter;
import it.sevenbits.app.io.writer.WriterException;
import it.sevenbits.app.token.IToken;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository implements ICommandRepository {
    private int level=0;

    private Map<Pair<State, String>, ICommand> commands = new HashMap<>();
    public CommandRepository() throws WriterException{

        commands.put(new Pair<>(new State("default"), "char"),
                (token, context) -> context.writeLexeme(token.getLexeme()));
        commands.put(new Pair<>(new State("default"), "semicolon"),
                (token, context) ->{
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
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                    level--;
                    context.writeSpace(level);

                });
        commands.put(new Pair<>(new State("default"), null),
                (token, context) -> context.writeLexeme(token.getLexeme()));


        commands.put(new Pair<>(new State("linestart"), "newLine"),
                (token, context) ->{
                });
        commands.put(new Pair<>(new State("linestart"), "space"),
                (token, context) ->{
                });
        commands.put(new Pair<>(new State("linestart"), "char"),
                (token, context) -> context.writeLexeme(token.getLexeme()));

        commands.put(new Pair<>(new State("linestart"), null),
                (token, context) -> {
                    context.writeLexeme(token.getLexeme());
                    context.writeSpace(level);

                });

        commands.put(new Pair<>(new State("linestart"), "openBracket"),
                (token, context) -> {
                    context.writeSpace(level);
                    context.writeLexeme(token.getLexeme());
                    context.writeNewLine();
                    level++;
                });
        commands.put(new Pair<>(new State("linestart"), "closeBracket"),
                (token, context) -> {
                    level--;
                    context.writeSpace(level);
                    context.writeLexeme(token.getLexeme());
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
                }));






    }




    @Override
    public ICommand getCommand(State state, IToken token) {
        ICommand command = commands.get(new Pair<>(state,token.getName()));
        if(command == null){
            command=commands.get(new Pair<>(state, (String)null));
        }
        return command;
    }
}

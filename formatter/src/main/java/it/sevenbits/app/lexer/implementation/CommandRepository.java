package it.sevenbits.app.lexer.implementation;

import it.sevenbits.app.lexer.ICommand;
import it.sevenbits.app.lexer.ICommandRepository;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class CommandRepository implements ICommandRepository {

    private Map<Pair<State, Object>, ICommand> commands = new HashMap<>();
    public CommandRepository (){
        commands.put(new Pair<>(new State("default"), null),
                (c,context)->{ context.appendLexeme(c); context.setTokenName("char");});
        commands.put(new Pair<>(new State("default"), ';'),
                (c,context)->{ context.appendLexeme(c); context.setTokenName("semicolon");});
        commands.put(new Pair<>(new State("default"), '\n'),
                (c,context)->{ context.appendLexeme(c); context.setTokenName("newLine");});
        commands.put(new Pair<>(new State("default"), ' '),
                (c,context)->{ context.appendLexeme(c); context.setTokenName("space");});
        commands.put(new Pair<>(new State("default"), '{'),
                (c, context) -> { context.appendLexeme(c);context.setTokenName("openBracket"); });
        commands.put(new Pair<>(new State("default"), '}'),
                (c, context) -> { context.setTokenName("closeBracket"); context.appendLexeme(c); });

        commands.put(new Pair<>(new State("spacing"), ' '),
                (c,context)->{ context.appendLexeme(c); context.setTokenName("space");});
        commands.put(new Pair<>(new State("spacing"), null),
                (c,context)->{ context.appendPostpone(c); context.setTokenName("space");});





    }
    public ICommand getCommand(State state, char c) {
        ICommand command = commands.get(new Pair<>(state,c));
        if(command == null){
            command=commands.get(new Pair<>(state, (Character)null));
        }
        return command;

    }
}

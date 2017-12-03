package it.sevenbits.app.stateMachineLexer;

public class Command implements Context {
    //private char symbol;
    private String string;
    private TokenBuilder lexeme;
    private boolean flagAppend = false;
    private boolean flagRename = false;
    private boolean flagPostpone = false;
    private boolean flagFinish = false;

    /**
     * Constructor
     * @param s String
     */
    public Command(final String s) {

            this.string = s;
    }


    @Override
    public void appendLexeme(final char c) {
        lexeme.append(c);
        lexeme.setDone(false);
        flagAppend = true;
    }

    @Override
    public void setTokenName(final String str) {
        StringBuilder sb = new StringBuilder(str);
        lexeme.setLexeme(sb);


    }

    @Override
    public void appendPostpone(final char c) {

    }

    /**
     *
     * @param c
     */
     public void pass(final char c){}

    /**
     *
     * @param c symbol
     */
     public void finish (final char c){
         if(c == -1) {
             flagFinish = true;
         }
    }

    /**
     *
     * @param c Symbol
     * @param context Context
     * @return Command
     */
    Command execute(final char c , final Context context) {
        if (flagAppend) {
            context.appendLexeme(c);
            return (new Command("APPEND"));
        } else if (flagPostpone) {
            context.appendPostpone(c);
            return (new Command("POSTPONE"));
        } else if (flagRename) {
            context.setTokenName("RENAME");
        }else if (flagFinish) {
            context.setTokenName("Finish");
        }



        return new Command("PASS");
    }

}

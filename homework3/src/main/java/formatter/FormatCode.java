package formatter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Класс форматирования текста
 */
public class FormatCode implements IFormatCode {

    /**
     * Фукнция форматирует текст
     * @param bufread-буферный поток символов
     * @throws IOException ошибка ввода/вывода
     */
   static void checkSymb(final BufferedReader bufread) throws IOException {

            boolean flag = false;
            int lvl = 0;
            int n = 0;
            FileWriter output = CharWriter.create(Testing.getSecondFileName());
            while ((n = bufread.read()) != -1) {
                char symb = (char) n;
                if (symb == '{') {
                    //lvl++;
                    CharWriter.toWriteFile('{', output);
                    CharWriter.toWriteFile('\n', output);
                    checkOnSpace(++lvl, bufread, output);
                } else if (symb == '}') {

                    CharWriter.toWriteFile('\n', output);
                    checkOnSpace(--lvl, bufread, output);
                    CharWriter.toWriteFile('}', output);
                    //output.toWriteFile('\n');
                } else if (symb == ';') {
                    //flag = true;
                    CharWriter.toWriteFile(symb, output);
                    // output.toWriteFile('\n');

                } else if (symb != '{' && symb != ';' && symb != '}' && symb != '\n' && symb != '\t') {
                    if (flag) {
                        checkOnSpace(lvl, bufread, output);
                        CharWriter.toWriteFile(symb, output);
                        flag = false;
                    } else {

                        CharWriter.toWriteFile(symb, output);
                    }

                }

            }
            CharWriter.toCloseWrite(output);

    }

    /**
     * Функция форматирует текст
     * @param input-текст из файла
     * @param output-отформатированный текст записывающийся в файл
     */
 public static void formatStr(IReader input, IWriter output){
       while (input.hasChar()) {
           checkSymbol(output, input.readChar());
       }
   }
private static void checkSymbol( final IWriter output, final char symb) {
         int lvl = 0;
         boolean flag = false;

                if(symb=='{') {

                    lvl++;
                    output.writeChar(symb);
                    output.writeChar('\n');
                    checkOnSpace1(output,lvl);
                }else if(symb==':') {
                    flag = true;
                    output.writeChar(symb);
                    output.writeChar('\n');
                }else if(symb=='}') {
                    lvl--;
                    checkOnSpace1(output,lvl);
                    output.writeChar(symb);
                    output.writeChar('\n');
                }else if(symb!='}'&&symb!='{'&&symb!=';') {
                    if (flag) {
                        checkOnSpace1(output,lvl);
                        output.writeChar(symb);
                        flag = false;
                    } else {
                        output.writeChar(symb);
                    }
                }

        }
private static void checkOnSpace1(final IWriter output,int lvl) {
        for (int i = 0; i < lvl; i++) {
            output.writeChar('\t');
        }
    }
 private static void checkOnSpace(int level, BufferedReader buffRead,FileWriter output) throws IOException {
        int buff = 0;
        while (true) {
            buffRead.mark(buff);
            buff = buffRead.read();
            if (buff != ' ' && buff != '\t' && buff != -1 ) {
                break;
            }

        }
         buffRead.reset();
        for (int i = 0; i < level ; i++) {
            CharWriter.toWriteFile('\t',output);
        }
    }
}





package BaseMethods;
import java.io.*;
/**
 * Класс ,форматирующий код
 * @autor Александра Плотникова
 * @version 1.0
 */
public class FormattingCodeJava {
    /**
     * Функция редактирует код ({}, ;, 4 пробела)
     * @param filename - имя файла, который нужно отредактировать
     * @return строка, в которой лежит отредактированный файл
     */
    public static String deleteSpace(String filename) {

           StringBuilder text=new StringBuilder();
            int start;
            int countBrackets;
            try {
                text = FileWorker.readFromFile(filename);
            } catch (Exception e) {
                System.err.println ("file not open");
            }

            for (int i=0; i<text.length(); i++) {
                if (text.charAt(i)==';' && text.charAt(i+1)!='\n') {
                    text.insert (i+1, '\n');
                    i+=1;
                }

                if(i+1<text.length() && text.charAt(i)=='i'&& text.charAt(i+1)=='f'){
                    i+=2;
                    while (i<text.length() && text.charAt(i) !='(') {
                        i++;
                    }
                    countBrackets=1;
                    while (countBrackets!=0) {
                        if (text.charAt(i)=='(') {
                            countBrackets++;
                        }
                        if (text.charAt(i)==')') {
                            countBrackets--;
                        }
                    }
                    i++;
                    start=i;
                    while (i<text.length() &&  (text.charAt(i) ==' ' || text.charAt(i) =='\n' )) {
                        i++;
                    }
                    i++;
                    if (text.charAt(i)=='{') {
                        text.delete(start, i-1);
                        if (text.charAt(i+1)!='\n') {
                            text.insert(i + 1, '\n');
                        }
                    }
                }
                if(i+3<text.length() && text.charAt(i)=='e'&& text.charAt(i+1)=='l' && text.charAt(i+2)=='s' && text.charAt(i+3)=='e'){
                    i+=4;
                    start=i;
                    while (i<text.length() &&  (text.charAt(i) ==' ' || text.charAt(i) =='\n' )) {
                        i++;
                    }
                    i++;
                    if (text.charAt(i)=='{') {
                        text.delete(start, i-1);
                        if (text.charAt(i+1)!='\n') {
                            text.insert(i + 1, '\n');
                        }
                    }
                }
                if(i+4<text.length() && ((text.charAt(i)=='c'&& text.charAt(i+1)=='a' && text.charAt(i+2)=='t' && text.charAt(i+3)=='c' && text.charAt(i+4)=='h' ) || (text.charAt(i)=='w'&& text.charAt(i+1)=='h' && text.charAt(i+2)=='i' && text.charAt(i+3)=='l' && text.charAt(i+4)=='e'))){
                    i+=5;
                    while (i<text.length() && text.charAt(i) !='(') {
                        i++;
                    }
                    countBrackets=1;
                    while (countBrackets!=0) {
                        if (text.charAt(i)=='(') {
                            countBrackets++;
                        }
                        if (text.charAt(i)==')') {
                            countBrackets--;
                        }
                    }
                    i++;
                    start=i;
                    while (i<text.length() &&  (text.charAt(i) ==' ' || text.charAt(i) =='\n' )) {
                        i++;
                    }
                    i++;
                    if (text.charAt(i)=='{') {
                        text.delete(start, i-1);
                        if (text.charAt(i+1)!='\n') {
                            text.insert(i + 1, '\n');
                        }
                    }
                }
                if(i+2<text.length() && text.charAt(i)=='t'&& text.charAt(i+1)=='r' && text.charAt(i+2)=='y'){
                    i+=3;
                    start=i;
                    while (i<text.length() &&  (text.charAt(i) ==' ' || text.charAt(i) =='\n' )) {
                        i++;
                    }
                    i++;
                    if (text.charAt(i)=='{') {
                        text.delete(start, i-1);
                        if (text.charAt(i+1)!='\n') {
                            text.insert(i + 1, '\n');
                        }
                    }
                }
                if (i+1<text.length() && text.charAt(i)=='d'&& text.charAt(i+1)=='o') {
                    i+=2;
                    start=i;
                    while (i<text.length() &&  (text.charAt(i) ==' ' || text.charAt(i) =='\n' )) {
                        i++;
                    }
                    i++;
                    if (text.charAt(i)=='{') {
                        text.delete(start, i-1);
                        if (text.charAt(i+1)!='\n') {
                            text.insert(i + 1, '\n');
                        }
                    }
                }
            }
            FormattingCodeJava.levels(text);
            return text.toString();


    }
    /**
     * Функция редактирует код ,добавляя отступы в соотвествии с уровнем блока
     * @param text - строка с кодом
     * @return строка, в которой лежит отредактированный файл
     */
    public static String levels(StringBuilder text){

        int lvl = 0;
        boolean flag = false;
        int start=0;
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == '{' && text.charAt(i + 1) == '\n') {

                if (text.charAt(i) == '\n') {
                    indent = generateIndent(lvl);
                    text.insert(i, indent);
                    i = i + 4 * lvl;
                    start = i;
                    while (i < text.length() && (text.charAt(i) == ' ' || text.charAt(i) == '\n')) {
                        text.delete(start, i - 1);
                    }
                }
                if (text.charAt(i) == '{' && text.charAt(i + 1) == '\n') {
                    lvl++;
                    i++;
                }
                if (text.charAt(i) == '}' && text.charAt(i - 1) == '\n') {
                    lvl--;
                }

            }
        }
return (text.toString());
 }
    /**
     * Функция генерирует строку из пробелов необходиомй длины
     * @param lvl- уровень блока,где нужно сделать отступы
     * @return строка ,состоящая из пробелов
     */
    public static StringBuilder generateIndent(int lvl){
        StringBuilder indent=new StringBuilder();
        for(int i=0;i<lvl*4;i++){
            indent.append(" ");
        }
        return(indent);
    }

}

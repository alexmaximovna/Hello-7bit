import it.sevenbits.packages.reader.Implemetation.ReaderFile;
import it.sevenbits.packages.write.Implementation.WriterFile;
import it.sevenbits.packages.formatter.IFormatCode;
import it.sevenbits.packages.formatter.implementation.FormatCode;

/**
 * Class storing names
 */

final class Main {

    private static  String firstFile;
    private static String secondFile;


    private static String getFirstFileName() {
            return firstFile;
        }


    private static String getSecondFileName() {
            return secondFile;
        }

    /**
     * Function main
     * @param args FIle for console
     * @throws Exception Problems with file
     */
    public static void main(final String[] args) throws Exception {
        firstFile = args[0];
        secondFile = args[1];
        try {
            ReaderFile in = new ReaderFile(Main.getFirstFileName());
            WriterFile out = new WriterFile(Main.getSecondFileName()) ;
            IFormatCode format = new FormatCode();
            format.checkSymb(in,out);
            out.close();
            in.close();

        } catch (Exception e) {
            throw new Exception(e);
        }
}
}

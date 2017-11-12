import it.sevenbits.packages.formatter.IFormatCode;
import it.sevenbits.packages.formatter.implementation.FormatCode;
import it.sevenbits.packages.write.IWriter;
import it.sevenbits.packages.reader.IReader;
import it.sevenbits.packages.write.Implementation.StringWriter;
import it.sevenbits.packages.reader.Implemetation.StringReader;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test for it.sevenbits.packages
 */

public class FormatterTest3{

    private IFormatCode formatter;

    @Before
    public void setUp() {
        formatter = new FormatCode();
    }

    @Test
    public void testCopy() {
        IReader in = new StringReader("File file = new File(filename);if (!file.exists()){a=1;}try{String text = FileWorker.it.sevenbits.packages.reader(filename);}catch (Exception e) {System.err.println ();}");
        IWriter out = new StringWriter();
        try {
            formatter.checkSymb(in, out) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("File file = new File(filename);\n" +
                "if (!file.exists()){\n" +
                "\ta=1;\n" +
                "}\n" +
                "try{\n" +
                "String text = FileWorker.it.sevenbits.packages.reader(filename);\n" +
                "}\n" +
                "catch (Exception e) {\n" +
                "System.err.println ();\n" +
                "}\n", out.toString());
    }

}
/*File file = new File(fileName);
if (!file.exists()){
}
try { String text = FileWorker.it.sevenbits.packages.reader(filename);
}
catch (Exception e) {
System.err.println ()
}*/
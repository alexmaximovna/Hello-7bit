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

public class FormatterTest4{

    private IFormatCode formatter;

    @Before
    public void setUp() {
        formatter = new FormatCode();
    }

    @Test
    public void testCopy() {
        IReader in = new StringReader("{{a=20;b=2;c=9;}}");
        IWriter out = new StringWriter();
        try {
            formatter.checkSymb(in, out) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("{\n" +
                "\t{\n" +
                "\t\ta=20;\n" +
                "\t\tb=2;\n" +
                "\t\tc=9;\n" +
                "\t}\n" +
                "}\n", out.toString());
    }

}

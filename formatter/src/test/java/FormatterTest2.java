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

public class FormatterTest2{

    private IFormatCode formatter;

    @Before
    public void setUp() {
        formatter = new FormatCode();
    }

    @Test
    public void testCopy() {
        IReader in = new StringReader("{a=1;b=2;}");
        IWriter out = new StringWriter();
        try {
            formatter.checkSymb(in, out) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("{\n" +
                "\ta=1;\n" +
                "\tb=2;\n" +
                "}\n", out.toString());
    }

}
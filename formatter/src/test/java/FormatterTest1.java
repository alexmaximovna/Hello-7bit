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

public class FormatterTest1{

    private IFormatCode formatter;

    @Before
    public void setUp() {
        formatter = new FormatCode();
    }

    @Test
    public void testCopy() {
        IReader in = new StringReader("public void test(){int a = 3;if(a>0){a++;a++;}a--;}");
        IWriter out = new StringWriter();
        try {
            formatter.checkSymb(in, out) ;
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("public void test(){\n" +
                "\tint a = 3;\n" +
                "\tif(a>0){\n" +
                "\t\ta++;\n" +
                "\t\ta++;\n" +
                "\t}\n" +
                "a--;\n" +
                "}\n", out.toString());
    }

}
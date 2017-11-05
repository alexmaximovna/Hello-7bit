import package test.java.test1;
import formatter.FormatCode;
import formatter.IWriter;
import formatter.IReader;
import main.formatter;

import org.junit.Before;
import org.junit.Test;

import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;


public class test1 {
 {

     @Test
    public void testCopy(){
        IReader in = new StringReader("private void testing(){int a = 20;if(a>0){a++;}else{a--;}}");
        IWriter out = new StringWriter();
        FormatCode.formatStr(in, out);
        assertEquals("private void testing(){\n",
                "\t int a = 20;\n",
                "\tif(a>0){\n",
                "\t\ta++;\n",
                "\t}\n",
                "\telse{\n",
                "\t\ta--;\n",
                "\t}\n",
                "}\n",out.toString());
    }
}
}


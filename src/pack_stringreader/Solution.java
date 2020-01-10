package pack_stringreader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) throws IOException {
//        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
//        System.out.println(text);
//    }
//
//    public static String getStackTrace(Throwable throwable) {
//        StringWriter sw=new StringWriter();
//       throwable.printStackTrace( new PrintWriter(sw));
//        return sw.toString();
////        StringWriter sw = new StringWriter();
////        PrintWriter pw = new PrintWriter(sw);
////        throwable.printStackTrace(pw);
////        pw.flush();
////        return sw.toString();
//
//    }
//}
//        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
//        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
//    }
//
//    public static String decode(StringReader reader, int key) throws IOException {
//        StringWriter sww;
//        try {
//            sww = new StringWriter();
//            int i;
//            while((i=reader.read())!=-1){
//                sww.append((char) (i+key));
//            }
//        } catch (IOException e) {
//            sww=new StringWriter();
//        }
//        return sww.toString();
//    }
//}
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("c://ываыва.txt"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        StringWriter sw=new StringWriter( );
        try {
            int ii;
            while((ii=is.read())!=-1){
               sw.append((char)(ii));
            }
        } catch (IOException e) {
            sw=new StringWriter();
        }
       is.close();
        return sw;
    }
}

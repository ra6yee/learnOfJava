package pack_random_access_file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {
    public static void main(String[] args) throws IOException {
       String fileName="c://one.txt";
   int numOfPos=20;
       String text="Haaa!!!!!Hello world!!! I am here!!! And my name is Alen. I am from Russia.";
        RandomAccessFile raf=new RandomAccessFile(fileName,"rw");
       if((raf.length()-numOfPos)>text.length()) {
           raf.seek(numOfPos);
           raf.write(text.getBytes("UTF-8"));
       } else{
           raf.seek(raf.length());
           raf.write(text.getBytes());
       }
        raf.close();
    }
}

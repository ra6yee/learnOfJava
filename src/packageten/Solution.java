package packageten;

import java.io.*;

/*
Проход по дереву файлов
*/
//interface Executable{
//    void execute();
//}
//class Runnable{
//    public void run(Executable e){
//      //  System.out.println("hello Dolly");
//  e.execute();
//    }
//}
//
//class Exes implements Executable{
//
//    @Override
//    public void execute() {
//        System.out.println("one two three");
//    }
//}
public class Solution {
    public static void main(String[] args) throws IOException {
       long start=System.currentTimeMillis();
        File file =new File("c://123");
        File fileIn=new File("c://2.txt");
        File lastFile=new File("rezult");
      //  FileUtils.renameFile(fileIn,lastFile );

        String nameOfFile="";
        int array;
File[] arrayOfFilesInDirectory=file.listFiles();


        for (int i = 0; i <arrayOfFilesInDirectory.length ; i++) {
                  if(arrayOfFilesInDirectory[i].isFile()){
                      CopyFile(arrayOfFilesInDirectory[i].getAbsolutePath());
                  }if (arrayOfFilesInDirectory[i].isDirectory()){
                      listOfFilesInDirectory(arrayOfFilesInDirectory[i]);
            }

        }
   long fin=System.currentTimeMillis();
        System.out.println(fin-start);
    }





    public static void  listOfFilesInDirectory(File x) throws FileNotFoundException {

       File[] one=x.listFiles();
       SortOfArray(one);
      // return one;
   }



   public static void CopyFile (String addresOfFile) throws FileNotFoundException {

       try(

               FileInputStream is=new FileInputStream(addresOfFile);
               BufferedInputStream bis=new BufferedInputStream(is);
            FileOutputStream os=new FileOutputStream("c://2.txt",true)) {
           PrintStream stream=new PrintStream(os);
           stream.println("new file");

           while(is.available()>0){
               int x=is.read();
               os.write(x);
           }
           System.out.println(addresOfFile);

       } catch (IOException e) {
           e.printStackTrace();
       }

   }

    public static void SortOfArray(File[] x) throws FileNotFoundException {

        for (int i = 0; i <x.length ; i++) {
               if(x[i].isFile()){
                  CopyFile(x[i].getAbsolutePath());
               }if(x[i].isDirectory()){
                   listOfFilesInDirectory(x[i]);

            }
        }

    }


    }






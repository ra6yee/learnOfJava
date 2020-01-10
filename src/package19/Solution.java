package package19;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Solution {
    public Solution() throws FileNotFoundException {
    }

    public static void main(String[] args) throws IOException {
//        // создаем архив
//        FileOutputStream zipFile = new FileOutputStream("c:/archive.zip");
//        ZipOutputStream zip = new ZipOutputStream(zipFile);
//
////кладем в него ZipEntry – «архивный объект»
//        zip.putNextEntry(new ZipEntry("document.txt"));
//        zip.putNextEntry(new ZipEntry("document1.txt"));
//        zip.putNextEntry(new ZipEntry("document2.txt"));
//        zip.putNextEntry(new ZipEntry("document3.txt"));
//        zip.putNextEntry(new ZipEntry("document387.txt"));
//        zip.putNextEntry(new ZipEntry("document33.txt"));
//        zip.putNextEntry(new ZipEntry("document44.txt"));
//        zip.putNextEntry(new ZipEntry("document21.txt"));
//        zip.putNextEntry(new ZipEntry("document43.txt"));
//        zip.putNextEntry(new ZipEntry("document54.txt"));
//        zip.putNextEntry(new ZipEntry("document514.txt"));
//
////копируем файл «document-for-archive.txt» в архив под именем «document.txt»
//        File file = new File("c:/document-for-archive.txt");
//      if(!file.isFile()){  file.createNewFile();}
//
//        Files.copy(file.toPath(), zip);
//
//// закрываем архив
//        zip.close();
//
//ZipInputStream zis=new ZipInputStream(new FileInputStream("c:/archive.zip"));
//    ZipEntry entry;
//    while((entry=zis.getNextEntry())!=null){
//        System.out.println(entry.getName());
//        System.out.println(entry.getSize());
//
//    }
//        ZipOutputStream zos=new ZipOutputStream(new FileOutputStream("c://project.zip"));
//        Path file= Paths.get("c:/ава.jpg");
//        zos.putNextEntry(new ZipEntry("c:/ава.jpg"));
//       // zos.closeEntry();
//        Files.copy(file,zos);
//zos.close();
//        Path fileToAdd= Paths.get("c:/one.txt");
//        Map<String, ByteArrayOutputStream> mapOfFilea =new TreeMap<>();
//        ZipInputStream zis=new ZipInputStream(new FileInputStream("c://project.zip"));
//        ZipEntry entry;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[]array=new byte[1024*8];
//        int i;
//        while((entry=zis.getNextEntry())!=null){
//
//            while(true){
//                if(entry.getName().equals(fileToAdd.getFileName())){
//byteArrayOutputStream.write(Files.readAllBytes(fileToAdd));
//                    mapOfFilea.put(fileToAdd.getFileName().toString(), byteArrayOutputStream);
//                    break;
//                }
//                i=zis.read(array,0,array.length);
//                if(i==-1){
//                    break;
//                }else{
//                    byteArrayOutputStream.write(i);
//                }
//
//            }
//            mapOfFilea.put(entry.getName(), byteArrayOutputStream);
//        }
//        System.out.println(mapOfFilea);
//        System.out.println("end of reading");
//        zis.close();
//        byteArrayOutputStream.close();
       // ZipOutputStream zos=new ZipOutputStream(new FileOutputStream("c://project.zip"));
//        ZipFile archiv=new ZipFile("c:/project.zip");
//        Enumeration zipenum=archiv.entries();
//        ZipEntry entry;
//        String dirOfDestin="pro";
//        if(!Files.isDirectory(Paths.get("d:/pro"))){
//                 Files.createDirectory(Paths.get("d:/pro/"));
//        }
//        while((zipenum.hasMoreElements())==true){
//           entry= (ZipEntry) zipenum.nextElement();
//            System.out.println(entry.getName());
//            System.out.println(entry.getCrc());
//          if(entry.isDirectory()) {
//              if (!Files.isDirectory((Paths.get("d:/pro/ "+entry.getName()))))
//                  Files.createDirectories(Paths.get("d:/pro/ "+entry.getName()));
//          }else{
//              if(!Files.isRegularFile(Paths.get("d:/pro/ "+entry.getName()))){
//                  Files.createFile(Paths.get("d:/pro/ "+entry.getName()));
//              }
//              InputStream fis;
//              fis=  archiv.getInputStream(entry);
//              FileOutputStream fos=new FileOutputStream("d:/pro/ "+entry.getName());
//              int i;
//              while(fis.available()>0){
//                  i=fis.read();
//                  fos.write(i);
//
//              }
//          fis.close();
//              fos.close();
//          }
//
//
//        }
//String pathOfArhiv="d:/ArhivOfLearn";
//if(!Files.isDirectory(Paths.get(pathOfArhiv))){
//    Files.createDirectory(Paths.get(pathOfArhiv));
//}
//        ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream(pathOfArhiv+".zip"));
//        Path filesForCompress=Paths.get("d:/pro");
//
//ZipEntry files1=new ZipEntry("document-for-archive.txt");
//ZipEntry file2=new ZipEntry("one.txt");
//        zipOutputStream.putNextEntry(files1);
////Files.copy(Paths.get("c:/document-for-archive.txt)"),  zipOutputStream);
//        InputStream inputStream=new FileInputStream("c:/document-for-archive.txt");
//        while (inputStream.available()>0){
//            int i=inputStream.read();
//            zipOutputStream.write(i);
//        }
//
//        zipOutputStream.closeEntry();
//        zipOutputStream.putNextEntry(file2);
//        File file=new File("c:/one.txt");
//        Files.copy(file.toPath(),zipOutputStream);
//        zipOutputStream.closeEntry();
//zipOutputStream.close();
String nameOfdir="arhiv1";
        Path directoryOfcompressed= Paths.get("d:/pro");
        Path fileOfcompressing=Paths.get("d:/"+nameOfdir+".zip");
        if(!Files.isRegularFile(fileOfcompressing)){
            Files.createFile(fileOfcompressing);
        }
        ZipOutputStream zos=new ZipOutputStream(new FileOutputStream(String.valueOf(fileOfcompressing)));
       // ZipInputStream zis= new ZipInputStream(directoryOfcompressed);
;
        zos.setLevel(1);

        File dirForCompress=new File(directoryOfcompressed.toString());
//        File[] listOfPath=dirForCompress.listFiles();
//        for (File x :
//                listOfPath) {
//add(x);
//        }
        add(zos,dirForCompress);



        zos.close();
    }
public static void add(ZipOutputStream zip,File source ) throws IOException {

File[] listOfFiles=source.listFiles();
    for (int i = 0; i <listOfFiles.length ; i++) {
        if(listOfFiles[i].isDirectory()){
            add(zip,listOfFiles[i]);
           continue;
        }
        FileInputStream fis=new FileInputStream(listOfFiles[i]);
       // String name=listOfFiles[i].getName();
        zip.putNextEntry(new ZipEntry(listOfFiles[i].getParent()));
       byte[]buff=new byte[1024];
        int read;
        while((read=fis.read(buff))>0){

             zip.write(buff,0,read);
        }
        zip.closeEntry();
        fis.close();
    }
}
}

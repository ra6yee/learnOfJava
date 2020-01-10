package package15;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class Solution {
   static int countOfDirectories=-1;
   static int countOfFiles=0;
   static  int totalSize=0;
    public static void main(String[] args) throws IOException {


        String pathOfDirectory=                    // "c://one.txt";
                 "c://repeate5643";
        Path dir= Paths.get(pathOfDirectory);
            if(Files.isDirectory(dir)==false){
                System.out.println("Неверный путь папки");
                System.exit(1);
            }else{
                System.out.println("Путь введен верно, папка существует");
            }
        Files.walkFileTree(dir,new MyFileVisitor());
        System.out.println("Количество папок: "+countOfDirectories);
        System.out.println("Количество файлов: "+countOfFiles);
        System.out.println("Количество занятых байт: "+totalSize);
    }

}
class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes atrr) {



            System.out.format("Directory : %s ", directory);
            Solution.countOfDirectories++;

        System.out.println("(" + atrr.size() + "bytes)");


        return CONTINUE;


    }
public FileVisitResult visitFile(Path file,BasicFileAttributes atrr) {

        Solution.countOfFiles++;
    System.out.format("File : %s",file);
    System.out.println("(" + atrr.size() + "bytes)");
    Solution.totalSize+=atrr.size();
    return CONTINUE;
    }

}

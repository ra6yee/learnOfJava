package package13;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
       List<String>listOut=new LinkedList<>();
        Queue<File>files=new LinkedList<>();
        File firstRoot=new File(root);
        if(firstRoot.isDirectory()){
            files.add(firstRoot);
        }
while(!files.isEmpty()){
    File[] three;
    File two=files.poll();

         three = two.listFiles();


    for (int i = 0; i <three.length ; i++) {
           if(three[i].isDirectory()){
               files.add(three[i]);
           }else{
               listOut.add(three[i].getAbsolutePath());
           }
    }
}


        return listOut;

    }

    public static void main(String[] args) throws IOException {
String thePath="c:/Мои Web Сайты";
List<String>filesInRoot=getFileTree(thePath);
        for (String x :
                filesInRoot) {
            System.out.println(x);
        }
    }
}

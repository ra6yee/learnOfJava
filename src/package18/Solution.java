package package18;


import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/*
Продвинутый поиск файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

       searchFileVisitor.setPartOfName("amigo");
       searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(100000);

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }
}
class SearchFileVisitor extends SimpleFileVisitor<Path>{
   private String PartOfName=null;
   private String PartOfContent=null;
  private  int MinSize=0;
 private    int MaxSize=0;
 private   List <Path> foundFiles=new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public String getPartOfContent() {
        return PartOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        PartOfContent = partOfContent;
    }

    public int getMinSize() {
        return MinSize;
    }

    public void setMinSize(int minSize) {
        MinSize = minSize;
    }

    public int getMaxSize() {
        return MaxSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    public String getPartOfName() {
        return PartOfName;
    }

    public void setPartOfName(String partOfName) {
        PartOfName = partOfName;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
if(((PartOfName==null)||(PartOfContent==null)||(MaxSize==0)||(MinSize==0))||
        (attrs.size()>MinSize && attrs.size()<MaxSize)&& file.getFileName().toString().contains(PartOfName) ) {

        String contentOfFile=new String(Files.readAllBytes(file));

if(contentOfFile.contains(PartOfContent)){
    foundFiles.add(file);
}
}//System.out.println("Name of file: ");
        return FileVisitResult.CONTINUE;

    }
}
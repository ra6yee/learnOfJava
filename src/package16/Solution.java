package package16;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        String link = "https://javarush.ru/testdata/secretPasswords.txt";
        String directory = "c:/435";
    // Path linkPath= Paths.get(link);
        String fileName=link.substring(link.lastIndexOf("/")+1);
        Path directoryPath = Paths.get(directory);
        if (Files.isDirectory(directoryPath)==false) {
            try {
                Files.createDirectory(directoryPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        try {
            URL urlString = new URL(link);
            is = urlString.openStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path temp = null;
        try {
            temp = Files.createTempFile("tempo-", "tmp");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Files.copy(is, temp, StandardCopyOption.REPLACE_EXISTING);
       // String fileName=linkPath.getFileName().toString();

             Files.move(temp,(Paths.get(directory+"/"+fileName)),StandardCopyOption.REPLACE_EXISTING);
    }
}
 class Solo {
    public static byte[] readBytes(String fileName) throws IOException {
        byte[] array=Files.readAllBytes(Paths.get(fileName));
        return array;
    }

    public static List<String> readLines(String fileName) throws IOException {
        List<String>list=Files.readAllLines(Paths.get(fileName), Charset.defaultCharset());
        return list;
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        if(Files.isRegularFile(Paths.get(fileName))==false) {
            Files.createFile(Paths.get(fileName));
        }
        Files.write(Paths.get(fileName),bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName),Paths.get(destinationFileName));
    }
}
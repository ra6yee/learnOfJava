package package14;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

/*
Загрузчик файлов
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("c:/MyDownloads"));
        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        String fileName = urlString.substring(urlString.lastIndexOf("/")+1);
        try {
            Path dir=Files.createDirectory(downloadDirectory);
        } catch (FileAlreadyExistsException e) {

        }
        Path resultFile = null;
        try {
            resultFile = Files.createFile( Paths.get(downloadDirectory + "/" + fileName));
        } catch (FileAlreadyExistsException e) {

        }

        URL url = new URL(urlString);

        InputStream inputStream = url.openStream();

        Path tempFile = Files.createTempFile(Paths.get("c:/"),"temp-",".tmp");

        Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING );

        inputStream.close();

        Files.move(tempFile, resultFile,StandardCopyOption.REPLACE_EXISTING );

        return resultFile;
        // implement this method            this is pizdecccccc
    }
}
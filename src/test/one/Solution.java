package test.one;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Solution {
    public static void main(String[] args) throws IOException {
//
//
//     // if(!Files.exists(Paths.get("c:/MyClassDirectory1"))) {
//
//        try {
//
//         Path   one = Files.createDirectory(Paths.get("c:/MyClassDirectory1"));
//            // }
//            //if(!Files.exists(Paths.get("/firstOfRead.txt"))) {
//
//          Path  file = Files.createFile(Paths.get("firstOfRead.txt"));
//        } catch (FileAlreadyExistsException e) {
//           // e.printStackTrace();
//        }
//        // }
//  // FileOutputStream fos=new FileOutputStream(file.toFile());
//    //    fos.write(2);
//   file= Files.move(file,Paths.get("c:/MyClassDirectory1/firstOfRead.txt"), StandardCopyOption.REPLACE_EXISTING);
//            //Files.createDirectory(one);
////           Path white= Paths.get("file.txt");
////         Path two=Files.createFile(white);
////         Files.move(two,one);
//
//
//      //  Files.createFile(one,two);
//    }
        //создание файла
        Path testFile1 = Files.createFile(Paths.get("C:/Users/Username/Desktop/testFile111.txt"));
        System.out.println("Был ли файл успешно создан?");
        System.out.println(Files.exists(Paths.get("C:/Users/Username\\Desktop\\testFile111.txt")));

        //создание директории
        Path testDirectory = Files.createDirectory(Paths.get("C:\\Users\\Username\\Desktop\\testDirectory"));
        System.out.println("Была ли директория успешно создана?");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Username\\Desktop\\testDirectory")));

        //перемещаем файл с рабочего стола в директорию testDirectory. Перемещать надо с указанием имени файла в папке!
        testFile1 = Files.move(testFile1, Paths.get("C:\\Users\\Username\\Desktop\\testDirectory\\testFile111.txt"), REPLACE_EXISTING);

        System.out.println("Остался ли наш файл на рабочем столе?");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Username\\Desktop\\testFile111.txt")));

        System.out.println("Был ли наш файл перемещен в testDirectory?");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Username\\Desktop\\testDirectory\\testFile111.txt")));

        //удаление файла
        Files.delete(testFile1);
        System.out.println("Файл все еще существует?");
        System.out.println(Files.exists(Paths.get("C:\\Users\\Username\\Desktop\\testDirectory\\testFile111.txt")));
    }
}




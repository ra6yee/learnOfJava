package package23;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class solo {
    public static void main(String[] args) throws Exception {
String source="d:/pro";
String zip="d:/arhiv1.zip";
        Zip(source,zip);
    }

    private static void Zip(String source_dir, String zip_file) throws Exception
    {
        // Cоздание объекта ZipOutputStream из FileOutputStream
        FileOutputStream fout = new FileOutputStream(zip_file);
        ZipOutputStream zout = new ZipOutputStream(fout);
        // Определение кодировки
        //zout.setEncoding("CP866");

        // Создание объекта File object архивируемой директории
        File fileSource = new File(source_dir);

        addDirectory(zout, fileSource);

        // Закрываем ZipOutputStream
        zout.close();

        System.out.println("Zip файл создан!");
    }
    private static void addDirectory(ZipOutputStream zout, File fileSource)
            throws Exception
    {
        File[] files = fileSource.listFiles();
        System.out.println("Добавление директории <" + fileSource.getName() + ">");
        for(int i = 0; i < files.length; i++) {
            // Если file является директорией, то рекурсивно вызываем
            // метод addDirectory
            if(files[i].isDirectory()) {
                addDirectory(zout, files[i]);
                continue;
            }
            System.out.println("Добавление файла <" + files[i].getName() + ">");

            FileInputStream fis = new FileInputStream(files[i]);

            zout.putNextEntry(new ZipEntry(files[i].getPath()));

            byte[] buffer = new byte[4048];
            int length;
            while((length = fis.read(buffer)) > 0)
                zout.write(buffer, 0, length);
            // Закрываем ZipOutputStream и InputStream
            zout.closeEntry();
            fis.close();
        }
    }


}

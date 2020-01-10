package pack_config;

import java.io.*;
import java.nio.file.Paths;
import java.util.Properties;

/*
Читаем конфиги
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
       Properties properties = solution.getProperties("c://properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("c://properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties=new Properties();
        FileInputStream is= null;
        try {
            is = new FileInputStream((fileName));
        } catch (FileNotFoundException e) {


        }

        try {
if(Paths.get(fileName).getFileName().endsWith(".xml")){
    properties.loadFromXML(is);
}else
            properties.load(is);
        } catch (Exception e) {
                 properties=properties;
        }


        return properties;
    }
}

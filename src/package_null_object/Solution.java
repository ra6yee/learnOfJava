package package_null_object;

import java.io.File;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        File file=new File(pathToFile);

        try {
            this.fileData=new ConcreteFileData(file.isHidden(),file.canExecute(),file.isDirectory(),file.canWrite());
        } catch (Exception e) {
            this.fileData=new NullFileData(e);
        }


    }

    public FileData getFileData() {
        return fileData;
    }
}
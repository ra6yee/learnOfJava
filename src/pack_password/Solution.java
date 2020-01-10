package pack_password;

import java.io.ByteArrayOutputStream;
import java.util.Random;

public class Solution {
    public static void main(String[] args) {
      ByteArrayOutputStream password = getPassword();
      System.out.println(password.toString());
        Random rand=new Random();
      //  System.out.println((char)(rand.nextInt(57-48)+48));
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream baos=new ByteArrayOutputStream();// 48-57 numbers 65-90 Letters Big
        Random rand=new Random();// 97-122 Letters small
        int sizeOfPass=9;
        while(baos.size()<=sizeOfPass){
            baos.write((char)(rand.nextInt((57-48)+1)+48));
            if(baos.size()==sizeOfPass){
                break;
            }
            baos.write((char)(rand.nextInt((90-65)+1)+65));
            if(baos.size()==sizeOfPass){
                break;
            }
            baos.write((char)(rand.nextInt((122-97)+1)+97));

        }

        return baos;
    }
}



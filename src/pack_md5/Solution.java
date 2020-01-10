package pack_md5;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/*
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] md5_md=  md.digest(byteArrayOutputStream.toByteArray());
       StringBuilder sb=new StringBuilder();
        for (byte x :
                md5_md) {
            sb.append(String.format("%02x",x));

        }
        System.out.print(sb.toString());
        if (sb.toString().equals( md5)) {
            return true;

        }else
   return false;
    }
}
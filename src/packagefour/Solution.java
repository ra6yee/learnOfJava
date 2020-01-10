package packagefour;

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
       //String one="00";

       System.out.println(testForString("00"));
       System.out.println(testForString("1j2())23f"));
        System.out.println(testForString("12AS08z"));
        System.out.println(testForString("12AS08Z/"));

    }
    public static String testForString(String string){
            String last=null;

        for (int i = 2; i <=36 ; i++) {
            try {
                BigInteger one=new BigInteger(string,i);
                last=String.valueOf(i);
                break;
            } catch (NumberFormatException e) {
              if(i==36) {
                  last = "incorrect";
              }
              }



        }

            return last;
    }
}

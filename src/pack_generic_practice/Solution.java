package pack_generic_practice;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println("Hello World");
        Integer[] intArr = {1};
       // Double[] doubleArr = null;
        // String[] stringArr=null;
        fillArray(intArr);
        //fillArray(doubleArr);
        //  fillArray(stringArr);
        Arrays.stream(intArr).forEach(a-> System.out.println(a));
    }

    public static <T> void fillArray(T[] array) {
        Object a= array.getClass().getComponentType();
              if(a instanceof Integer){

                  for (int i = 0; i <10 ; i++) {
                      array[i]= (T)new Integer(i);

                  }
              }


    }
}
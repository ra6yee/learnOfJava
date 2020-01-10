package pack_dyn_proxy_generics;

import java.lang.reflect.Proxy;

/*
Дженерики для создания прокси-объекта
*/
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    private  <T extends Item> T getProxy(Class<T>clas, Class<?>...interfaces){
Class<?>[] ifases=new Class[interfaces.length+1];
Class<?>[]interfaces1=interfaces;
        Object proxy= Proxy.newProxyInstance(this.getClass().getClassLoader(),interfaces1,new ItemInvocationHandler());

return (T) proxy ;
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}
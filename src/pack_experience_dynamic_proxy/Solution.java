package pack_experience_dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface mansOfCountry{

      void lang(boolean russian);
     int age (int a);
    String homeLand(String country);
}


class Man implements mansOfCountry{
private boolean rus;
private int age;
private String HomeLand;

    public Man(boolean rus, int age, String homeLand) {
        this.rus = rus;
        this.age = age;
        HomeLand = homeLand;
    }

    public boolean isRus() {
        return rus;
    }

    public void setRus(boolean rus) {
        this.rus = rus;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeLand() {
        return HomeLand;
    }

    public void setHomeLand(String homeLand) {
        HomeLand = homeLand;
    }

    @Override
    public void lang(boolean russian) {
        if(russian==true){
            System.out.println("Am ours and can speak Russian");
        }if(russian==false){
            System.out.println("He is a enemy, a little bit enemy and don't speak Russian");
        }
    }

    @Override
    public int age(int a) {
        System.out.println("my age is "+a);
        return a;
    }

    @Override
    public String homeLand(String country) {
        return "I am from "+country;
    }
}

class ManInvocationHandler implements InvocationHandler{
private Man man;

    public ManInvocationHandler(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Hello friends!!!");
        return method.invoke(man,args);
    }
}

public class Solution {
    public static void main(String[] args) {
Man alex=new Man(true,38,"Russia");
ClassLoader classLoader=alex.getClass().getClassLoader();
Class[]interfaces=alex.getClass().getInterfaces();
        mansOfCountry alexProxy=(mansOfCountry)Proxy.newProxyInstance(classLoader,interfaces,new  ManInvocationHandler(alex));
        System.out.println( alexProxy.homeLand(alex.getHomeLand()));
        System.out.println(alexProxy.age(alex.getAge()));
    }
}
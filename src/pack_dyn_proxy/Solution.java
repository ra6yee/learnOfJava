package pack_dyn_proxy;

import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
public class Solution {
    public static void main(String[] args) {
       // InvocationHandler handler=new CustomInvocationHandler();
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
SomeInterfaceWithMethodsImpl siwm=new SomeInterfaceWithMethodsImpl();
ClassLoader siwmCL=siwm.getClass().getClassLoader();
Class[]interfaces=siwm.getClass().getInterfaces();
SomeInterfaceWithMethods siwmProxy=(SomeInterfaceWithMethods) Proxy.newProxyInstance(siwmCL,interfaces,new CustomInvocationHandler(siwm));
        return siwmProxy;
    }
}
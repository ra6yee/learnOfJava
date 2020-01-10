package pack_dyn_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods someInterfaceWithMethods;
    public CustomInvocationHandler(SomeInterfaceWithMethods x) {
this.someInterfaceWithMethods=x;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println( method.getName()+ " in");
             method.invoke(someInterfaceWithMethods,args);
        System.out.println(method.getName()+" out");
        return null;
    }
}

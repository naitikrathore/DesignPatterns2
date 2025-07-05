package CreationalDesignPattern;

import CreationalDesignPattern.SingletonDesignPattern.BIllPughSingleton;
import CreationalDesignPattern.SingletonDesignPattern.EagerSingleton;
import CreationalDesignPattern.SingletonDesignPattern.LazySingleton;

public class Main {
    public static void main(String[] args) {
        EagerSingleton es = EagerSingleton.getInstance();
        es.doSomething();

        System.out.println("-------------");

        LazySingleton ls = LazySingleton.getInstance();
        ls.doSomething();

        System.out.println("-------------");

        BIllPughSingleton bps =  BIllPughSingleton.getInstance();

    }
}

package com.gof.creational.singleton;

public class BillPughSingleton {

    private BillPughSingleton(){

    }

    private static class Holder{
        private static BillPughSingleton instance = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance(){
        return Holder.instance;
    }

}

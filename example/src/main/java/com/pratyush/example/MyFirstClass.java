package com.pratyush.example;

import org.springframework.stereotype.Component;

//@Component
public class MyFirstClass {

    private final String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public  String sayHello() {
        return "Hello from the MyFirstClass => myVar => " + myVar;
    }
}

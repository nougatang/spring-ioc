package com.trennble.ioc;

public class HelloWorldService {
    private String value;
    private OuterService outerService;

    public HelloWorldService() {
    }

    public void helloWorld() {
        System.out.println("Hello: " + this.value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOuterService(OuterService outerService) {
        this.outerService = outerService;
    }
}
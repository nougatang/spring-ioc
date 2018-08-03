package com.trennble.ioc;

public class HelloWorldServiceImpl implements HelloWorldService {
    private String value;
    private OuterService outerService;

    public HelloWorldServiceImpl() {
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
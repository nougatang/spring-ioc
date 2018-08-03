package com.trennble.ioc;

public class OuterService {
    private String value;
    private HelloWorldServiceImpl helloWorldService;

    public OuterService() {
    }

    public void doSomeThing() {
        this.helloWorldService.setValue(this.value);
        this.helloWorldService.helloWorld();
    }
}
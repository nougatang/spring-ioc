package com.trennble.ioc;

/**
 * @author yihua.huang@dianping.com
 */
public class HelloWorldServiceImpl implements HelloWorldService {

    private String text;

    private OuterService outputService;

    public void helloWorld() {
        outputService.output(text);
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOutputService(OuterService outputService) {
        this.outputService = outputService;
    }

}

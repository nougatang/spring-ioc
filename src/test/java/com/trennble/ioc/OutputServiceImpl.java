package com.trennble.ioc;

/**
 * @author yihua.huang@dianping.com
 */
public class OutputServiceImpl implements OutputService {

    public void output(String text) {
        System.out.println(text);
    }

}

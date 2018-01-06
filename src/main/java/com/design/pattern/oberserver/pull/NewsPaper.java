package com.design.pattern.oberserver.pull;

/**
 * Created by wm on 18-1-5.
 * 报纸对象，具体的目标实现
 */
public class NewsPaper extends Subject{
    /**
     * 具体的报纸内容
     */
    private String content;

    public String getContent() {
        return content;
    }

    /**
     * 示意，设置报纸的具体内容，相当于要出版报纸
     * @param content 报纸的具体内容
     */
    public void setContent(String content) {
        this.content = content;
        //内容有了，说明又出报纸了，那就通知所有的读者
        notifyObservers();
    }
}

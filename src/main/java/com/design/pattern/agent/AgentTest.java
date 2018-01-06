package com.design.pattern.agent;

/**
 * Created by wm on 18-1-4.
 */
public class AgentTest {
    public static void main(String[] args) {
        Subject star = new Star();
        Subject proxy = new Agent(star);
        proxy.movie();
    }
}

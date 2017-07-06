package com.baidu.annotation;

/**
 * 注解使用
 * Created by sky on 17-7-5.
 */
public class Apple {
    @FruitName(value = "Apple")
    private String appleName;

    @FruitPrice(price = 10)
    private int price;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitProvider(id = 1, name = "陕西红富士集团", address = "陕西省西安市延安路")
    private String appleProvider;

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void displayName() {
        System.out.println("水果的名字是： 苹果");
    }
}

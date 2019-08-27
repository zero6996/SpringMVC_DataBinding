package com.zero.entity;

/**
 * @Author: zero
 * @Description: Date:Create: in 2019/8/26 16:28
 * Modified By:
 */

public class Goods {
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

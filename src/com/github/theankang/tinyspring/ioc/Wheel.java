package com.github.theankang.tinyspring.ioc;

public class Wheel {
    private String brand;
    private String specification ;

    // 省略其他不重要代码

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}
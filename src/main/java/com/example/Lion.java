package com.example;

import java.util.List;

public class Lion {

    boolean hasMane;

    private final LionDependency dependency;

    public Lion(String sex, LionDependency dependency) throws Exception {
        this.dependency = dependency;
        if ("Самец".equals(sex)) {
            hasMane = true;
        } else if ("Самка".equals(sex)) {
            hasMane = false;
        } else {
            throw new Exception("Используйте допустимые значения пола животного - Самец или Самка");
        }
    }

    public int getKittens() {
        return dependency.getKittens();
    }

    public boolean doesHaveMane() {
        return hasMane;
    }

    public List<String> getFood() throws Exception {
        return dependency.getFood("Хищник");
    }
}

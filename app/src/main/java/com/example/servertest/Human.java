package com.example.servertest;

import com.google.gson.annotations.SerializedName;

public class Human {
    @SerializedName("name")
    private String name;
    private String family;
    private String age;

    public Human(String name, String family, String age) {
        this.name = name;
        this.family = family;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getFamily() {
        return family;
    }

    public String getAge() {
        return age;
    }
}


package com.example.myapplication;

public class Person {
    int avatar;
    String name;
    String score;
    int id;
    String classname;
    String classcut;

    public String getClasscut() {
        return classcut;
    }

    public void setClasscut(String classcut) {
        this.classcut = classcut;
    }

    public Person(int avatar, String name, String score, int id, String classname, String classcut) {
        this.avatar = avatar;
        this.name = name;
        this.score = score;
        this.id = id;
        this.classname = classname;
        this.classcut = classcut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }



    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }



    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

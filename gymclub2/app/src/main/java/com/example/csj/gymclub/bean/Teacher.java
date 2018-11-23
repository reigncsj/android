package com.example.csj.gymclub.bean;

public class Teacher {
    private String name;
    private String introduce;
    private int imageId;
    private int id;

    public Teacher(String name, String introduce, int imageId, int id) {
        this.name = name;
        this.introduce = introduce;
        this.imageId = imageId;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", imageId=" + imageId +
                ", id='" + id + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }
}

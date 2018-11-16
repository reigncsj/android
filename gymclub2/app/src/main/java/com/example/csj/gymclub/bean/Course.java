package com.example.csj.gymclub.bean;

public class Course {
    private String title;
    private String content;
    private int imageId;

    public Course(String title,String content,int imageId) {
        this.title=title;
        this.content=content;
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imageId=" + imageId +
                '}';
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getContent() {

        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

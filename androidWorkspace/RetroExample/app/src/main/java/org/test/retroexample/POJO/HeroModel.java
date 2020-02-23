package org.test.retroexample.POJO;

public class HeroModel {

    private  String name;
    private  String realname;
    private  String team;
    private  String firstapperance;
    private  String createdby;
    private  String publisher;
    private  String imageurl;
    private  String bio;

    public HeroModel(String name, String realname, String team, String firstapperance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstapperance = firstapperance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstapperance() {
        return firstapperance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getBio() {
        return bio;
    }
}

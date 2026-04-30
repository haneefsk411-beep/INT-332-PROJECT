
package com.anime.app;

public class Anime {
    private String title;
    private double rating;
    private String image;
    private int id;

    public Anime(String t,double r,String i,int id){
        title=t;rating=r;image=i;this.id=id;
    }

    public String getTitle(){return title;}
    public double getRating(){return rating;}
    public String getImage(){return image;}
    public int getId(){return id;}
}


package com.anime.app;

public class JikanAnime {
    private int mal_id;
    private String title;
    private double score;
    private String synopsis;
    private Images images;

    public int getMal_id(){return mal_id;}
    public String getTitle(){return title;}
    public double getScore(){return score;}
    public String getSynopsis(){return synopsis;}
    public Images getImages(){return images;}

    public static class Images {
        private Jpg jpg;
        public Jpg getJpg(){return jpg;}
    }

    public static class Jpg {
        private String image_url;
        public String getImage_url(){return image_url;}
    }
}

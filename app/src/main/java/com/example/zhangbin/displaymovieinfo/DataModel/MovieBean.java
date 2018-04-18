package com.example.zhangbin.displaymovieinfo.DataModel;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangbin on 3/3/2018.
 */

public class MovieBean implements Serializable {

    @SerializedName("rating")
    private RatingData rating;

    @SerializedName("genres")
    private List<String> genres;

    @SerializedName("title")
    private String title;

    @SerializedName("casts")
    private List<MovieStaff> casts;

    @SerializedName("collect_count")
    private int collect_count;

    @SerializedName("original_title")
    private String original_title;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("directors")
    private List<MovieStaff> directors;

    @SerializedName("year")
    private String year;

    @SerializedName("images")
    private Map<String,String> images;

    @SerializedName("alt")
    private String alt;

    @SerializedName("id")
    private String id;

    public RatingData getRating() {
        return rating;
    }

    public void setRating(RatingData rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<MovieStaff> getCasts() {
        return casts;
    }

    public void setCasts(List<MovieStaff> casts) {
        this.casts = casts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<MovieStaff> getDirectors() {
        return directors;
    }

    public void setDirectors(List<MovieStaff> directors) {
        this.directors = directors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Map<String, String> getImages() {
        return images;
    }

    public void setImages(Map<String, String> images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
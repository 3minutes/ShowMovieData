package com.example.zhangbin.displaymovieinfo.DataModel;

import java.util.List;

/**
 * Created by zhangbin on 3/3/2018.
 */

public class JsonObject {

    private int count;
    private int start;
    private int total;
    private List<MovieBean> subjects;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MovieBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MovieBean> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

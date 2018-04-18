package com.example.zhangbin.displaymovieinfo.DataModel;

import java.util.Map;

/**
 * Created by zhangbin on 3/3/2018.
 */

public class MovieStaff {
    private String alt;
    private Map<String,String> avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Map<String, String> getAvatars() {
        return avatars;
    }

    public void setAvatars(Map<String, String> avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

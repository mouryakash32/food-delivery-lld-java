package org.exampl.model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    public static Integer ReferenceId = 0;
    public Integer RestaurentId;
    public String name;
    public String location;
    public List<MenuItem> menu;

    public Restaurant( String restaurentName, String location) {
        RestaurentId = ++ReferenceId;
        this.location = location;
        name = restaurentName;
        menu = new ArrayList<>();
    }

    public String getLocation() {
        return location;
    }
    public void addmenue(MenuItem menuItem){
        this.menu.add(menuItem);
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Integer getReferenceId() {
        return ReferenceId;
    }

    public static void setReferenceId(Integer referenceId) {
        ReferenceId = referenceId;
    }

    public Integer getRestaurentId() {
        return RestaurentId;
    }

    public void setRestaurentId(Integer restaurentId) {
        RestaurentId = restaurentId;
    }





}

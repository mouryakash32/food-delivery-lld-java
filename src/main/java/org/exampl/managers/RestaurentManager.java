package org.exampl.managers;

import org.exampl.model.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurentManager {
    List<Restaurant> restaurantList = new ArrayList<>();
    public static RestaurentManager restaurentManager = null;
    public static RestaurentManager getInstance(){
        if(restaurentManager == null){
            restaurentManager = new RestaurentManager();
        }
        return restaurentManager;
    }
    private RestaurentManager(){
        //private constructor
    }

    public void addRestaurent(Restaurant restaurant){
        restaurantList.add(restaurant);
    }

    public void removeRestaurent(Integer id){
        restaurantList = restaurantList
                .stream()
                .filter(restaurant -> restaurant.RestaurentId != id)
                .toList();
    }


    public List<Restaurant> searchByLocation(String location){
        List<Restaurant>restaurants = new ArrayList<>();
        for(Restaurant restaurant: restaurantList){
            if(restaurant.location.equalsIgnoreCase(location)){
                restaurants.add(restaurant);
            }
        }
        return restaurants;
    }

}

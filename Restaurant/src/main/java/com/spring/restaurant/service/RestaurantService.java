package com.spring.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.restaurant.model.Restaurant;
import com.spring.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {
	@Autowired
	private RestaurantRepository repository;
	public List<Restaurant> getRestaurants(){
		return repository.findAll();
	}
	public Optional<Restaurant> getRestaurantbyId(int id) {
		return repository.findById(id);
	}
	public Restaurant addRestaurant(Restaurant restaurant) {
		return repository.save(restaurant);
	}
	public Restaurant editRestaurant(Restaurant restaurant, int id) {
		Restaurant resx = repository.findById(id).orElse(null);
		if (resx != null) {
			resx.setRname(restaurant.getRname());
			resx.setRating(restaurant.getRating());	
			resx.setLocation(restaurant.getLocation());
			return repository.saveAndFlush(resx);
		}
		else {
			return null;
		}
	}
	public String deleteRestaurant(int id) {
		repository.deleteById(id);
		return id+" Deleted !";
	}
}

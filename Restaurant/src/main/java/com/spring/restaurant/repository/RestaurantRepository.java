package com.spring.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.restaurant.model.Restaurant;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}

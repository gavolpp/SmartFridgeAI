package com.gavolpp.SmartFridgeAI.repository;

import com.gavolpp.SmartFridgeAI.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

}

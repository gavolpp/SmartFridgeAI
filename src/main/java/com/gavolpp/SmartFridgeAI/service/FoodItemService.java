package com.gavolpp.SmartFridgeAI.service;

import com.gavolpp.SmartFridgeAI.model.FoodItem;
import com.gavolpp.SmartFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private FoodItemRepository foodRepo;

    public FoodItemService(FoodItemRepository foodRepo) {
        this.foodRepo = foodRepo;
    }

    public FoodItem insert(FoodItem foodItem){
            return foodRepo.save(foodItem);
        }

        public List<FoodItem> list(){
            return foodRepo.findAll();
        }

        public Optional<FoodItem> findId(long id){
            return foodRepo.findById(id);
        }

        public void delete(long id){
            foodRepo.deleteById(id);
        }

        public FoodItem update(FoodItem foodItem){
            return foodRepo.save(foodItem);
        }
    }


package com.gavolpp.SmartFridgeAI.controller;

import com.gavolpp.SmartFridgeAI.model.FoodItem;
import com.gavolpp.SmartFridgeAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    @PostMapping
    public ResponseEntity<FoodItem> create(@RequestBody FoodItem fooditem){
        FoodItem saved = foodItemService.insert(fooditem);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<FoodItem>> listAll(){
        List<FoodItem> foodList = foodItemService.list();
        return ResponseEntity.ok(foodList);
    }
    @PutMapping("/{id}")
    public Optional<ResponseEntity<FoodItem>> update(@RequestBody FoodItem foodItem, @PathVariable Long id){
        return Optional.of((foodItemService.listById(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = foodItemService.update(foodItem);
                    return ResponseEntity.ok(atualizado);
                }).orElse(ResponseEntity.notFound().build())));
    }
    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable long id){
        foodItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

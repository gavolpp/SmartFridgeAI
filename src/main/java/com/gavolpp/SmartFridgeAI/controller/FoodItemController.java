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
    @PostMapping("/create")
    public void create(@RequestBody FoodItem fooditem){
        foodItemService.insert(fooditem);
    }
    @GetMapping("/listAll")
    public ResponseEntity<List<FoodItem>> listAll(){
        List<FoodItem> foodList = foodItemService.list();
        return ResponseEntity.ok(foodList);
    }
    @GetMapping("/findId/{id}")
    public ResponseEntity<Optional<FoodItem>> findId(@PathVariable long id){
        Optional<FoodItem> foodItem = foodItemService.findId(id);
        return ResponseEntity.ok(foodItem);
    }
    @PutMapping("/update/{id}")
    public Optional<ResponseEntity<FoodItem>> update(@RequestBody FoodItem foodItem, @PathVariable Long id){
        return Optional.of((foodItemService.findId(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = foodItemService.update(foodItem);
                    return ResponseEntity.ok(atualizado);
                }).orElse(ResponseEntity.notFound().build())));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> excluir(@PathVariable long id){
        foodItemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

package com.gavolpp.SmartFridgeAI.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "food_item")
@NoArgsConstructor
@AllArgsConstructor
public class FoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    private String nome;
    private enum categoria{vegetais, carne, laticineos, frutas};
    private Integer quantidade;
    private LocalDate validade;

}

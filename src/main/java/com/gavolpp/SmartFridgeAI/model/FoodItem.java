package com.gavolpp.SmartFridgeAI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDateTime validade;

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public Integer getQuantidade() {return quantidade;}
    public void setQuantidade(Integer quantidade) {this.quantidade = quantidade;}
    public LocalDateTime getValidade() {return validade;}
    public void setValidade(LocalDateTime validade) {this.validade = validade;}
}

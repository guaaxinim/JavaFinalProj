/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 *
 * @author luisr
 */
public enum Rarity {
    FOUR_STARS("4-stars"),
    FIVE_STARS("5-stars");

    private String characterRarity;

    Rarity(String characterRarity){
        this.characterRarity = characterRarity;
    }

    /**
     * @return character's rarity
     */
    @Override
    public String toString() {
        return this.characterRarity;
    }
}

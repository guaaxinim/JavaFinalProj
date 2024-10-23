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
    
    public String getRarity(){
        return characterRarity;
    }

    /**
     * Take a String value and check if there is a match among the enum constants.
     * @param rarityString
     * @return Rarity constant
     */
    public static Rarity fromString(String rarityString){
        for (Rarity rarity : Rarity.values()){
            if (rarity.getRarity().equalsIgnoreCase(rarityString)){
                return rarity;
            }
        }
        throw new IllegalArgumentException("Rarity is not in enum!");
    }
    
    /**
     * @return character's rarity
     */
    @Override
    public String toString() {
        return this.characterRarity;
    }
}

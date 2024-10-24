package com.mycompany.consts;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Contains all Genshin Impact characters constellations levels.
 * @author luisr
 */
public enum ConstellationsLevel {
    C0("C0"),
    C1("C1"),
    C2("C2"),
    C3("C3"),
    C4("C4"),
    C5("C5"),
    C6("C6");

    private String characterConstellationsLevel;

    ConstellationsLevel(String characterConstellationsLevel){
        this.characterConstellationsLevel = characterConstellationsLevel;
    }

    public String getConstellationsLevel(){
        return characterConstellationsLevel;
    }

    /**
     * Take a String value and check if there is a match among the enum constants.
     * @param constellationsLevelString
     * @return ConstellationsLevel constant
     */
    public static ConstellationsLevel fromString(String constellationsLevelString){
        for (ConstellationsLevel constellationsLevel : ConstellationsLevel.values()){
            if (constellationsLevel.getConstellationsLevel().equalsIgnoreCase(constellationsLevelString)){
                return constellationsLevel;
            }
        }
        throw new IllegalArgumentException("Constellation Level is not in enum!");
    }

    /**
     * @return character's constellations level
     */
    @Override
    public String toString() {
        return this.characterConstellationsLevel;
    }
}

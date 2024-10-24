/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 * Contains all Genshin Impact characters visions.
 * @author luisr
 */
public enum Vision {
    ANEMO("Anemo"),
    CRYO("Cryo"),
    DENDRO("Dendro"),
    ELECTRO("Electro"),
    GEO("Geo"),
    HYDRO("Hydro"),
    PYRO("Pyro");

    private String characterVision;

    Vision(String characterVision){
        this.characterVision = characterVision;
    }

    public String getVision(){
        return characterVision;
    }

    /**
     * Take a String value and check if there is a match among the enum constants.
     * @param visionString
     * @return Vision constant
     */
    public static Vision fromString(String visionString){
        for (Vision vision : Vision.values()){
            if (vision.getVision().equalsIgnoreCase(visionString)){
                return vision;
            }
        }
        throw new IllegalArgumentException("Vision is not in enum");
    }
    
    /**
     * @return character's vision
     */
    @Override
    public String toString() {
        return this.characterVision;
    }
}

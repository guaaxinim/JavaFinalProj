/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 *
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

    /**
     * @return character's vision
     */
    @Override
    public String toString() {
        return this.characterVision;
    }
}

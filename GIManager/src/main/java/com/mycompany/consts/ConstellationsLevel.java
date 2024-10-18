package com.mycompany.consts;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
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

    /**
     * @return character's constellations level
     */
    @Override
    public String toString() {
        return this.characterConstellationsLevel;
    }
}

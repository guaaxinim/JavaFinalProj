/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 *
 * @author luisr
 */
public enum Weapon {
    BOW("Bow"),
    CATALYST("Catalyst"),
    CLAYMORE("Claymore"),
    POLEARM("Polearm"),
    SWORD("Sword");

    private String characterWeapon;

    Weapon(String characterWeapon){
        this.characterWeapon = characterWeapon;
    }

    /**
     * @return character's weapon
     */
    @Override
    public String toString() {
        return this.characterWeapon;
    }
}

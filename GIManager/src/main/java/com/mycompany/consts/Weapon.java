/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 * Contains all Genshin Impact characters weapons.
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

    public String getWeapon(){
        return characterWeapon;
    }

    /**
     * Take a String value and check if there is a match among the enum constants.
     * @param weaponString
     * @return Weapon constant
     */
    public static Weapon fromString(String weaponString){
        for (Weapon weapon : Weapon.values()){
            if (weapon.getWeapon().equalsIgnoreCase(weaponString)){
                return weapon;
            }
        }
        throw new IllegalArgumentException("Weapon is not in enum!");
    }

    /**
     * @return character's weapon
     */
    @Override
    public String toString() {
        return this.characterWeapon;
    }
}

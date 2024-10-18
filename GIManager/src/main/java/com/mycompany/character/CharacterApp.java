/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.character;

import com.mycompany.consts.CharacterName;
import com.mycompany.consts.Vision;
import com.mycompany.consts.Weapon;
import com.mycompany.consts.Rarity;
import com.mycompany.consts.ConstellationsLevel;

/**
 *
 * @author luisr
 */
public class CharacterApp {
    public static void main(String[] args) {       
        Character char1 = new Character(CharacterName.ARLECCHINO, Vision.PYRO, Weapon.POLEARM, Rarity.FIVE_STARS, ConstellationsLevel.C0, "2024/10/04");

        System.out.println(char1.getName());
        System.out.println(char1.getVision());
        System.out.println(char1.getWeapon());
        System.out.println(char1.getRarity());
        System.out.println(char1.getConstellationsLevel());

        char1.setName(CharacterName.BENNET);
        char1.setVision(Vision.PYRO);
        char1.setWeapon(Weapon.SWORD);
        char1.setRarity(Rarity.FOUR_STARS);
        char1.setConstellationsLevel(ConstellationsLevel.C6);

        System.out.println(char1.getName());
        System.out.println(char1.getVision());
        System.out.println(char1.getWeapon());
        System.out.println(char1.getRarity());
        System.out.println(char1.getConstellationsLevel());
    }
}

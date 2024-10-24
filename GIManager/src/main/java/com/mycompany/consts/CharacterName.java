/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.consts;

/**
 * Contains all Genshin Impact characters names.
 * @author luisr
 */
public enum CharacterName {
    // ------------------------------------------------------- |A|
    ALBEDO("Albedo"),
    ALHAITHAM("Alhaitham"),
    ALOY("Aloy"),
    AMBER("Amber"),
    ARATAKI_ITTO("Arataki Itto"),
    ARLECCHINO("Arlecchino"),
    // ------------------------------------------------------- |B|
    BARBARA("Barbara"),
    BEIDOU("Beidou"),
    BENNET("Bennet"),
    // ------------------------------------------------------- |C|
    CANDACE("Candace"),
    CHARLOTTE("Charlotte"),
    CHASCA("Chasca"),
    CHEVREUSE("Chevreuse"),
    CHIORI("Chiori"),
    CHONGYUN("Chongyun"),
    CLORINDE("Clorinde"),
    COLLEI("Collei"),
    CYNO("Cyno"),
    // ------------------------------------------------------- |D|
    DEHYA("Dehya"),
    DILUC("Diluc"),
    DIONA("Diona"),
    DORI("Dori"),
    // ------------------------------------------------------- |E|
    EMILIE("Emilie"),
    EULA("Eula"),
    // ------------------------------------------------------- |F|
    FARUZAN("Faruzan"),
    FISCHL("Fischl"),
    FREMINET("Freminet"),
    FURINA("Furina"),
    // ------------------------------------------------------- |G|
    GAMING("Gaming"),
    GANYU("Ganyu"),
    GOROU("Gorou"),
    // ------------------------------------------------------- |H|
    HUTAO("Hutao"),
    // ------------------------------------------------------- |J|
    JEAN("Jean"),
    // ------------------------------------------------------- |K|
    KACHINA("Kachina"),
    KAEDEHARA_KAZUHA("Kaedehara Kazuha"),
    KAEYA("Kaeya"),
    KAMISATO_AYAKA("Kamisato Ayaka"),
    KAMISATO_AYATO("Kamisato Ayato"),
    KAVEH("Kaveh"),
    KEQING("Keqing"),
    KINICH("Kinich"),
    KIRARA("Kirara"),
    KLEE("Klee"),
    KUJOU_SARA("Kujou Sara"),
    KUKI_SHINOBU("Kuki Shinobu"),
    // ------------------------------------------------------- |L|
    LAYLA("Layla"),
    LISA("Lisa"),
    LYNETTE("Lynette"),
    LYNEY("Lyney"),
    // ------------------------------------------------------- |M|
    MIKA("Mika"),
    MONA("Mona"),
    MUALANI("Mualani"),
    // ------------------------------------------------------- |N|
    NAHIDA("Nahida"),
    NAVIA("Navia"),
    NEUVILLETTE("Neuvillette"),
    NILOU("Nilou"),
    NINGGUANG("Ningguang"),
    NOELLE("Noelle"),
    // ------------------------------------------------------- |O|
    ORORON("Ororon"),
    // ------------------------------------------------------- |Q|
    QIQI("Qiqi"),
    // ------------------------------------------------------- |R|
    RAIDEN_SHOGUN("Raiden Shogun"),
    RAZOR("Razor"),
    ROSARIA("Rosaria"),
    // ------------------------------------------------------- |S|
    SANGONOMIYA_KOKOMI("Sangonomiya Kokomi"),
    SAYU("Sayu"),
    SETHOS("Sethos"),
    SHENHE("Shenhe"),
    SHIKANOIN_HEIZOU("Shikanoin Heizou"),
    SIGEWINNE("Sigewinne"),
    SUCROSE("Sucrose"),
    // ------------------------------------------------------- |T|
    TARTAGLIA("Tartaglia"),
    THOMA("Thoma"),
    TIGHNARI("Tighnari"),
    // ------------------------------------------------------- |V|
    VENTI("Venti"),
    // ------------------------------------------------------- |W|
    WANDERER("Wanderer"),
    WRIOTHESLEY("Wriothesley"),
    // ------------------------------------------------------- |X|
    XIANGLING("Xiangling"),
    XIANYUN("Xianyun"),
    XIAO("Xiao"),
    XILONEN("Xilonen"),
    XINGQIU("Xingqiu"),
    XINYAN("Xinyan"),
    // ------------------------------------------------------- |Y|
    YAE_MIKO("Yae Miko"),
    YANFEI("Yanfei"),
    YAOYAO("Yaoyao"),
    YELAN("Yelan"),
    YOIMIYA("Yoimiya"),
    YUNJIN("Yunjin"),
    // ------------------------------------------------------- |Z|
    ZHONGLI("Zhongli");

    private String characterName;

    CharacterName(String characterName){
        this.characterName = characterName;
    }

    public String getName(){
        return characterName;
    }

    /**
     * Take a String value and check if there is a match among the enum constants.
     * @param nameString
     * @return CharacterName constant
     */
    public static CharacterName fromString(String nameString){
        for (CharacterName name : CharacterName.values()){
            if (name.getName().equalsIgnoreCase(nameString)){
                return name;
            }
        }
        throw new IllegalArgumentException("Name is not in enum!");
    }

    /**
     * @return character's name
     */
    @Override
    public String toString() {
        return this.characterName;
    }
}

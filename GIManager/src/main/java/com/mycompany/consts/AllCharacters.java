package com.mycompany.consts;

public enum AllCharacters {

    ALBEDO(CharacterName.ALBEDO, Vision.GEO, Weapon.SWORD, Rarity.FIVE_STARS),
    ALHAITHAM(CharacterName.ALHAITHAM, Vision.DENDRO, Weapon.SWORD, Rarity.FIVE_STARS),
    ALOY(CharacterName.ALOY, Vision.CRYO, Weapon.BOW, Rarity.FOUR_STARS),
    AMBER(CharacterName.AMBER, Vision.PYRO, Weapon.BOW, Rarity.FOUR_STARS);

    private CharacterName characterName;
    private Vision characterVision;
    private Weapon characterWeapon;
    private Rarity characterRarity;

    AllCharacters(CharacterName characterName, Vision characterVision, Weapon characterWeapon, Rarity characterRarity){
        this.characterName = characterName;
        this.characterVision = characterVision;
        this.characterWeapon = characterWeapon;
        this.characterRarity = characterRarity;
    }

    public CharacterName getCharacterName(){
        return this.characterName;
    }

    public Vision getCharacterVision(){
        return this.characterVision;
    }

    public Weapon getCharacterWeapon(){
        return this.characterWeapon;
    }

    public Rarity getCharacterRarity(){
        return this.characterRarity;
    }
}

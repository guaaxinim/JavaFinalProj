package character;

import consts.CharacterName;
import consts.Vision;
import consts.Weapon;
import consts.Rarity;
import consts.ConstellationsLevel;

/**
 * The {@code Character} represents a Genshin Impact character and its atributtes.<p>
 * It must be used to create characters instances, like:
 * <p>
 * <blockquuote><pre>
 * Character character = new Character("Bennet", "Pyro", "Sword", "4-STAR", "C6", "02/02/2022")
 * </pre></blockquote>
 * <p>
 * And, possibly, storage these values in a database's table.<p>
 * Methods:<p>
 * <blockquote><pre>
 * Modifiers
 * setName(); // Set a value to character's name.
 * setVision(); // Set a value to character's vision.
 * setWeapon(); // Set a value to character's weapon.
 * setRarity(); // Set a value to character's Rarity.
 * setConstellationsLevel(); // Set a value to character's constellations level.
 * setMeetDate(); // Set a value to Character's obtaining date.
 * </pre></blockquote>
 * <p>
 * <blockquote><pre>
 * Returners
 * getName(); // Return character's name value.
 * getVision(); // Return character's vision value.
 * getWeapon(); // Return character's weapon value.
 * getRarity(); // Return character's rarity value.
 * getConstellationsLevel(); // Return character's constellations level value.
 * getMeetDate(); // Return character's obtaining date value.
 * </pre></blockquote>
 */
public final class Character {

    private CharacterName name;
    private Vision vision;
    private Weapon weapon;
    private Rarity rarity;
    private ConstellationsLevel constellationsLevel;
    private String meetDate;

    /**
     * Constructs a Character object with the parameters given.
     * @param name character's name.
     * @param vision vision that character wields.
     * @param weapon weapon that character wields.
     * @param rarity character's rarity.
     * @param constellationsLevel character's constellations level.
     * @param meetDate character's obtaining date.
     */
    public Character(CharacterName name, Vision vision, Weapon weapon, Rarity rarity, ConstellationsLevel constellationsLevel, String meetDate){
        this.name = name;
        this.vision = vision;
        this.weapon = weapon;
        this.rarity = rarity;
        this.constellationsLevel = constellationsLevel;
        this.meetDate = meetDate;
    }

    /**
     * Set character's name value.
     * @param name character's (new) name.
     */
    public void setName(CharacterName name){
        this.name = name;
    }

    /**
     * Set character's vision value.
     * @param vision (new) vision that character wields.
     */
    public void setVision(Vision vision){
        //boolean inArray = check.inArray(CharacterConstants.VISIONS, vision);
        this.vision = vision;
    }

    /**
     * Set character's weapon value.
     * @param weapon (new) weapon that character wields.
     */
    public void setWeapon(Weapon weapon){
        //boolean inArray = check.inArray(CharacterConstants.WEAPONS, weapon);
        this.weapon = weapon;
    }

    /**
     * Set character's rarity value.
     * @param rarity character's (new) rarity.
     */
    public void setRarity(Rarity rarity){
        //boolean inArray = check.inArray(CharacterConstants.RARIIES, rarity);
        this.rarity = rarity;
    }

    /**
     * Set character's constellations level.
     * @param constellationsLevel character's (new) constellations levels.
     */
    public void setConstellationsLevel(ConstellationsLevel constellationsLevel){
        //boolean inArray = check.inArray(CharacterConstants.CONSTELLATIONS_LEVELS, constellationsLevel);
        this.constellationsLevel = constellationsLevel;
    }

    /**
     * Set character's obtaining date.
     * @param meetDate character's (new) obtaining date.
     */
    public void setMeetDate(String meetDate){
        this.meetDate = meetDate;
    }

    /**
     * Return character's name value.
     * @return character's name.
     */
    public CharacterName getName(){
        return this.name;
    }

    /**
     * Return character's vision value.
     * @return character's vision.
     */
    public Vision getVision(){
        return this.vision;
    }

    /**
     * Return character's weapon value.
     * @return character's weapon.
     */
    public Weapon getWeapon(){
        return this.weapon;
    }

    /**
     * Return character's rarity value.
     * @return character's rarity.
     */
    public Rarity getRarity(){
        return this.rarity;
    }

    /**
     * Return character's constellations level value.
     * @return character's constellations level.
     */
    public ConstellationsLevel getConstellationsLevel(){
        return this.constellationsLevel;
    }

    /**
     * Return character's obtaining date.
     * @return character's obatining date.
     */
    public String getMeetDate(){
        return this.meetDate;
    }
}

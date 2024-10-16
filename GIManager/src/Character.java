import util.CheckItemInArray;
import util.CharacterConstants;

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

    CheckItemInArray check = new CheckItemInArray();

    private String name;
    private String vision;
    private String weapon;
    private String rarity;
    private String constellationsLevel;
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
    public Character(String name, String vision, String weapon, String rarity, String constellationsLevel, String meetDate){
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
    public void setName(String name){
        this.name = name;
    }

    /**
     * Set character's vision value.
     * @param vision (new) vision that character wields.
     */
    public void setVision(String vision){
        boolean inArray = check.inArray(CharacterConstants.VISIONS, vision);
        if (inArray){
            this.vision = vision;
        }
        else{System.out.println("Invalid Vision!");}
    }

    /**
     * Set character's weapon value.
     * @param weapon (new) weapon that character wields.
     */
    public void setWeapon(String weapon){
        boolean inArray = check.inArray(CharacterConstants.WEAPONS, weapon);
        if (inArray){
            this.weapon = weapon;
        }
        else{System.out.println("invalid Weapon!");}
    }

    /**
     * Set character's rarity value.
     * @param rarity character's (new) rarity.
     */
    public void setRarity(String rarity){
        boolean inArray = check.inArray(CharacterConstants.RARIIES, rarity);
        if (inArray){
            this.rarity = rarity;
        }
        else{System.out.println("Invalid Rarity!");}
    }

    /**
     * Set character's constellations level.
     * @param constellationsLevel character's (new) constellations levels.
     */
    public void setConstellationsLevel(String constellationsLevel){
        boolean inArray = check.inArray(CharacterConstants.CONSTELLATIONS_LEVELS, constellationsLevel);
        if (inArray){
            this.constellationsLevel = constellationsLevel;
        }
        else{System.out.println("Invalid Constellations Level!");}
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
    public String getName(){
        return this.name;
    }

    /**
     * Return character's vision value.
     * @return character's vision.
     */
    public String getVision(){
        return this.vision;
    }

    /**
     * Return character's weapon value.
     * @return character's weapon.
     */
    public String getWeapon(){
        return this.weapon;
    }

    /**
     * Return character's rarity value.
     * @return character's rarity.
     */
    public String getRarity(){
        return this.rarity;
    }

    /**
     * Return character's constellations level value.
     * @return character's constellations level.
     */
    public String getConstellationsLevel(){
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

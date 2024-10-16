import character.Character;
import consts.CharacterName;
import consts.Vision;
import consts.Weapon;
import consts.Rarity;
import consts.ConstellationsLevel;

public class User {

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

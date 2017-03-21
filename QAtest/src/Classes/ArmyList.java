package Classes;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class ArmyList {
    Random random = new Random();

    private ArrayList<Character> Army;

    public ArmyList() {
        Army = new ArrayList<>();
    }

    public int getCharacter() {
        return random.nextInt(Army.size());
    }

    public void addTroops(Character character) {
        Army.add(character);
    }

    public ArrayList<Character> getArmy() {
        return Army;
    }

    public boolean isAllMoved() {
        for (Character ch : Army
                ) {
            if (ch.isMoved() == false) return false;

        }
        return true;
    }

    public ArrayList<Character> getPrivilegedTroops() {

        ArrayList<Character> privilegedMembers = new ArrayList<>();
        for (Character character : Army)
            if (character.isPrivileged()) privilegedMembers.add(character);

        return privilegedMembers;
    }

    public ArrayList<Character> getNonMovedCharacter() {
        ArrayList<Character> nonMovedCharacter = new ArrayList<>();
        for (Character character : getArmy())
            if (!character.isMoved()) nonMovedCharacter.add(character);
        return nonMovedCharacter;
    }

    public void pullOffAllDebuffs() {
        for (Character character : Army) {
            if (character.isCursed()) {
                character.setCursed(false);
                character.setPrivileged(true);

            }
        }
    }

    public void setAllMembersNonCursed() {
        for (Character character : Army) {
            character.setCursed(false);
        }
    }

    public ArrayList<Character> getNonMovedPrivilageTroops() {
        ArrayList<Character> nonMovedPrivMembrs = new ArrayList<>();
        for (Character character : getPrivilegedTroops()) {
            if (!character.isMoved()) nonMovedPrivMembrs.add(character);
        }
        return nonMovedPrivMembrs;
    }

    public void setAllNotMoved() {
        for (Character character : Army) {
            character.setMoved(false);
        }
    }

}

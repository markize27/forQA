package Classes.Melee;

import Classes.Army.Horde;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class OrcMelee extends Character implements Horde {
    public OrcMelee(boolean privileged) {
        super(privileged);
        setCharacterClass("Гоблин");
    }

    @Override
    public String move(Character character) {
        character.setHp(character.getHp() - 15 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + "  атакует дубиной (нанесение урона " + 15 * hitRate() + " HP) " + character.getCharacterClass() + "\r\n";
    }
}

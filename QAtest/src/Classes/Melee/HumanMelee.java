package Classes.Melee;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class HumanMelee extends Character implements Alliance {
    public HumanMelee(boolean privileged) {
        super(privileged);
        setCharacterClass("Воин людей");
    }
    @Override
    public String move(Character character) {
        character.setHp(character.getHp() - 15 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует мечом (нанесение урона " + 15 * hitRate() + " HP) " + character.getCharacterClass() + "\r\n";
    }

}

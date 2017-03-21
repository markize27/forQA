package Classes.Melee;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class ElfMelee extends Character implements Alliance {
    public ElfMelee(boolean privileged) {
        super(privileged);
        setCharacterClass("Воин эльфов");
    }

    @Override
    public String move(Character character) {
        character.setHp(character.getHp() - 15 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует мечом (нанесение урона " + 15 * hitRate() + " HP) " + character.getCharacterClass() + "\r\n";
    }
}

package Classes.Melee;

import Classes.Army.Horde;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class UndeadMelee extends Character implements Horde {
    public UndeadMelee(boolean privileged) {
        super(privileged);
        setCharacterClass("Зомби");
    }

    @Override
    public String move(Character character) {
        character.setHp(character.getHp() - 15 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " удар копьем (нанесение урона " + 15 * hitRate() + " HP) " + character.getCharacterClass() + "\r\n";
    }
}

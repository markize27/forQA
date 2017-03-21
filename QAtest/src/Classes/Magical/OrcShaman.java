package Classes.Magical;

import Classes.Army.Horde;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class OrcShaman extends Character implements Horde, Shaman {
    public OrcShaman(boolean privileged) {
        super(privileged);
        setCharacterClass("Шаман");
    }

    @Override
    public String move(Character character) {
        return (character instanceof Horde) ? buff(character) : debuff(character);
    }

    public String buff(Character ally) {
        ally.setPrivileged(true);
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " наложение улучшение на " + ally.getCharacterClass() + "\r\n";
    }

    public String debuff(Character enemy) {
        enemy.setDebuffed(true);
        enemy.setPrivileged(false);
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " наложение дебаффа на  " + enemy.getCharacterClass() + "\r\n";
    }
}

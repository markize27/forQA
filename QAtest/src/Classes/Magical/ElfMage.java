package Classes.Magical;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class ElfMage extends Character implements Alliance, Mage {
    public ElfMage(boolean privileged) {
        super(privileged);
        setCharacterClass("Маг эльфов");
    }

    public String move(Character character) {
        return (character instanceof Alliance) ? buff(character) : attack(character);
    }

    public String buff(Character ally) {
        ally.setPrivileged(true);
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " наложение улучшение на " + ally.getCharacterClass() + "\r\n";
    }

    public String attack(Character enemy) {
        enemy.setHp(enemy.getHp() - 10 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует магией (нанесение урона " + 10 * hitRate() + " HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

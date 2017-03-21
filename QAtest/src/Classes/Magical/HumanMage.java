package Classes.Magical;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class HumanMage extends Character implements Alliance, Mage {
    public HumanMage(boolean privileged) {
        super(privileged);
        setCharacterClass("Маг людей");
    }

    @Override
    public String move(Character character) {
        return (character instanceof Alliance) ? buff(character) : attack(character);
    }

    public String buff(Character ally) {
        ally.setPrivileged(true);
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " наложение улучшение на " + ally.getCharacterClass() + "\r\n";
    }

    public String attack(Character enemy) {
        enemy.setHp(enemy.getHp() - 4 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует магией (нанесение урона " + 4 * hitRate() + "  HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

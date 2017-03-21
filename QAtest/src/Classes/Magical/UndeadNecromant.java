package Classes.Magical;

import Classes.Army.Horde;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class UndeadNecromant extends Character implements Horde {
    public UndeadNecromant(boolean privileged) {
        super(privileged);
        setCharacterClass("Некромант");
    }

    public String move(Character character) {
        return (random.nextBoolean()) ? debuff(character) : attack(character);
    }

    public String debuff(Character enemy) {
        enemy.setCursed(true);
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " проклинает " + enemy.getCharacterClass() + "\r\n";
    }

    public String attack(Character enemy) {
        enemy.setHp(enemy.getHp() - 5 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует (нанесение урона " + 5 * hitRate() + " HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

package Classes.Range;

import Classes.Army.Horde;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class OrcArcher extends Character implements Horde {
    public OrcArcher(boolean privileged) {
        super(privileged);
        setCharacterClass("Лучник орков");
    }

    public String move(Character character) {
        return (random.nextBoolean()) ? rangeAttack(character) : meleeAttack(character);
    }

    public String rangeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 3 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " стреляет из лука (нанесение урона " + 3 * hitRate() + " HP) в " + enemy.getCharacterClass() + "\r\n";
    }

    public String meleeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 2 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует (нанесение урона " + 2 * hitRate() + " HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

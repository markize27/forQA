package Classes.Range;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class HumanArcher extends Character implements Alliance {
    public HumanArcher(boolean privileged) {
        super(privileged);
        setCharacterClass("Лучник людей");
    }

    public String move(Character character) {
        return (random.nextBoolean()) ? rangeAttack(character) : meleeAttack(character);
    }

    public String rangeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 5 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " стреляет из арбалета (нанесение урона " + 5 * hitRate() + " HP) в " + enemy.getCharacterClass() + "\r\n";
    }

    public String meleeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 3 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует (нанесение урона " + 3 * hitRate() + " HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

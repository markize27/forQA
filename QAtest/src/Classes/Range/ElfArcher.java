package Classes.Range;

import Classes.Army.Alliance;
import Classes.Character;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class ElfArcher extends Character implements Alliance {
    public ElfArcher(boolean privileged) {
        super(privileged);
        setCharacterClass("Лучник эльфов");
    }
    @Override
    public String move(Character character) {
        return (random.nextBoolean()) ? rangeAttack(character) : meleeAttack(character);
    }

    public String rangeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 7 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " стреляет из лука (нанесение урона " + 7 * hitRate() + " HP) в " + enemy.getCharacterClass() + "\r\n";
    }

    public String meleeAttack(Character enemy) {
        enemy.setHp(enemy.getHp() - 3 * hitRate());
        return ((isPrivileged()) ? "Улучшеный " : "") + this.getCharacterClass() + " атакует (нанесение урона " + 3 * hitRate() + " HP) " + enemy.getCharacterClass() + "\r\n";
    }
}

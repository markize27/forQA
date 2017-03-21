package Classes.Controller;

import Classes.ArmyList;
import Classes.Character;
import Classes.Magical.*;
import Classes.Melee.ElfMelee;
import Classes.Melee.HumanMelee;
import Classes.Melee.OrcMelee;
import Classes.Melee.UndeadMelee;
import Classes.Range.ElfArcher;
import Classes.Range.HumanArcher;
import Classes.Range.OrcArcher;
import Classes.Range.UndeadArcher;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Mikhail on 17.03.2017.
 */
public class GameController {
    private String fullLog = "";
    private ArmyList alliance;
    private ArmyList horde;
    private Random random;

    public void start() {

        alliance = new ArmyList();
        horde = new ArmyList();
        random = new Random();

        fullLog += "\r\nОбъявление армий\r\n";

        if (random.nextBoolean()) {
            horde.addTroops(new UndeadNecromant(random.nextBoolean()));
            horde.addTroops(new UndeadArcher(random.nextBoolean()));
            horde.addTroops(new UndeadArcher(random.nextBoolean()));
            horde.addTroops(new UndeadArcher(random.nextBoolean()));
            horde.addTroops(new UndeadMelee(random.nextBoolean()));
            horde.addTroops(new UndeadMelee(random.nextBoolean()));
            horde.addTroops(new UndeadMelee(random.nextBoolean()));
            horde.addTroops(new UndeadMelee(random.nextBoolean()));
            fullLog += "\r\nОрда - нежить!\r\n";
        } else {
            horde.addTroops(new OrcShaman(random.nextBoolean()));
            horde.addTroops(new OrcArcher(random.nextBoolean()));
            horde.addTroops(new OrcArcher(random.nextBoolean()));
            horde.addTroops(new OrcArcher(random.nextBoolean()));
            horde.addTroops(new OrcMelee(random.nextBoolean()));
            horde.addTroops(new OrcMelee(random.nextBoolean()));
            horde.addTroops(new OrcMelee(random.nextBoolean()));
            horde.addTroops(new OrcMelee(random.nextBoolean()));
            fullLog += "\r\nОрда - орки!\r\n";
        }
        if (random.nextBoolean()) {
            alliance.addTroops(new ElfMage(random.nextBoolean()));
            alliance.addTroops(new ElfArcher(random.nextBoolean()));
            alliance.addTroops(new ElfArcher(random.nextBoolean()));
            alliance.addTroops(new ElfArcher(random.nextBoolean()));
            alliance.addTroops(new ElfMelee(random.nextBoolean()));
            alliance.addTroops(new ElfMelee(random.nextBoolean()));
            alliance.addTroops(new ElfMelee(random.nextBoolean()));
            alliance.addTroops(new ElfMelee(random.nextBoolean()));
            System.out.println("!");
            fullLog += "\r\nАльянс - эльфы!\r\n";
        } else {
            alliance.addTroops(new HumanMage(random.nextBoolean()));
            alliance.addTroops(new HumanArcher(random.nextBoolean()));
            alliance.addTroops(new HumanArcher(random.nextBoolean()));
            alliance.addTroops(new HumanArcher(random.nextBoolean()));
            alliance.addTroops(new HumanMelee(random.nextBoolean()));
            alliance.addTroops(new HumanMelee(random.nextBoolean()));
            alliance.addTroops(new HumanMelee(random.nextBoolean()));
            alliance.addTroops(new HumanMelee(random.nextBoolean()));
            fullLog += "\r\nАльянс - люди!\r\n";
        }


        fullLog += "\r\nНачало битвы\r\n";

        System.out.print(fullLog);
        /**
         * цикл ходов каждого отряда. Выход из цикла при getArmy().size() == 0
         */
        for (int i = 0; ; i++) {
            String log = "";
            if (alliance.getArmy().size() == 0) {
                log += "\r\nПОБЕДИЛА ОРДА!\r\n";
                System.out.print(log);
                fullLog += log;
                break;
            }
            if (horde.getArmy().size() == 0) {
                log += "\r\nПОБЕДИЛ АЛЬЯНС!\r\n";
                System.out.print(log);
                fullLog += log;
                break;
            }
            if (random.nextBoolean()) {
                log += "\r\n(Ход " + i + ") " + "АЛЬЯНС НАЧАЛ ХОД!\r\n";
                log += nextTurn(alliance, horde);
                log += "АЛЬЯНС ЗАКОНЧИЛ ХОД!\r\n";
            } else {
                log += "\r\n(Ход " + i + ") " + "ОРДА НАЧАЛА ХОД!\r\n";
                log += nextTurn(horde, alliance);
                log += "ОРДА ЗАКОНЧИЛА ХОД!\r\n";
            }
            fullLog += log;
            System.out.println(log);

        }
        try (FileWriter writer = new FileWriter("log.txt", false)) {
            writer.write(fullLog);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * логика каждого хода. возвращает String лог хода
     */
    public String nextTurn(ArmyList allyArmy, ArmyList enemyArmy) {
        Character character;
        Character enemy;
        Character ally;
        String turnLog = "";
        while (!allyArmy.isAllMoved()) {
            if (enemyArmy.getArmy().size() == 0) return turnLog;

            character = getNextWarrior(allyArmy);

            int enemyPos = enemyArmy.getCharacter();
            enemy = enemyArmy.getArmy().get(enemyPos);

            int allyPos = allyArmy.getCharacter();
            ally = allyArmy.getArmy().get(allyPos);

            if (character instanceof Mage)
                turnLog += (random.nextBoolean()) ? character.move(enemy) : character.move(ally);
            else if (character instanceof Shaman) {
                if (enemyArmy.getPrivilegedTroops().size() != 0 && random.nextBoolean()) {
                    int privilegedEnemyPos = random.nextInt(enemyArmy.getPrivilegedTroops().size());
                    enemy = enemyArmy.getPrivilegedTroops().get(privilegedEnemyPos);
                    turnLog += character.move(enemy);
                } else
                    turnLog += character.move(ally);
            } else turnLog += character.move(enemy);

            character.setMoved(true);
            character.setPrivileged(false);

            if (enemy.isDead()) {
                turnLog += enemy.getCharacterClass() + " БЫЛ УБИТ!\r\n";
                enemyArmy.getArmy().remove(enemyPos);
            }
        }
        allyArmy.pullOffAllDebuffs();
        allyArmy.setAllMembersNonCursed();
        allyArmy.setAllNotMoved();

        return turnLog;
    }

    /**
     * логика выбора воина для хода
     */
    public Character getNextWarrior(ArmyList army) {
        Character character = null;
        int characterPos;
        if (army.getNonMovedPrivilageTroops().size() != 0) {
            characterPos = random.nextInt(army.getNonMovedPrivilageTroops().size());
            character = army.getNonMovedPrivilageTroops().get(characterPos);
        } else if (army.getNonMovedCharacter().size() != 0) {
            characterPos = random.nextInt(army.getNonMovedCharacter().size());
            character = army.getNonMovedCharacter().get(characterPos);
        }
        return character;
    }


}

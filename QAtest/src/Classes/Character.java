package Classes;

import java.util.Random;

/**
 * Created by Mikhail on 17.03.2017.
 */
public abstract class Character {
    protected Random random;
    private double hp = 100;
    private boolean dead;
    private boolean privileged;
    private boolean moved;
    private boolean buffed;
    private boolean cursed;
    private boolean debuffed;
    private String characterClass;

    public Character(boolean privileged) {
        random = new Random();
        this.privileged = privileged;
    }

    public Character() {
    }

    public abstract String move(Character character);

    public double hitRate() {
        if (this.isPrivileged()) {
            if (this.isCursed()) {
                return 1.5 * 0.5;
            } else {
                return 1.5 * 1;
            }
        } else {
            if (this.isCursed()) {
                return 1 * 0.5;
            } else {
                return 1 * 1;
            }
        }

    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean isBuffed() {
        return buffed;
    }

    public void setBuffed(boolean buffed) {
        this.buffed = buffed;
    }

    public boolean isCursed() {
        return cursed;
    }

    public void setCursed(boolean cursed) {
        this.cursed = cursed;
    }

    public boolean isDead() {
        if (hp <= 0) {
            return true;
        }
        return false;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public boolean isPrivileged() {
        return privileged;
    }

    public void setPrivileged(boolean privileged) {
        this.privileged = privileged;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void setDebuffed(boolean debuffed) {
        this.debuffed = debuffed;
    }
}

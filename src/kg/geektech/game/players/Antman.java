package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Antman extends Hero{
    public Antman(int health, int damage, String name) {

        super(health, damage, SuperAbility. CHEL_MURAVEI, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int uvelUmen = RPG_Game.random.nextInt(2)+1;
        int rand = RPG_Game.random.nextInt(10)+2;
        if (uvelUmen == 1){
            setDamage(getDamage()+rand);
            setHealth(getHealth()+rand);
            System.out.println(getName() + " увеличился на " + rand);
        }
        if (uvelUmen ==2){
            setDamage(getDamage()-rand);
            setHealth(getHealth()-rand);
            System.out.println(getName() + " уменьшился на " + rand);

        }
    }
}
package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Warrior extends Hero {
    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int critDamage = RPG_Game.random.nextInt(4)+2;
        this.setDamage(this.getDamage()*critDamage);


        System.out.println("Warrior applies " + getAbility() +"["+critDamage+"]");
    }
}
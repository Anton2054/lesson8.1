package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Berserk extends Hero {
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {

        int blocked = RPG_Game.random.nextInt(30)+1;


        this.setHealth(this.getHealth()+blocked);

        boss.setHealth(boss.getHealth()-blocked);

        System.out.println("Berserk applies " + getAbility()+" " +blocked);
    }
}
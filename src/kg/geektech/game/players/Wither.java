package kg.geektech.game.players;

public class Wither extends Hero{
    public Wither(int health, int damage, String name) {
        super(health, damage, SuperAbility.SAMOPOJERTVOVANIE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() <=0 && heroes[i] != this){
                heroes[i].setHealth(getHealth());
                this.setHealth(0);

                System.out.println(this.getName() + " оживила: "+ heroes[i].getName());
                break;
            }

        }

    }
}

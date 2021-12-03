package kg.geektech.game.general;

import kg.geektech.game.players.*;

import java.util.Random;

public class RPG_Game {
    private static int roundNumber;
    public static Random random = new Random();

    public static void start() {
        Boss boss = new Boss(1500, 100, "VALKYRIE QUEEN");
        Warrior warrior = new Warrior(290, 25, "Garrus");
        Medic doc = new Medic(270, 20, 20, "Booker Dewitt");
        Berserk berserk = new Berserk(300, 26, "Solid Snake");
        Magic magic = new Magic(200, 30, "Tychus Findlay");
        Medic assistant = new Medic(370, 35, 5, "Duke Nukem");
        Wither wither = new Wither(290, 0, "Shooter");
        Avrora avrora = new Avrora(260, 25, "Captain Nick Reyes");
        Antman antman = new Antman(280, 10, "Aiden Pearce");
        Hero[] heroes = {warrior, doc, berserk, magic, assistant, wither, avrora,  antman};

        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }


    private static void round(Boss boss, Hero[] heroes) {
        roundNumber++;
        bossHits(boss, heroes);
        heroesHit(boss, heroes);
        heroesAppliesSuperAbilities(boss, heroes);
        printStatistics(boss, heroes);
        uzpokoisya(boss, heroes);

    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }

    private static void heroesAppliesSuperAbilities(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].applySuperPower(boss, heroes);
        }

    }

    private static void uzpokoisya(Boss boss, Hero[] heroes) {
        heroes[0].setDamage(15);


    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println((roundNumber == 0 ? "BEFORE START" : "\033[40m" + roundNumber + " ROUND")
                + " _____________" + "\033[0m");
        System.out.println("\033[0;31m" + "Boss " + boss.getName() + "\033[0m" +
                " health: " + boss.getHealth() + " [" + boss.getDamage() + "]");
        for (int i = 0; i < heroes.length; i++) {

            System.out.println("\033[0;32m" + heroes[i].getName() + "\033[0m" +
                    " health: " + heroes[i].getHealth()
                    + " [" + heroes[i].getDamage() + "]");
        }
        System.out.println("___________________\n");
    }
}

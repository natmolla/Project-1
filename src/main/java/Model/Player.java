package Model;

public class Player {

    String name;
    String playerClass;
    int armorClass;
    String password;

    public Player(){

    }

    int coin;

    private int damage;
    private int health;
    private boolean dead = false;

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void setDead(boolean dead){
        this.dead = dead;
    }


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isDead() {
        return dead;
    }

    public Player(String name, String playerClass, int armorClass, String password) {
        this.name = name;
        this.playerClass = playerClass;
        this.armorClass = armorClass;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Player Profile\n" +
                "Name: " + name + "\n" +
                "Player Class: " + playerClass + "\n" +
                "Armor Class: " + armorClass
                ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

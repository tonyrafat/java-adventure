public abstract class Character {
    protected String name;
    protected int health;
    protected int attack;

    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }

    public void takeDamage(int dmg) {
        health -= dmg;
    }

    public abstract String talk();
}


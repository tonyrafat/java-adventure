public class Enemy extends NonPlayerCharacter {

    public Enemy(String name, int health, int attack, String dialogue) {
        super(name, health, attack, dialogue);
    }

    public boolean isAlive() {
        return health > 0;
    }
}

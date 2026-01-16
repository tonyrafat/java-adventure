public class NonPlayerCharacter extends Character {
    protected String dialogue;

    public NonPlayerCharacter(String name, int health, int attack, String dialogue) {
        super(name, health, attack);
        this.dialogue = dialogue;
    }

    @Override
    public String talk() {
        return dialogue;
    }
}


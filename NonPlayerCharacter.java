public class NonPlayerCharacter extends Character {
    private String dialogue;

    public NonPlayerCharacter(String name, int health, String dialogue) {
        super(name, health);
        this.dialogue = dialogue;
    }

    @Override
    public String talk() {
        return dialogue;
    }
}


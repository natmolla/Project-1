package Model;

public class LPlacement {

    String name;
    int killScore;

    public LPlacement(String name, int killScore) {
        this.name = name;
        this.killScore = killScore;
    }

    @Override
    public String toString() {
        return "Name:" + name + "  " +
                "Kills:" + killScore +'\n';
    }
}

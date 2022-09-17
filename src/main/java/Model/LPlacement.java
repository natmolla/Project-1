package Model;

public class LPlacement {

    public LPlacement(){

    }


    String name;
    int killScore;

    public LPlacement(String name, int killScore) {
        this.name = name;
        this.killScore = killScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKillScore() {
        return killScore;
    }

    public void setKillScore(int killScore) {
        this.killScore = killScore;
    }

    @Override
    public String toString() {
        return "Name:" + name + "  " +
                "Kills:" + killScore +'\n';
    }
}

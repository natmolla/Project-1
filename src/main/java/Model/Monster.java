package Model;

public class Monster {

    String name;
    String type;
    String size;
    String description;
    int armorClass;


    public Monster(String name, String type, String size, String description,
                   int armorClass){
        this.name = name;
        this.type = type;
        this.size = size;
        this.description = description;
        this.armorClass = armorClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    @Override
    public String toString() {
        return "Monster Profile\n" +
            "Name: " + name +
            ", Type: " + type + "\n" +
            "Size: " + size  + "\n" +
            "Description: " + description + "\n" +
            "Armor Class: " + armorClass;
        }
    }



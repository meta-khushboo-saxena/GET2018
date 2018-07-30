package mammalPackage;

import interfacesPackage.Animal;

/**
 *Class for Mammals which implements Animal Interface
 */
public class Mammals implements Animal {

    protected String name;
    protected int weight;
    protected int age;
    protected int animalCageId;
    protected final String category = "MAMMAL";

    public int getAnimalCageId() {
        return animalCageId;
    }

    public void setAnimalCageId(int animalCageId) {
        this.animalCageId = animalCageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return category;
    }

    public String getInfo() {
        return "THIS IS MAMMAL PARENT CLASS";
    }
}

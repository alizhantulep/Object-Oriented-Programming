package Problem5;

import java.util.Objects;

public abstract class Person {
    protected String name;
    protected int age;
    protected Animal pet;
    protected Animal tempPet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.pet = null;
        this.tempPet = null;
    }

    public boolean hasPet() { return pet != null; }

    public void assignPet(Animal pet) {
        if (this instanceof PHDStudent && pet instanceof Dog) return;
        if (this.pet instanceof Dog && pet instanceof Cat) {
        	System.out.println("incorrect");
        	return;
        }
        if (this.pet instanceof Cat && pet instanceof Dog) {
        	System.out.println("Incorrect");
        	return;
        }
        this.pet = pet;
    }

    public void removePet() { this.pet = null; }

    public abstract String getOccupation();

    public void leavePetWith(Person caretaker) {
        if (pet == null) return;
        if (caretaker instanceof PHDStudent && pet instanceof Dog) return;
        caretaker.tempPet = this.pet;
        this.pet = null;
    }

    public void retrievePetFrom(Person caretaker) {
        if (caretaker.tempPet == null) return;
        this.pet = caretaker.tempPet;
        caretaker.tempPet = null;
    }

    @Override
    public String toString() {
        String petInfo = (pet != null) ? pet.toString() : "No pet";
        String tempInfo = (tempPet != null) ? "(temporarily caring for " + tempPet.toString() + ")" : "";
        return name + " (" + age + " y.o., " + getOccupation() + ") owns: " + petInfo + " " + tempInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return name.equals(p.name) && age == p.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

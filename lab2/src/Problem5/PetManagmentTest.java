package Problem5;

public class PetManagmentTest {
    public static void main(String[] args) {
        Person john = new Employee("John", 30, "Engineer");
        Person alice = new PHDStudent("Alice", 26, "Computer Science", "AI");
        Animal murka = new Cat("Murka", 5);
        Animal rex = new Dog("Rex", 3);

        john.assignPet(rex);
        alice.assignPet(murka);

        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(john);
        registry.addPerson(alice);

        System.out.println("Initial Registry:");
        System.out.println(registry);
        john.leavePetWith(alice);

        System.out.println("Registry after John leaves Rex with Alice:");
        System.out.println(registry);

        john.retrievePetFrom(alice);

        System.out.println("Registry after John retrieves Rex:");
        System.out.println(registry);
        
        john.assignPet(murka);
    }
}
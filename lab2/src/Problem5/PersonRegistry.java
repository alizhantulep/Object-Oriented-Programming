package Problem5;

import java.util.ArrayList;
import java.util.List;

public class PersonRegistry {
    private List<Person> people;

    public PersonRegistry() {
        people = new ArrayList<>();
    }

    public void addPerson(Person p) { people.add(p); }
    public void removePerson(Person p) { people.remove(p); }

    public List<Person> getPeopleWithPets() {
        List<Person> list = new ArrayList<>();
        for (Person p : people) if (p.hasPet()) list.add(p);
        return list;
    }

    public List<Person> getPeopleWithoutPets() {
        List<Person> list = new ArrayList<>();
        for (Person p : people) if (!p.hasPet()) list.add(p);
        return list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Person p : people) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
package Problem5;

public class PHDStudent extends Person {
    private String field;
    private String researchTopic;

    public PHDStudent(String name, int age, String field, String researchTopic) {
        super(name, age);
        this.field = field;
        this.researchTopic = researchTopic;
    }

    public String getOccupation() { return "PhD Student, " + field + " (" + researchTopic + ")"; }
}
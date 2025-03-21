//Textbook class that extends Book class and adds grade level attribute

public class Textbook extends Book {
    private int gradeLevel;

    public Textbook(String name, int pages, int gradeLevel) throws IllegalArgumentException {
        super(name, pages);
        if (gradeLevel < 1 || gradeLevel > 12) {
            throw new IllegalArgumentException("Grade level must be between 1 and 12.");
        }
        this.gradeLevel = gradeLevel;
    }

    @Override
    public void displayInfo() {
        System.out.println("Textbook Information:");
        System.out.println("Name: " + name);
        System.out.println("Pages: " + pages);
        System.out.println("Grade Level: " + gradeLevel);
    }
}

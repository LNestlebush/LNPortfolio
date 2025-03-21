//Novel class that extends Book

public class Novel extends Book {
    public Novel(String name, int pages) {
        super(name, pages);
    }

    @Override
    public void displayInfo() {
        System.out.println("Novel Information:");
        System.out.println("Name: " + name);
        System.out.println("Pages: " + pages);
    }
}
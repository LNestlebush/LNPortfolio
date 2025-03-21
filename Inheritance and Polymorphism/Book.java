//Book class that is extended by Textbook and Novel classes
public abstract class Book {
    protected String name;
    protected int pages;

    public Book(String name, int pages) {
        this.name = name;
        this.pages = pages;
    }

    public abstract void displayInfo();
}
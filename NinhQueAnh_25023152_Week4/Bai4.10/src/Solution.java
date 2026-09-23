import java.util.*;

abstract class MediaItem {
    protected String id;
    protected String title;

    public MediaItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public abstract String getInfo();
}

class Book extends MediaItem {
    private String author;
    private int pages;

    public Book(String id, String title, String author, int pages) {
        super(id, title);
        this.author = author;
        this.pages = pages;
    }

    @Override
    public String getInfo() {
        return title + " - " + author + " - " + pages;
    }
}

class DVD extends MediaItem {
    private String director;
    private int duration;

    public DVD(String id, String title, String director, int duration) {
        super(id, title);
        this.director = director;
        this.duration = duration;
    }

    @Override
    public String getInfo() {
        return title + " - " + director + " - " + duration;
    }
}

class LibrarySection<T extends MediaItem> {
    private List<T> items;

    public LibrarySection() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public boolean removeItem(String id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }

    public void displayItems() {
        for (T item : items) {
            System.out.println(item.getInfo());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LibrarySection<Book> bookSection = new LibrarySection<>();
        LibrarySection<DVD> dvdSection = new LibrarySection<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String id = sc.next();
            String title = sc.next();

            if (type.equals("B")) {
                String author = sc.next();
                int pages = sc.nextInt();
                bookSection.addItem(new Book(id, title, author, pages));
            } else if (type.equals("D")) {
                String director = sc.next();
                int duration = sc.nextInt();
                dvdSection.addItem(new DVD(id, title, director, duration));
            }
        }

        System.out.println("Book Section:");
        bookSection.displayItems();

        System.out.println("DVD Section:");
        dvdSection.displayItems();

        sc.close();
    }
}
import java.util.ArrayList;

public class ArrayListLibrary implements LibraryManager {
    private ArrayList<Book> books;

    public ArrayListLibrary() {
        books = new ArrayList<>();
    }

    @Override
    public boolean addBook(Book book) {
        if (findBookById(book.getId()) != null) {
            return false;
        }
        books.add(book);
        return true;
    }

    @Override
    public Book findBookById(String id) {
        for (Book book : books) {
            if (book.getId().equalsIgnoreCase(id)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public boolean removeBookById(String id) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId().equalsIgnoreCase(id)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sach sach rong.");
            return;
        }

        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public String getStructureName() {
        return "ArrayList";
    }

    @Override
    public int size() {
        return books.size();
    }
}
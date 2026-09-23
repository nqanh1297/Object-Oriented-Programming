import java.util.HashMap;
import java.util.Map;

public class HashMapLibrary implements LibraryManager {
    private HashMap<String, Book> books;

    public HashMapLibrary() {
        books = new HashMap<>();
    }

    @Override
    public boolean addBook(Book book) {
        if (books.containsKey(book.getId())) {
            return false;
        }
        books.put(book.getId(), book);
        return true;
    }

    @Override
    public Book findBookById(String id) {
        return books.get(id);
    }

    @Override
    public boolean removeBookById(String id) {
        return books.remove(id) != null;
    }

    @Override
    public void printAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sach sach rong.");
            return;
        }

        for (Map.Entry<String, Book> entry : books.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    @Override
    public String getStructureName() {
        return "HashMap";
    }

    @Override
    public int size() {
        return books.size();
    }
}
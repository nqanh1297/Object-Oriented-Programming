import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> sampleBooks = createSampleBooks();

        LibraryManager arrayListLibrary = new ArrayListLibrary();
        LibraryManager hashMapLibrary = new HashMapLibrary();
        LibraryManager treeMapLibrary = new TreeMapLibrary();

        loadData(arrayListLibrary, sampleBooks);
        loadData(hashMapLibrary, sampleBooks);
        loadData(treeMapLibrary, sampleBooks);

        testLibrary(arrayListLibrary);
        testLibrary(hashMapLibrary);
        testLibrary(treeMapLibrary);

        printAnalysis();
    }

    private static List<Book> createSampleBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("B001", "Lap trinh Java", "Nguyen Van A", 2020));
        books.add(new Book("B002", "Cau truc du lieu", "Tran Thi B", 2019));
        books.add(new Book("B003", "Giai thuat can ban", "Le Van C", 2021));
        books.add(new Book("B004", "Co so du lieu", "Pham Thi D", 2018));
        books.add(new Book("B005", "Mang may tinh", "Hoang Van E", 2022));
        books.add(new Book("B006", "He dieu hanh", "Do Thi F", 2023));

        return books;
    }

    private static void loadData(LibraryManager manager, List<Book> books) {
        for (Book book : books) {
            manager.addBook(book);
        }
    }

    private static void testLibrary(LibraryManager manager) {
        System.out.println("\n==============================");
        System.out.println("Cau truc luu tru: " + manager.getStructureName());
        System.out.println("So luong sach ban dau: " + manager.size());

        System.out.println("\n1. Tim sach theo id B003");
        Book foundBook = manager.findBookById("B003");
        if (foundBook != null) {
            System.out.println("Tim thay: " + foundBook);
        } else {
            System.out.println("Khong tim thay sach co id B003");
        }

        System.out.println("\n2. Xoa sach theo id B002");
        boolean removed = manager.removeBookById("B002");
        if (removed) {
            System.out.println("Xoa thanh cong sach B002");
        } else {
            System.out.println("Khong tim thay sach B002 de xoa");
        }

        System.out.println("\n3. Danh sach sach sau khi xoa");
        manager.printAllBooks();

        long time = benchmarkSearch(manager, "B005", 200000);
        System.out.println("\n4. Thoi gian tim kiem 200000 lan id B005: " + time + " ns");
    }

    private static long benchmarkSearch(LibraryManager manager, String id, int repetitions) {
        long start = System.nanoTime();

        for (int i = 0; i < repetitions; i++) {
            manager.findBookById(id);
        }

        long end = System.nanoTime();
        return end - start;
    }

    private static void printAnalysis() {
        System.out.println("\n==============================");
        System.out.println("SO SANH VA PHAN TICH");
        System.out.println("1. Do phuc tap tim kiem:");
        System.out.println("- ArrayList: O(n)");
        System.out.println("- HashMap: O(1) trung binh");
        System.out.println("- TreeMap: O(log n)");

        System.out.println("\n2. Cau truc du lieu phu hop:");
        System.out.println("- So luong sach nho: ArrayList de lam, de quan ly.");
        System.out.println("- So luong sach rat lon: HashMap phu hop nhat vi tim kiem nhanh.");
        System.out.println("- Can du lieu sap xep theo id: TreeMap phu hop nhat.");

        System.out.println("\n3. Vi sao HashMap tim nhanh hon ArrayList?");
        System.out.println("Vì HashMap tra cuu theo key bang co che bam,");
        System.out.println("con ArrayList phai duyet tung phan tu de tim id.");
    }
}
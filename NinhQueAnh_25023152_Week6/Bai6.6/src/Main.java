public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("root");
        Folder docs = new Folder("docs");

        FileItem file1 = new FileItem("a.txt", 12);
        FileItem file2 = new FileItem("b.txt", 8);
        FileItem readme = new FileItem("readme.md", 4);

        Shortcut shortcut = new Shortcut(
                "a-shortcut",
                file1,
                "/root/docs/a.txt"
        );

        docs.add(file1);
        docs.add(file2);
        docs.add(shortcut);

        root.add(docs);
        root.add(readme);

        root.print("");
    }
}
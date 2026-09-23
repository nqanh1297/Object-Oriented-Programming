import java.util.ArrayList;
import java.util.List;

class Folder implements FileSystemItem {
    private String name;
    private List<FileSystemItem> children;

    public Folder(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Folder: " + name);
        for (FileSystemItem item : children) {
            item.print(indent + "  ");
        }
    }
}
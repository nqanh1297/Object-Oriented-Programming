class FileItem implements FileSystemItem {
    private String name;
    private int size;

    public FileItem(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "File: " + name + " (" + size + "KB)");
    }
}
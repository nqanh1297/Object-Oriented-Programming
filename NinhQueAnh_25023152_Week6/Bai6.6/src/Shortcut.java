class Shortcut implements FileSystemItem {
    private String name;
    private FileSystemItem target;
    private String targetPath;

    public Shortcut(String name, FileSystemItem target, String targetPath) {
        this.name = name;
        this.target = target;
        this.targetPath = targetPath;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Shortcut: " + name + " -> " + targetPath);
    }
}
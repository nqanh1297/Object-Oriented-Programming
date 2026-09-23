public abstract class FileExport {
    public void exportFile(){
        Export e = createExport();
        e.export();
    }
    public abstract Export createExport();
}

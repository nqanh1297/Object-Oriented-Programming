public class ExcelFile extends FileExport {
    @Override
    public Export createExport() {
        return new ExcelExport();
    }
}

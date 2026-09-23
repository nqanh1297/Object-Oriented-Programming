public class Main {
    public static void main(String[] args) {
        System.out.println("======1.Singleton======");
        Logger logger1 = Logger.getLogger();
        Logger logger2 = Logger.getLogger();
        System.out.println(logger1.hashCode());
        System.out.println(logger2.hashCode());
        System.out.println("======2.FactoryMethod======");
        FileExport fe1 = new PdfFile();
        fe1.exportFile();
        FileExport fe2 = new ExcelFile();
        fe2.exportFile();
        System.out.println("======3.Adapter======");
        Player player = new PlayerAdapter(new OldPlayer());
        player.play("1234");
        System.out.println("======4.Prototype======");
        Student s1 = new Student("Nhân","ST01");
        Student s2 = s1.clone();
        System.out.println(s1.toString()+" "+s1.hashCode());
        System.out.println(s2.toString()+" "+s2.hashCode());
    }
}

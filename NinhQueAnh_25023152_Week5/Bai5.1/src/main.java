public class main {
    public static void useString() {
        String s="";
        long start = System.currentTimeMillis();
        for (int i=0;i<100000;i++){
            s+="Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println("useString:");
        System.out.println("Do dai chuoi:"+ s.length());
        System.out.println("Thoi gian chay:"+ (end-start) +"ms");
        System.out.println();
    }

    public static void useStringBuffer() {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i=0;i<100000;i++) {
            sb.append("Hello");
        }
        long end=System.currentTimeMillis();
        System.out.println("useStringBuffer:");
        System.out.println("Do dai chuoi:"+ sb.length());
        System.out.println("Thoi gian chay:"+ (end-start) +"ms");
        System.out.println();
    }

    public static void contentAnalysis(String text) {
        System.out.println("Noi dung ban dau:");
        System.out.println(text);
        System.out.println();

        int count=0;
        for (int i=0;i<text.length();i++) {
            char c = text.charAt(i);
            if ( c == '!' || c == '?' || c == '.') {
                count++;
            }
        }
        String replacedText = text.replace("Java","Python");

        System.out.println("So cau trong van ban:" +count);
        System.out.println();
        System.out.println("Noi dung sau khi duoc thay the:");
        System.out.println(replacedText);
    }

    public static void main(String[] args) {
        useString();
        useStringBuffer();
        String text= "Java la ngon ngu lap trinh pho bien! Ban co thich Java khong?";
        contentAnalysis(text);
    }
}

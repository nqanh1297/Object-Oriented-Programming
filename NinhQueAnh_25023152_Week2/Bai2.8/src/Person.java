public class Person {
    private String name;
    private Person me;

    public Person(String name) {
        this.name = name;
        this.me = null;
    }

    public void setMe(Person other) {
        this.me = other;
    }

    public Person getMe() {
        return me;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person p = new Person("Nguyen Van A");
        p.setMe(p);

        System.out.println(p.getMe().getName());

        p = null;
    }
}
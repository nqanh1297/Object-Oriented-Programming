class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Gâu gâu!");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meo meo!");
    }
}

public class Solution {
    public static void main(String[] args) {
        Animal a = new Dog();

        if (a instanceof Cat) {
            Cat c = (Cat) a;
            c.makeSound();
        } else {
            System.out.println("Đây không phải là Mèo!");
        }
    }
}

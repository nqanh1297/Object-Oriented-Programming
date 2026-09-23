class Animal {
     public void makeSound() {
         System.out.println("Animal Sound");
     }
}
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof woof");
    }
}
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meows meows");
    }
}
class Duck extends Animal {
}
public class Solution {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[4];
        zoo[0]= new Dog();
        zoo[1]= new Cat();
        zoo[2]= new Duck();
        zoo[3]= new Dog();

        for(int i=0; i< zoo.length;i++) {
            zoo[i].makeSound();
        }
    }
}

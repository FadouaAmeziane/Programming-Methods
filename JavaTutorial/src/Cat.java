/**
 * Created by bogdanfloris on 06/02/2017.
 */
public class Cat extends Animal {

    public Cat() {

    }

    public String makeSound(){
        return "Meow!";
    }

    public static void main(String[] args) {

        Animal fido = new Dog();
        Animal fluffy = new Cat();

        Animal[] animals = new Animal[10];
        animals[0] = fido;
        animals[1] = fluffy;

        System.out.println("Fido says " + animals[0].makeSound());
        System.out.println("Fluffy says " + animals[1].makeSound());

        speakAnimal(fluffy);
    }
}

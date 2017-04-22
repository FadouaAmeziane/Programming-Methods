/**
 * Created by bogdanfloris on 06/02/2017.
 */

import java.util.Scanner;
import java.util.*;

public class Animal {

    public static final double FAVNUMBER = 1.6102;

    private String name;
    private int weight;
    private boolean hasOwner = false;
    private byte age;
    private long uniqueID;
    private char favoriteChar;
    private double speed;
    private float height;

    protected static int numberOfAnimals = 0;

    static Scanner scanner = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
        System.out.println("Unique ID set to: " + this.uniqueID);
    }
    public void setUniqueID(){
        long minNumber = 1;
        long maxNumber = 1000000;

        this.uniqueID = minNumber + (long) (Math.random() * ((maxNumber - minNumber) + 1));
        String stringNumber = Long.toString(maxNumber);
        int numberString = Integer.parseInt(stringNumber);
    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }
    public void setFavoriteChar() {
        int randomNumber =  (int) (Math.random() * 126) + 1;
        this.favoriteChar = (char) randomNumber;

        if (randomNumber == 32){
            System.out.println("Favorite character set to Space");
        } else if (randomNumber == 10){
            System.out.println("Favorite character set to Newline");
        } else {
            System.out.println("Favorite character set to: " + this.favoriteChar);
        }

        if ((randomNumber > 97) && (randomNumber < 122)){
            System.out.println("Favorite character is a lowercase letter");
        }
        if (((randomNumber > 97) && (randomNumber < 122)) || ((randomNumber > 64) && (randomNumber < 91))){
            System.out.println("Favorite character is a letter");
        }

        int whichIsBigger = (50 > randomNumber) ? 50 : randomNumber;

        switch (randomNumber){

            case 8:
                System.out.println("Favorite character set to backspace");
                break;
            case 9:
                System.out.println("Favorite character set to: Horizontal Tab");
                break;
            case 10 :
            case 11 :
            case 12 :
                System.out.println("Favorite character set to: Something else weird");
                break;
            default :
                System.out.println("Favorite character set to: " + this.favoriteChar);
                break;

        }
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Animal() {
        numberOfAnimals++;

        int sumOfNumbers = 2 + 2;
        System.out.println("2 + 2 = " + sumOfNumbers);

        int diffOfNumbers = 2 - 2;
        System.out.println("2 - 2 = " + diffOfNumbers);

        int multOfNumbers = 2 * 2;
        System.out.println("2 * 2 = " + multOfNumbers);

        System.out.print("Enter the name: \n");
        if(scanner.hasNextLine()){
            this.setName(scanner.nextLine());
        }

        this.setFavoriteChar();
        this.setUniqueID();

    }

    protected static void countTo(int startingNumber){

        for(int i = startingNumber; i <= 100; i++){

            if (i == 90) continue;

            System.out.println(i);
        }
    }

    protected static String printNumbers(int maxNumbers){

        int i = 1;
        while(i < maxNumbers/2){

            System.out.println(i);
            i++;

            if(i == maxNumbers/2) break;
        }

        Animal.countTo(maxNumbers/2);

        return "End of printNumbers function";
    }

    protected static void guessMyNumber(){

        int number;

        do{
            System.out.println("Guess my number: ");
            while(!scanner.hasNextInt()){

                String numberEntered = scanner.next();
                System.out.printf("%s is not an int", numberEntered);
            }

            number = scanner.nextInt();
        } while(number != 50);

        System.out.println("Number guessed");
    }

    public String makeSound(){
        return "Grrr!";
    }

    public static void speakAnimal(Animal randAnimal){

        System.out.println("Animal says " + randAnimal.makeSound());
    }

    public static void main(String[] args) {

        Animal theDog = new Animal();

        System.out.println("The animal is named " + theDog.getName());
        System.out.println(Animal.printNumbers(100));

        Animal.countTo(100);
        Animal.guessMyNumber();

    }
}

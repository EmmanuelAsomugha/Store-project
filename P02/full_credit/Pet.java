import java.util.Scanner;
public class Pet
{
    private String name;
    private double age;
    private Type type;

    public Pet(String name, double age, Type type)
    {
        this.name = name;
        this.age = age;
        this.type = type;
    }

    @Override
    public String toString(){
         return this.name + " is a " + this.type + " age " + this.age;
    }
}

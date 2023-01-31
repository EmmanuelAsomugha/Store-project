import java.util.Scanner;
public class MyPets
{
    public static void main(String[] args){
        Pet[] animals = new Pet[4];
        Pet Pet1 = new Pet("Mike", 6, Type.DOG);
        animals[0]= Pet1;
        Pet Pet2 = new Pet("John", 10, Type.HORSE);
        animals[1]= Pet2;
        Pet Pet3 = new Pet("Leo", 4, Type.LION);
        animals[2]= Pet3;
        Pet Pet4 = new Pet("Corry", 12, Type.COW);
        animals[3]= Pet4;

        for(int i=0;i<4;i++){
            System.out.println(animals[i].toString());
        }
    }
}

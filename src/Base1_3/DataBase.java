package Base1_3;

import java.util.Scanner;

class Person{
    String lastName, name, gender;
    float height;
}

public class DataBase {
    public static void main(String[] args) {

        // Entering information about a person
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of people => ");
        int num =sc.nextInt();
        sc.nextLine(); //clearing the buffer after entering a number

        Person[]person=new Person[num];//received a reference to the person array

        System.out.println("Enter information about each person:");
        for (int i = 0; i < person.length; i++){
            person[i] = new Person(); //a reference to the i-th element is obtained

            //Assigning values to fields
            System.out.print("Enter the last name of person "+(i+1)+ " => ");
            person[i].lastName = sc.nextLine();
            System.out.print("Enter name => ");
            person[i].name=sc.nextLine();
            System.out.print("Enter gender => ");
            person[i].gender=sc.nextLine();
            System.out.print("Enter height => ");
            person[i].height=sc.nextFloat();
            sc.nextLine();
        }

        // Display information about persons
        System.out.println("\nDatabase of people:\nLast name\tName\tGender\tHeight");
        for (Person p: person) {
            System.out.print(p.lastName+ "\t"+p.name + "\t"+p.gender + "\t" +p.height + "\n");
        }

        //Average height of women and men
        int countMan=0, countWoman=0;
        float aveMan=0, aveWoman=0;
        for(Person p: person) {
            if (p.gender.equals("man")) {
                aveMan += p.height;
                countMan++;
            }
            else if(p.gender.equals("woman")){
                aveWoman += p.height;
                countWoman++;
            }
        }
        aveMan/=countMan;
        aveWoman/=countWoman;
        System.out.println("Average height of women and men:");
    }
}

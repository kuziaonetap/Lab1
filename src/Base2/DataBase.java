package Base2;

import java.util.Scanner;

class Person{
    String lastName, name, gender;
    float height;
    int childNum;
    Child[]child=null;
}

class Child{
    String childName;
    int childAge;
}

public class DataBase {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.println("Enter the number of people => ");
        int num = sc.nextInt();
        sc.nextLine(); //clearing the buffer after entering a number

        Person[] person = new Person[num];//received a reference to the person array

        System.out.println("Enter information about each person:");
        for (int i = 0; i < person.length; i++) {
            person[i] = new Person(); //a reference to the i-th element is obtained

            //Assigning values to fields
            System.out.print("Enter the last name of person " + (i + 1) + " => ");
            person[i].lastName = sc.nextLine();
            System.out.print("Enter name => ");
            person[i].name = sc.nextLine();
            System.out.print("Enter gender => ");
            person[i].gender = sc.nextLine();
            System.out.print("Enter height => ");
            person[i].height = sc.nextFloat();
            System.out.print("Enter number of children => ");
            person[i].childNum = sc.nextInt();
            sc.nextLine();

            if(person[i].childNum!= 0){
                person[i].child = new Child[person[i].childNum];
                System.out.println("Children =>");
                for (int j = 0; j < person[i].child.length; j++){
                    person[i].child[j] = new Child();
                    System.out.print("Enter the name of child " + (j + 1) + " => ");
                    person[i].child[j].childName = sc.nextLine();
                    System.out.print("Enter the child's age => ");
                    person[i].child[j].childAge = sc.nextInt();
                    sc.nextLine();
                }
            }
        }
        // Display information about employees
        System.out.println("\nDatabase of people:\nLast name\tName\tGender\tHeight");
        for (Person p: person) {
            System.out.print(p.lastName+ "\t"+p.name + "\t"+p.gender + "\t" +p.height + "\n");

            System.out.println("\nChildren: ");
            for(Child ch: p.child)
                System.out.println("\t\t"+ ch.childName+ "\t\t"+ ch.childAge);
        }
    }
}

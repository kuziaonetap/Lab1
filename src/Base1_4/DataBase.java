package Base1_4;//Варіант 7

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
        sc.nextLine();
        Person[] person=SetPersonArr(num);

        // Display information about persons
        System.out.println("\nDatabase of people:\nLast name\tName\tGender\tHeight");
        ShowArray(person);

        //Average height of women and men
        AverageHeight(person);

        //Sort the list by height
        SortHeight(person);

        // Display information about sorted persons
        System.out.println("\nSorted database of people:\nLast name\tName\tGender\tHeight");
        ShowArray(person);

        //Determine the tallest man
        TallestMan(person);

        //Search by last name, correction of one of the fields
        SearchByLastName(person);
    }

    // Entering information about a person
    public static Person [] SetPersonArr (int k)
    {
        Scanner sc=new Scanner(System.in);
        Person[]person=new Person[k];//received a reference to the person array

        System.out.println("Enter information about each person:");
        for (int i = 0; i < person.length; i++){
            person[i] = new Person(); //a reference to the i-th element is obtained

            //Assigning values to fields
            System.out.print("Enter Last name of person "+(i+1)+ " => ");
            person[i].lastName = sc.nextLine();
            System.out.print("Enter Name => ");
            person[i].name=sc.nextLine();
            System.out.print("Enter Gender => ");
            person[i].gender=sc.nextLine();
            System.out.print("Enter Height => ");
            person[i].height=sc.nextFloat();
            sc.nextLine();
        }
        return person;
    }

    // Display information about persons
    public static void ShowArray(Person[] person){
        for (Person p: person) {
            ShowPerson(p);
        }
    }

    public static void ShowPerson(Person p){
        System.out.print(p.lastName+ "\t"+p.name + "\t"+p.gender + "\t" +p.height + "\n");
    }

    //Average height of women and men
    public static void AverageHeight(Person[] person){
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
        System.out.println("\nAverage height of women is "+aveWoman+"\nAverage height of men is "+aveMan);
    }

    //Sort the list by height
    public static void SortHeight(Person[] person){
        Person tempPerson;
        for(int i=0; i<person.length-1; i++) {
            if(person[i].height>person[i+1].height){
                tempPerson=person[i+1];
                person[i+1]=person[i];
                person[i]=tempPerson;
                i=0;
            }
        }
    }

    //Determine the tallest man
    public static void TallestMan(Person[] person){
        for(int i=person.length-1; i>0; i--){
            if(person[i].gender.equals("man")){
                System.out.println("\nThe tallest man is: ");
                ShowPerson(person[i]);
                break;
            }
        }
    }

    //Search by last name
    public static void SearchByLastName(Person[] person){
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter the last name of the person you are looking for => ");
        String lastNameToSearch =sc.nextLine();
        boolean isEditing = true;
        for (Person p : person) {
            if (p.lastName.equalsIgnoreCase(lastNameToSearch)) {
                System.out.println(p.lastName + "\t" + p.name + "\t" + p.gender + "\t" + p.height + "\n");
                //Correction of one of the fields
                do {
                    System.out.println("Edit information about a person? \n0-No\n1-Yes");
                    byte answerEdit = sc.nextByte();
                    sc.nextLine();
                    if (answerEdit == 1) {
                        System.out.println("Choose a field to edit. \n0-Last Name\n1-Name\n2-Gender\n3-Height");
                        byte answerField = sc.nextByte();
                        sc.nextLine();
                        switch (answerField) {
                            case 0 -> {
                                System.out.print("Enter Last name of person => ");
                                p.lastName = sc.nextLine();
                            }
                            case 1 -> {
                                System.out.print("Enter Name => ");
                                p.name = sc.nextLine();
                            }
                            case 2 -> {
                                System.out.print("Enter Gender => ");
                                p.gender = sc.nextLine();
                            }
                            case 3 -> {
                                System.out.print("Enter Height => ");
                                p.height = sc.nextFloat();
                            }
                            default -> System.out.print("Wrong answer");
                        }
                    } else if (answerEdit == 0) isEditing = false;
                } while (isEditing);
                System.out.println("Edited person");
                ShowPerson(p);
            }
            else System.out.println("This person does not exist");
        }
    }
}

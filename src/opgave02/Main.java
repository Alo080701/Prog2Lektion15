package opgave02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        PeopleArray peopleArray = new PeopleArray();
        addPeople(peopleArray);
        System.out.println();

        //Den første person der hedder Klaus
        System.out.println("Den første person der hedder Klaus: " + peopleArray.findFirst(p -> p.getName().equals("Klaus")));
        //Den første person der har et navn med længden 4
        System.out.println("Den første person der har et navn med længden 4: " + peopleArray.findFirst(p -> p.getName().length() == 4));
        //Indsæt kode herunder der kalder metoderne findFirst og findAll som beskrevet i opgave 1
        System.out.println("Den første person med alder 44: " + peopleArray.findFirst(p -> p.getAge() == 44));
        //Opg 2
        System.out.println("Den første person der starter med S: " + peopleArray.findFirst(p -> p.getName().charAt(0) == 'S'));
        //Opg 3
        System.out.println("Den første person i listen af personer, hvis navn indeholder mere end et ’i’: " + peopleArray.findFirst(p -> {
            int count = 0;
            if (p.getName().contains("i")) {
                for (int i = 0; i < p.getName().length(); i++) {
                    if (p.getName().charAt(i) == 'i') {
                        count++;
                        if (count == 2) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }));
        //Opg. 4
        System.out.println("Den første person i listen af personer, hvis alder er lig længden af navnet: " + peopleArray.findFirst(p -> p.getName().length() == p.getAge()));

        //Del 2
        List<Person> people = peopleArray.findAll(p -> p.getAge() > 30);
        //Opg. 1
        System.out.println("Alle personer, hvis navn indeholder et ’i’" + peopleArray.findAll(p -> p.getName().contains("i")));
        //Opg 2
        System.out.println("Alle personer, hvis navn starter med ’S’" + peopleArray.findAll(p -> p.getName().startsWith("S")));
        //Opg 3
        System.out.println("Alle personer, hvis navn har længden 5" + peopleArray.findAll(p -> p.getName().length() == 5));
        //Opg 4
        System.out.println("Alle personer, hvis alder er mindst 6 og mindre end 40" + peopleArray.findAll(p -> p.getAge() > 6 || p.getAge() < 40));


    }

    private static void addPeople(PeopleArray peopleArray) {
        peopleArray.addPerson(new Person("Bent", 25));
        peopleArray.addPerson(new Person("Susan", 34));
        peopleArray.addPerson(new Person("Mikael", 60));
        peopleArray.addPerson(new Person("Klaus", 44));
        peopleArray.addPerson(new Person("Birgitte", 17));
        peopleArray.addPerson(new Person("Liselotte", 9));
    }
}

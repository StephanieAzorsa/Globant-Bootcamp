package guide10_Collections.examples;

import guide10_Collections.examples.entidades.Persona;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleStream03 {
    public static void main(String[] args) {
        List<Persona> personas = Arrays.asList(
                new Persona("Juan", 30),
                new Persona("Maria", 25),
                new Persona("Pedro", 40),
                new Persona("Alex", 40)
        );

        System.out.println("List of objects 'Person': " + personas);

        List<String> names = personas.stream()
                .map(Persona::getNombre)
                .toList();

        System.out.println("List of only names: " + names);

        int sumAgesOver25 = personas.stream()
                .filter(persona -> persona.getEdad() > 25)
                .mapToInt(Persona::getEdad)
                .sum();

        System.out.println("\nSum of ages over 25: " + sumAgesOver25);

        Optional<Persona> youngerPerson = personas.stream()
                .min(Comparator.comparingInt(Persona::getEdad));

        System.out.println("\nYounger person: " + youngerPerson.get());

        Map<Integer, List<Persona>> groupByAge = personas.stream()
                .collect(Collectors.groupingBy(Persona::getEdad));

        System.out.println("\nGrouping by age: " + groupByAge);

        boolean olderThan18 = personas.stream()
                .allMatch(persona -> persona.getEdad() > 18);

        System.out.println("\nAll older than 18: " + olderThan18);
    }
}

package lesson10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RUN {
    public static void main(String [] args){

        List<Animal> animals = getAnimals();
        // Filter
        List<Animal> predators = animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.PREDATOR)).toList();
        predators.forEach(System.out::println);

        // Sorted
        List<Animal> sortList = animals.stream()
                .sorted(Comparator.comparing(Animal::getAge)).toList();
        sortList.forEach(System.out::println);

        // All match
        boolean allMatch = animals.stream()
                .allMatch(animal -> animal.getAge() > 10);
        System.out.println(allMatch);

        // Any match
        boolean anyMatch = animals.stream()
                .anyMatch(animal -> animal.getClassification().equals(Classification.PREDATOR));
        System.out.println(anyMatch);

        // None match
        boolean noneMatch = animals.stream()
                .noneMatch(animal -> animal.getName().equals("Человек"));
        System.out.println(noneMatch);

        // Max
        animals.stream()
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);

        // Min

        // Group (немного сложная вещица, суть в группировке по видам)
        Map<Classification, List<Animal>> classificationListMap = animals.stream()
                .collect(Collectors.groupingBy(Animal::getClassification));
        classificationListMap.forEach((classification, animals1) -> {
            System.out.println(classification);
            animals1.forEach(System.out::println);
            System.out.println();
        });

        // Поищем самое старое травоядное животное
       animals.stream()
                .filter(animal -> animal.getClassification().equals(Classification.HERBIVORE))
                .max(Comparator.comparing(Animal::getAge))
                .ifPresent(System.out::println);


    }

    private static List<Animal> getAnimals(){
        return List.of(
                new Animal("Слон", 20, Classification.HERBIVORE),
                new Animal("Жираф", 32, Classification.HERBIVORE),
                new Animal("Медведь", 44, Classification.OMNIVOROUS),
                new Animal("Лев", 1, Classification.PREDATOR),
                new Animal("Черепаха", 88, Classification.HERBIVORE)
        );


    }
}

/*
Потренироваться использовать стримы.

Взять строковый и числовые наборы данных и применить к ним
максимально возможное количество нетерминальных операций.

Выполнить преобразования результата из стрима в списки
*/

package lesson10;

public class Animal {

    private final String name;
    private final int age;
    private final Classification classification;

    public Animal(String name, int age, Classification classification) {
        this.name = name;
        this.age = age;
        this.classification = classification;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classification=" + classification +
                '}';
    }

    public Classification getClassification(){
        return classification;

    }
}

import java.util.*;

public class WildCard{

    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println("Number: " + n);
        }
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(1738); 
        list.add(2012);
        list.add(2007);
        System.out.println("\nIntegers added to list!");
    }

    public static void printAnything(List<?> list) {
        for (Object obj : list) {
            System.out.println("Item: " + obj);
        }
    }

    public static void main(String[] args) {
        RecordBox<String> rb = new RecordBox<>();
        rb.setItem("Aray ko po!!!");
        System.out.println("\nRecordBox contains: " + rb.getItem());
        List<Double> doubles = Arrays.asList(67.1, 37.5, 28.3, 99.5, 72.4);
        printNumbers(doubles);

        List<Number> numbers = new ArrayList<>();
        addIntegers(numbers);
        System.out.println("Numbers list: " + numbers);

        
        List<String> names = Arrays.asList("\nTito", "Vic", "Joey");
        printAnything(names);
    }
}

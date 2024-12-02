import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MathInterface i = Math::random;
        System.out.println(i.get());

        List<String> stringList1 = Arrays.asList("01", "02", "03");
        stringList1.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
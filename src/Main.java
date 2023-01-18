import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium();
        aquarium.start();

       /*List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        for (int n : numbers) {
            numbers.remove(0);
        }*/

       /* List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            System.out.println("1");
            iterator.remove();
        }
        System.out.println(numbers);*/

        /*List<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        ListIterator<Integer> iterator = numbers.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            iterator.add(5);
        }

        System.out.println(numbers);*/
    }


}
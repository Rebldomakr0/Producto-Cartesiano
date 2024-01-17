import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CartesianProduct {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de elementos en los arreglos: ");
        int cantidad = scanner.nextInt();

        List<Integer> arreglo1 = new ArrayList<>();
        List<Integer> arreglo2 = new ArrayList<>();

        System.out.print("Ingrese los elementos del primer arreglo: ");
        for (int i = 0; i < cantidad; ++i) {
            int elem = scanner.nextInt();
            arreglo1.add(elem);
        }

        System.out.print("Ingrese los elementos del segundo arreglo: ");
        for (int i = 0; i < cantidad; ++i) {
            int elem = scanner.nextInt();
            arreglo2.add(elem);
        }

        List<Pair<Integer, Integer>> pares = new ArrayList<>();

        for (Integer elem1 : arreglo1) {
            for (Integer elem2 : arreglo2) {
                pares.add(new Pair<>(elem1, elem2));
            }
        }

        Collections.sort(pares, (a, b) -> {
            int compareFirst = Integer.compare(a.getFirst(), b.getFirst());
            return (compareFirst != 0) ? compareFirst : Integer.compare(a.getSecond(), b.getSecond());
        });

        System.out.print("Multiplicación Cartesiana: ");
        for (Pair<Integer, Integer> p : pares) {
            System.out.print("{" + p.getFirst() + ", " + p.getSecond() + "} ");
        }

        scanner.close();
    }
}

class Pair<T, U> {
    private final T first;
    private final U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }
}


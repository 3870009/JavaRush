package eu.senla.task10;

import java.util.Comparator;

public class MyComparator <E extends Comparable<E>>implements Comparator<E>{

    public int compare(E c1, E c2) {
        return c1.compareTo(c2);

    }

}


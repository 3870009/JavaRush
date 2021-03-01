package eu.senla.task8;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList <Integer> al= new ArrayList<>();
        MyList<Integer> ml = new MyArrayList<>();
        ml.add(1);
        ml.add(8);
        ml.add(5);
        ml.add(3);
        ml.add(1);
        ml.add(656);
        ml.add(99);
        ml.add(54);
        ml.add(87);
        ml.add(23);
        ml.add(55);
        System.out.println(ml);
        ml.remove(1);
        System.out.println(ml);
        ml.remove(4);
        System.out.println(ml);
        ml.add(2,55);
        System.out.println(ml);
        ml.add(8,333);
        System.out.println(ml);
        ml.add(12,777);
        System.out.println(ml);
        ml.add(13,888);
        System.out.println(ml);
        ml.remove(1);
        ml.remove(1);
        ml.remove(1);
        ml.remove(1);
        ml.remove(1);
        ml.remove(1);
        System.out.println(ml);
        System.out.println(ml.get(5));
        System.out.println(ml.indexOf(66));
        ml.add(23);
        System.out.println(ml.lastIndexOf(23));
        MyList <String> str = new MyArrayList<String>();
        str.add("kkk");
        str.add("aaa");
        str.add("yyy");
        MyArrayList<Integer> ml2 = new MyArrayList<>();
        ml2.add(1);
        ml2.add(2);
        ml2.add(3);
        System.out.println(ml);
      // MyList <Integer> mzz = new MyArrayList<Integer>(ml);
        //System.out.println(mzz);
        ml.addAll(0,ml2);
        System.out.println(ml);
        MyList <Integer> lst = MyArrayList.of(1,2,3,4,5,6,7);
        System.out.println(lst);
        MyList <Integer> sublst=lst.subList(2,4);
        System.out.println(sublst);

        ListIterator liter = lst.listIterator();
        while (liter.hasNext()){
            Object element = liter.next();
            System.out.print(element + "+");
        }
        System.out.println("");
        while (liter.hasPrevious()){
            Object element = liter.previous();
            System.out.print(element + "+");
        }

        MyComparator cmp = new MyComparator();
        ml.sort(cmp);
        System.out.println("");
        System.out.println(ml);
        str.sort(cmp);
        System.out.println(str);
    }
}

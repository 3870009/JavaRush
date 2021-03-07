package eu.senla.task8;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    @Test
    void of() {
        MyList <Integer> expected = MyArrayList.of(1,8,5,3);
        MyList<Integer> actual = new MyArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void add() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);

        List <Integer> actual =new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);


       Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void testAdd() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        expected.add(2,9);

        List <Integer> actual =new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(9);
        actual.add(5);
        actual.add(3);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void addAll() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        MyList<Integer> listB = new MyArrayList<>();
        listB.add(6);
        listB.add(7);
        expected.addAll(2, listB);

        List <Integer> actual =new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);
        List<Integer> listB2 = new ArrayList<>();
        listB2.add(6);
        listB2.add(7);
        actual.addAll(2, listB2);

        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void get() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        Integer exp = expected.get(1);
        Integer actual = 8;

        Assert.assertEquals(exp,actual);
    }

    @Test
    void indexOf() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        int exp = expected.indexOf(5);
        int actual = 2;

        Assert.assertEquals(exp,actual);
    }

    @Test
    void lastIndexOf() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        expected.add(8);
        int exp = expected.lastIndexOf(8);
        int actual = 4;

        Assert.assertEquals(exp,actual);
    }

    @Test
    void listIterator() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        expected.add(8);
        Object expectedElement = null;
        ListIterator liter = expected.listIterator();
        while (liter.hasNext()){
            expectedElement = liter.next();
            expectedElement = expectedElement + "+";
        }
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);
        actual.add(8);
        Object actualElement = null;
        ListIterator literator = actual.listIterator();
        while (literator.hasNext()){
            actualElement = literator.next();
            actualElement = actualElement + "+";
        }
        Assert.assertEquals(expectedElement,actualElement);
    }

    @Test
    void remove() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        expected.remove(1);

        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);
        actual.remove(1);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void set() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);
        expected.set(1,9);
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);
        actual.set(1,9);

        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void sort() {
        MyList<Integer> expected = new MyArrayList<>();
        expected.add(1);
        expected.add(8);
        expected.add(5);
        expected.add(3);

        MyComparator cmp = new MyComparator();
        expected.sort(cmp);

        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(8);
        actual.add(5);
        actual.add(3);

        actual.sort(cmp);

        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    void subList() {
        MyList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(8);
        list.add(5);
        list.add(3);
        list.add(6);
        list.add(7);
        MyList <Integer> expected= list.subList(2,4);
        List<Integer> listB = new ArrayList<>();
        listB.add(1);
        listB.add(8);
        listB.add(5);
        listB.add(3);
        listB.add(6);
        listB.add(7);
        List <Integer> actual = listB.subList(2,4);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }
}
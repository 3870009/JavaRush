package eu.senla.task10;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Consumer;

public class MyArrayList<E> implements MyList<E> {
    private static final int DEFAULTCAPACITY = 10;//размер массива по умолчанию
    private int size;//количество элементов в массиве
    Object[] myArrayElements; //массив для хранения элементов
    private static final Object[] DEFAULTCAPACITY_EMPTY_MYARRAYELEMENTS = {};
    public MyArrayList() {
        //  this.myArrayElements = DEFAULTCAPACITY_EMPTY_MYARRAYELEMENTS;
        this.myArrayElements = new Object[DEFAULTCAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.myArrayElements = new Object[capacity];
        } else if (capacity == 0) {
            this.myArrayElements = DEFAULTCAPACITY_EMPTY_MYARRAYELEMENTS;
        } else System.out.println("Capacity can't be less then 0.");
    }


    public MyArrayList(MyList<? extends E> col) {

        Object[] temp = col.toArray();
        if ((size = temp.length) != 0) {
            if (col.getClass() == MyArrayList.class) {
                myArrayElements = temp;
            } else {
                for (int i = 0; i < size; i++) {
                    myArrayElements[i] = temp[i];
                }
            }
        } else {
            myArrayElements = DEFAULTCAPACITY_EMPTY_MYARRAYELEMENTS;
        }
    }


    @Override

    public void add(int index, E obj) throws MyIndexOutOfBoundsException, MyObjConteinsException {
        indexExistanceCheck(index);
        if(obj instanceof Integer && obj.equals(666)){
            throw new MyObjConteinsException("Object contain 666)))");
        }
            if (size == myArrayElements.length) {//проверка места в массиве
                myArrayElements = increaseCapacity();//если нет места, увеличиваем массив
            }

            Object[] temp = myArrayElements;
            myArrayElements = new Object[temp.length + 1];
            for (int i = 0; i < index; i++) {
                myArrayElements[i] = temp[i];//копируем левую часть массива до индекса в новый массив
            }
            myArrayElements[index] = obj;
            for (int i = index, j = index + 1; i < temp.length - 1; i++, j++) {
                myArrayElements[j] = temp[i];//копируем правую часть массива после индекса в новый массив
            }
            size++;

    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayElements[i];
        }
        return temp;
    }


    @Override
    public boolean add(E obj) {
        if (size == myArrayElements.length) {//проверка места в массиве
            myArrayElements = increaseCapacity();//если нет места, увеличиваем массив
        }
        myArrayElements[size] = obj;
        size++;
        return true;
    }


    private Object[] increaseCapacity() { // внутренний метод для увеличения массива
        Object[] temp = new Object[(int) (myArrayElements.length * 1.5)];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayElements[i];
        }
        return temp;
    }


    @Override
    public boolean addAll(int index, MyList<? extends E> col) throws MyIndexOutOfBoundsException {
            indexExistanceCheck(index);
            Object[] tempcol = col.toArray();
            if (size + tempcol.length > myArrayElements.length) {//проверка места в массиве
                myArrayElements = increaseCapacity();//если нет места, увеличиваем массив
            }
            Object[] temp = myArrayElements;
            myArrayElements = new Object[temp.length + tempcol.length];
            for (int i = 0; i < index; i++) {
                myArrayElements[i] = temp[i];//копируем левую часть массива до индекса в новый массив
            }
            for (int i = index, j = 0; j < tempcol.length; j++, i++) {
                myArrayElements[i] = tempcol[j];//копируем коллекцию после индекса в новый массив

            }
            for (int i = index + tempcol.length, j = index; j < temp.length - 1; i++, j++) {
                myArrayElements[i] = temp[j];//копируем правую часть массива после индекса в новый массив
            }
            size = size + tempcol.length;
            return true;

    }

    @Override
    public E get(int index) throws MyIndexOutOfBoundsException {
        indexExistanceCheck(index);
            return (E) myArrayElements[index];

    }

    @Override
    public int indexOf(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (myArrayElements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (obj.equals(myArrayElements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            for (int i = size; i >= 0; i--) {
                if (myArrayElements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size; i >= 0; i--) {
                if (obj.equals(myArrayElements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    public ListIterator<E> listIterator() {
        return new MyListIterator();
    }
    private class MyListIterator<E> implements ListIterator<E> {
        int size = MyArrayList.this.size;
        int currentPointer = 0;
        int lastPointer = size-1;

        @Override
        public boolean hasNext() {
            return (currentPointer<size);
        }

        @Override
        public E next() {
            if(!hasNext()){
                System.out.println("Out of bounds");
            }
            E val = (E) myArrayElements[currentPointer];
            currentPointer +=1;
            return val;
        }

        @Override
        public boolean hasPrevious() {
            return (lastPointer>=0);
        }

        @Override
        public E previous() {
            if(!hasPrevious()){
                System.out.println("Out of bounds");
            }

            E val = (E) myArrayElements[lastPointer];
            lastPointer-=1;
            return val;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void set(E e) {

        }

        @Override
        public void add(E e) {

        }
    }
    public static <E> MyList<E> of(Object... e) {
        MyList lst = new MyArrayList();
        for (int i = 0; i < e.length; i++) {
            lst.add(e[i]);
        }
        return lst;
    }

    @Override
    public E remove(int index) throws MyIndexOutOfBoundsException {
        indexExistanceCheck(index);
        Object[] temp = myArrayElements;
        E oldValue = (E) temp[index];
        if (size >= 1) {
            myArrayElements = new Object[temp.length - 1];

            for (int i = 0; i < index; i++) {
                myArrayElements[i] = temp[i];//копируем левую часть массива до индекса в новый массив
            }
            for (int i = index + 1, j = index; i < temp.length - 1; i++, j++) {
                myArrayElements[j] = temp[i];//копируем правую часть массива после индекса в новый массив
            }
            size--;
        }
        if (size == 0) System.out.println("Array is empty.");
        return oldValue;

    }

    @Override
    public E set(int index, E obj) throws MyIndexOutOfBoundsException {
        indexExistanceCheck(index);
        E oldValue = (E) myArrayElements[index];
        myArrayElements[index] = obj;
        return oldValue;
    }

    private void indexExistanceCheck(int index) throws MyIndexOutOfBoundsException { // внутренний метод для проверки введенного индекса

        if (index < 0 || index >= this.size) {
            throw new MyIndexOutOfBoundsException("Exception. Index is out of bounds of myarraylist.");
        }
    }

    @Override
    public void sort(Comparator<? super E> comp) {
        Object tempObj;
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayElements[i];
        }
        for (int i = 0; i < temp.length; ++i) {
            for (int j = 1; j < temp.length - i; ++j) {
                if (comp.compare((E) temp[j - 1], (E) temp[j]) > 0) {
                    tempObj = temp[j - 1];
                    temp[j - 1] = temp[j];
                    temp[j] = tempObj;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            myArrayElements[i] = temp[i];
        }
    }

    @Override
    public MyList<E> subList(int start, int end) {
        if (subListCheck(start, end, size)!= -1) {

            MyList lst = new MyArrayList();
            for (int index = start; index < end; index++) {
                lst.add(myArrayElements[index]);
            }
            return lst;
        }
        return null;
    }
    private int subListCheck(int start, int end, int size) {
        if (start < 0) {
            System.out.println("Start index is out of bounds = " + start);
            return -1;
        }
        if (end > size) {
            System.out.println("End index is out of bounds = " + end);
            return -1;
        }
        if (start > end) {
            System.out.println("Start index is bigger that end index");
            return -1;
        } else return 1;

    }

    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final Object[] es = myArrayElements;
        final int size = this.size;
        for (int i = 0; i < size; i++)
            action.accept(elementAt(es, i));
    }
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }
    @Override
    public String toString() {
        String result = "";
        Object[] temp = new Object[size];
        for (int i = 0; i < size; i++) {
            temp[i] = myArrayElements[i];
        }
        result += "[";
        for (Object o : temp) {
            result += o + ", ";
        }
        result = result.substring(0,result.length()-2);
        result += "]";
        return result;
    }
}

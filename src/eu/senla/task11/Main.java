package eu.senla.task11;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static class Cpu {
        private String cpuName;
        private double cpuClock;
        private int coresNumber;

        @Override
        public String toString() {
            return "[cpuName='" + cpuName + '\'' +
                    ", cpuClock=" + cpuClock +
                    ", coresNumber=" + coresNumber + " ]";
        }

        public Cpu(String cpuName, double cpuClock, int coresNumber) {
            this.cpuName = cpuName;
            this.cpuClock = cpuClock;
            this.coresNumber = coresNumber;
        }

        public String getCpuName() {
            return cpuName;
        }

        public double getCpuClock() {
            return cpuClock;
        }

        public int getCoresNumber() {
            return coresNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Cpu cpu = (Cpu) o;
            return Double.compare(cpu.cpuClock, cpuClock) == 0 &&
                    coresNumber == cpu.coresNumber &&
                    Objects.equals(cpuName, cpu.cpuName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cpuName, cpuClock, coresNumber);
        }
    }


    public static void main(String[] args) {
        List<Cpu> cpus = new ArrayList<>(Arrays.asList(
                new Cpu("AMD Ryzen 9 5900X", 3.7, 12),
                new Cpu("Intel Core i9-10900K", 3.7, 10),
                new Cpu("Intel Core i9-10980XE", 3.0, 18),
                new Cpu("Intel W-3175X", 3.1, 28),
                new Cpu("Intel Core i7-10700/F", 2.9, 8),
                new Cpu("AMD Threadripper 3990X", 2.9, 64),
                new Cpu("AMD Ryzen 9 3950X", 3.5, 16),
                new Cpu("Intel Core i9-9980XE", 4.4, 18),
                new Cpu("Intel Core i9-7960X", 2.8, 16),
                new Cpu("Intel Pentium G4620", 3.7, 2)
        ));
//Сортировка процессоров Intel по частоте
        cpus.stream()
                .peek(cpu -> System.out.println("***" + cpu))
                .filter(cpu -> cpu.getCpuName().startsWith("Intel"))
                .sorted(Comparator.comparingDouble(cpu1 -> cpu1.getCpuClock()))
                .forEach(System.out::println);
//------------------------------------------------------
//


       List <String> lst = cpus.stream()
                .filter(cpu -> cpu.getCpuName().startsWith("AMD"))
                .sorted(Comparator.comparingDouble(Cpu::getCpuClock))
                .map(cpu -> cpu.getCpuName().substring(0, cpu.getCpuName().indexOf(' ')) + " " + cpu.getCpuClock())
                .skip(1)
                .collect(Collectors.toList());;
        System.out.println("+" + lst);

        cpus.stream()
                .mapToInt(value -> value.getCoresNumber()*1)
                .sorted()
                .forEach(System.out::println);

        System.out.println("Количество элементов в стриме " + cpus.stream().count());
        System.out.println("Минимальный по количеству ядер процессор " + cpus.stream().min((o1, o2) -> o1.getCoresNumber()- o2.getCoresNumber()));
        System.out.println("Максимальный по количеству ядер процессор " + cpus.stream().max((o1, o2) -> o1.getCoresNumber()-o2.getCoresNumber()));
        System.out.println("Есть ли в стриме процессоры AMD? " + cpus.stream().anyMatch(cpu -> cpu.getCpuName().startsWith("AMD")));

     /*   List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        //вариант 1
        List<Integer> outList = list.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).collect(Collectors.toList());
        System.out.println(outList);
        //вариант 2
        List<Integer> outList2 = list.stream()
                .filter((x) -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(outList2);

        list.stream()
                .filter((x) -> x % 2 > 0)
                .forEach(integer -> System.out.println(integer));

        Stream.of("1", "2", "3", "4", "5")
                .map(s -> Integer.parseInt(s))
                .sorted((o1, o2) -> o2 - o1)
                .forEach(integ -> System.out.println(integ));

        Stream.of(1, 2, 3, 4, 5)
                .map(s -> s * 2)
                .sorted((o1, o2) -> o2 - o1)
                .forEach(integ -> System.out.println(integ));

        System.out.println(Stream.of(1, 2, 3, 4, 5)
                .map(s -> s * 2)
                .sorted((o1, o2) -> o2 - o1)
                .map(integer -> integer.toString())
                .collect(Collectors.joining("+++", "Numbers: ", ".")));*/
    }
}

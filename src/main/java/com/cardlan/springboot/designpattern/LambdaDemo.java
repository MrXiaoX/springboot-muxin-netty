package com.cardlan.springboot.designpattern;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class  Student{
    public Student() {
    }

    private Integer age;

    private  String name;

    private  Integer stature;

    public Student( String name,Integer age, Integer stature) {
        this.age = age;
        this.name = name;
        this.stature = stature;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStature() {
        return stature;
    }

    public void setStature(Integer stature) {
        this.stature = stature;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", stature=" + stature +
                '}';
    }
}

public class LambdaDemo {
    public static void main(String[] args) {
//        Predicate<Integer> predicate = x -> x > 185;
//        Student student = new Student("9龙", 23, 175);
//        System.out.println(
//                "9龙的身高高于185吗？：" + predicate.test(student.getStature()));
//
//        Consumer<String> consumer = System.out::println;
//        consumer.accept("命运由我不由天");
//
//        Function<Student, String> function = Student::getName;
//        String name = function.apply(student);
//        System.out.println(name);
//
//        Supplier<Integer> supplier =
//                () -> Integer.valueOf(BigDecimal.TEN.toString());
//            System.out.println(supplier.get());
//
//        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
//        Boolean apply2 = unaryOperator.apply(true);
//        System.out.println(apply2);
//
//        BinaryOperator<Integer> operator = (x, y) -> x * y;
//        Integer integer = operator.apply(2, 3);
//        System.out.println(integer);
//
//        test(() -> "我是一个演示的函数式接口");
//        List<Student> studentList = Stream.of(new Student("路飞", 22, 175),
//                new Student("红发", 40, 180),
//                new Student("白胡子", 50, 185)).filter(stu -> stu.getStature() >= 180).collect(Collectors.toList());
//        System.out.println(studentList);
        List<Student> students = new ArrayList<>(3);
        students.add(new Student("路飞", 22, 175));
        students.add(new Student("红发", 40, 180));
        students.add(new Student("白胡子", 50, 185));

        List<Student> studentList = Stream.of(students,
                Arrays.asList(new Student("艾斯", 25, 183),
                        new Student("雷利", 48, 176)))
                .flatMap(students1 -> students1.stream()).collect(Collectors.toList());
//        System.out.println(studentList);

        Optional<Student> max = students.stream().max(Comparator.comparing(stu -> stu.getAge()));
        if(max.isPresent())
        {
            System.out.println(max);
        }
    }
    /**
     * 演示自定义函数式接口使用
     *
     * @param worker
     */
    public static void test(Worker worker) {
        String work = worker.work();
        System.out.println(work);
    }

    public interface Worker {
        String work();
    }
}

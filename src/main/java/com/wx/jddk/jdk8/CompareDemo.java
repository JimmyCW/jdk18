package com.wx.jddk.jdk8;

import java.util.*;

/**
 * @author weixing
 * @date 2019/3/13
 **/
public class CompareDemo {

    static class User {
        private Integer age;
        private String name;

        public User(String name, Integer age) {
            this.age = age;
            this.name = name;
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
    }

    class Person {

        String firstName;
        String lastName;

        public Person() {
        }

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
    interface PersonFactory<T extends Person> {
        T construct(String firstName, String lastName);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2, 1, 3);
        list.sort((a, b) -> a.compareTo(b));
        list.forEach(System.out::println);
        list.sort(Integer::compareTo);
        list.forEach(System.out::println);
        Collections.sort(list, (a, b) -> a.compareTo(b));
        Collections.sort(list, Integer::compareTo);
        List<User> users = initList();
        Collections.sort(users, (a, b) -> a.getAge().compareTo(b.getAge()));
        Collections.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName).reversed());

//        PersonFactory<Person> personPersonFactory = Person::new;
//        Person construct = personPersonFactory.construct("a", "b");
        Map<Integer, String> map = new HashMap<>();
        map.forEach((a,b)->{
            System.out.println(a+ b);
        });

    }

    private static List<User> initList() {

        List<User> list = new ArrayList<>();
        list.add(new User("User", 23));
        list.add(new User("tom", 11));
        list.add(new User("john", 16));
        list.add(new User("dennis", 26));
        list.add(new User("tin", 26));
        list.add(new User("army", 26));
        list.add(new User("mack", 19));
        list.add(new User("jobs", 65));

        return list;
    }


}

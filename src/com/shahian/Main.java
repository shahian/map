package com.shahian;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Book> books = new ArrayList<>();
        books.add(new Book(5L, "test1"));
        books.add(new Book(4L, "test2"));
        books.add(new Book(3L, "test3"));
        books.add(new Book(2L, "test4"));
        books.add(new Book(1L, "test1"));

        listToMap(books);
        listToMapWithoutDupKey(books);
        listToMapWithDupKey();
        hashTable(books);
        treemap(books);
        listToLinkedHashMap(books);
        linkedHashMapToList(books);

    }

    private static void linkedHashMapToList(List<Book> books) {
        List<Book> books1 = new ArrayList<>();

        LinkedHashMap<Long, String> hashMap = (LinkedHashMap<Long, String>) books.stream().collect(Collectors.toMap(
                Book::getId, Book::getName, (s, s2) -> s2, LinkedHashMap::new));
        for (Map.Entry<Long, String> longStringEntry : hashMap.entrySet()) {
            books1.add(new Book(longStringEntry.getKey(), longStringEntry.getValue()));
        }
        System.out.println(books1);


    }

    private static void listToLinkedHashMap(List<Book> books) {
        LinkedHashMap<Long, String> hashMap = (LinkedHashMap<Long, String>) books.stream().collect(Collectors.toMap(
                Book::getId, Book::getName, (s, s2) -> s2, LinkedHashMap::new));
        System.out.println(hashMap);
    }

    private static void treemap(List<Book> books) {
        TreeMap<Long, String> map =
                books.stream()
                        .collect(Collectors.toMap(
                                Book::getId,
                                Book::getName,
                                (x, y) -> x + " " + y,
                                TreeMap::new
                        ));
        map.forEach(
                (x, y) -> System.out.println("treemap : " + x + " " + y)
        );
    }

    private static void hashTable(List<Book> books) {
        Hashtable<Long, String> hashtable =
                books.stream().collect(Collectors.toMap(
                        Book::getId,
                        Book::getName,
                        (x, y)
                                -> x + " " + y,
                        Hashtable::new)
                );
        hashtable.forEach(
                (x, y) -> System.out.println("List To HashTable : " + x + " " + y)

        );

        for (Map.Entry<Long, String> hashtable1 : hashtable.entrySet()) {
            System.out.println("another travers  To HashTable: " + hashtable1.getKey() + " " + hashtable1.getValue());
        }
    }

    private static void listToMap(List<Book> books) {
        Map<Long, String> map = new HashMap<>();
        for (Book book : books) {
            map.put(book.getId(), book.getName());

        }
        System.out.println("map : " + map);

        map.entrySet().forEach(entry -> {
            System.out.println("print map details : " + entry.getKey() + " " + entry.getValue());
        });
    }

    private static void listToMapWithoutDupKey(List<Book> books) {
        Map<Long, String> map =
                books.stream().collect(
                        Collectors.toMap(
                                Book::getId,
                                Book::getName
                        ));
        map.forEach(
                (x, y) -> System.out.println("listToMapWithoutDupKey : " + x + "=" + y));
    }

    private static void listToMapWithDupKey() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "test1"));
        books.add(new Book(2L, "test2"));
        books.add(new Book(2L, "test22"));
        books.add(new Book(3L, "test3"));
        books.add(new Book(4L, "test4"));
        books.add(new Book(4L, "test14"));
        Map<Long, String> map =
                books.stream().collect(
                        Collectors.toMap(
                                Book::getId,
                                Book::getName,
                                (x, y) -> x + " duplicate " + y
                        ));

        // print map
        map.forEach(
                (x, y) -> System.out.println(x + "=" + y));

    }


}

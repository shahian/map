package com.shahian;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "test1"));
        books.add(new Book(2L, "test2"));
        books.add(new Book(3L, "test3"));
        books.add(new Book(4L, "test4"));
        
        approch1(books);
        approch2(books);


    }

    private static void approch2(List<Book> books) {
        Map<Long, String> map =
                books.stream().collect(
                        Collectors.toMap(
                                Book::getId,
                                Book::getName,
                                (x, y) -> x + " " + y
                        ));

        // print map
        map.forEach(
                (x, y) -> System.out.println(x + "=" + y));

    }


    private static void approch1(List<Book> books) {
        Map<Long, String> map = new HashMap<>();
        for (Book book : books) {
            map.put(book.getId(), book.getName());

        }
        System.out.println("map : " + map);

        map.entrySet().forEach(entry -> {
            System.out.println("print map details : " + entry.getKey() + " " + entry.getValue());
        });
    }


}

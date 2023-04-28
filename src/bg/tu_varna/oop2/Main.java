package bg.tu_varna.oop2;

import java.io.IOException;
import java.util.Arrays;

/**
 * Задание 7.
 * Курсова работа
 */
public class Main {
    /**
     * 7-IV. Главна функция:
     * 1) Създава обекти от III
     * 2) Извеждане на книгите на конзолен изход
     * 3) Добавяне на страница към IV.1, извеждане на резултата на конзолен изход
     * 4) Премахване на страница от IV.1, извеждане на резултата на конзолен изход
     * 5) Разменяне на две от страниците от IV.1, извеждане на резултата на конзолен изход
     * 6) Сравнение на обектите по брой страници. Намиране на най-„дебелата“ книга
     * 7) Сортиране на обектите.
     * 8) Обработване на изключение
     */
    public static void main(String[] args) {
        try{
            //1) Създава обекти от III
            System.out.println("1) Създава обекти от III");
            Book books [] = {
                    new Book(),
                    new Book(3,"Book II"),
                    new Book(1,"Book III")};
            //2) Извеждане на книгите на конзолен изход
            System.out.println("2) Извеждане на книгите на конзолен изход");
            System.out.println(Arrays.toString(books));
            //3) Добавяне на страница към IV.1, извеждане на резултата на конзолен изход
            System.out.println("3) Добавяне на страница към IV.1, извеждане на резултата на конзолен изход");
            BookPage bp1 = new BookPage(1);
            BookPage bp2 = new BookPage(2);
            bp1.setPageContent("Page 1 content");
            bp2.setPageContent("Page 2 content");
            books[0].addPage(bp1);
            books[0].addPage(bp2);
            System.out.println(books[0]);
            //4) Премахване на страница от IV.1, извеждане на резултата на конзолен изход
            System.out.println("4) Премахване на страница от IV.1, извеждане на резултата на конзолен изход");
            books[0].removePage(1);
            System.out.println(books[0]);
            //5) Разменяне на две от страниците от IV.1, извеждане на резултата на конзолен изход
            System.out.println("5) Разменяне на две от страниците от IV.1, извеждане на резултата на конзолен изход");
            books[0].swapPages(0,1);
            System.out.println(books[0]);
            //6) Сравнение на обектите по брой страници. Намиране на най-„дебелата“ книга
            System.out.println("6) Сравнение на обектите по брой страници. Намиране на най-„дебелата“ книга");
            System.out.println(books[0].compareTo(books[1]));
            //7) Сортиране на обектите.
            System.out.println("7) Сортиране на обектите.");
            Arrays.sort(books);
            System.out.println(Arrays.toString(books));

        } catch (IOException|NullPointerException e) {
            System.out.println("Error, bad input!");
        }

    }
}
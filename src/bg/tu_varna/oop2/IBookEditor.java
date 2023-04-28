package bg.tu_varna.oop2;

import java.io.IOException;
import java.util.List;

/**
 * 7-I. Да се състави интерфейс Редактор на книга IBookEditor
 */
public interface IBookEditor {

    /**
     * Методи:
     * 1) List<BookPage> generateBook(string title, int numberPages ) - създава страници от книга със заглавие title и празни
     * страници брой numberPages и ги добавя
     */
    public List<BookPage> generateBook(String title, int pageCount);

    /**
     * Методи:
     * 2) void swapPages(int firstPN, int secondPN) - разменя страниците с номера – параметри firstPN, secondPN.
     * Продуцира изключение, ако не може да се изпълни
     */
    public void swapPages(int firstPage, int secondPage) throws IOException;
}

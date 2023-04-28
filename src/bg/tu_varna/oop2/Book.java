package bg.tu_varna.oop2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** 7-III. Да се състави клас Книга Book за съхраняване на страници (подредени по номер на
 * страница), Comparable, IBookEditor
 * Скрити член променливи: Списък от страници – съдържа обекти от клас II
*/
class Book implements Comparable, IBookEditor{
    private List<BookPage> pages;

    /**
     * Конструктори:
     * 1) експлицитен по брой страници и заглавна страница, създава книга със заглавие и празни страници –
     * указания брой;
     */
    Book(){
        pages = generateBook("Default Title",0);
    }

    /**
     * Конструктори:
     * 2) подразбиращ се – създава книга само със заглавие
     */
    Book(int pageCount, String title){
        pages = generateBook(title,pageCount);
    }

    /**
     * Методи:
     * 1) Добавяне на страница – параметър страница, номера ще бъде поредния най-голям
     */
    void addPage(BookPage page){
        if(page==null) throw new NullPointerException();
        pages.add(new BookPage(pages.size()));
        pages.get(pages.size()-1).setPageContent(page.getPageContent());
    }

    /**
     * Методи:
     * 2) Променяне на страница – параметър страница, промяна на съдържанието на номер страница, изключение,
     * ако не съществува
     */
    void changePage(BookPage page) throws IOException {
        if(page==null) throw new NullPointerException();
        int pn = page.getPageNumber();
        if(pn>=pages.size()) throw new IOException();
        pages.get(pn).swapPages(page);
    }

    /**
     * Методи:
     * 3) Вмъкване на страница – параметър страница. Ако съществува страница със същия номер, преномериране на
     * останалите страници, докрая
     */
    void insertPage(BookPage page) throws IOException {
        if(page==null) throw new NullPointerException();
        int pn = page.getPageNumber();
        if(pn>pages.size()) throw new IOException();
        if(pn == pages.size()){
            addPage(page);
        } else {
            pages.add(pn, page);
            for(int i = pn+1; i<pages.size(); i++){
                pages.get(i).setPageNumber(i);
            }
        }
    }

    /**
     * Методи:
     * 4) Премахване на страница с подаден параметър номер на страница, изключение, ако не съществува.
     * Преномериране на страниците
     */
    void removePage(int pn) throws IOException {
        if(pn>=pages.size()) throw new IOException();
        pages.remove(pn);
        for(int i = pn; i< pages.size(); i++){
            pages.get(i).setPageNumber(i);
        }
    }

    /**
     * Методи:
     * 5) Разменяне на съдържание на подадени две референции към страници. Продуцира изключение, ако не може да
     * се изпълни
     */
    void swapPagesRef(BookPage bp1, BookPage bp2) throws IOException {
        if(bp1==null||bp2==null) throw new NullPointerException();
        swapPages(bp1.getPageNumber(),bp2.getPageNumber());
    }

    /**
     * Методи:
     * 6) Преобразува / връща низ от членовете на класа
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(BookPage bp: pages)
            sb.append(bp);
        return sb.toString();
    }

    /**
     * Методи:
     * 7) Имплементиране на интерфейса
     */
    @Override
    public List<BookPage> generateBook(String title, int pageCount){
        if(title==null) throw new NullPointerException();
        List <BookPage> pageList = new ArrayList<>(pageCount);
        BookPage p = new BookPage(0);
        p.setPageContent(title);
        pageList.add(0, p);
        for(int i = 1; i<=pageCount; i++){
            pageList.add(new BookPage(i));
        }
        return pageList;
    }

    /**
     * Методи:
     * 7) Имплементиране на интерфейса
     */
    @Override
    public void swapPages(int firstPage, int secondPage) throws IOException {
        if(firstPage>pages.size()||secondPage>pages.size())
            throw new IOException();
        pages.get(firstPage).swapPages(pages.get(secondPage));
    }

    /**
     * Методи:
     * 8) За сравнение compareTo по брой страници
     */
    @Override
    public int compareTo(Object o) {
        if (o==null) throw new NullPointerException();
        if (this.getClass()!=o.getClass()) throw new ClassCastException();
        Book other = (Book) o;
        return Integer.compare(this.pages.size(),other.pages.size());
    }

    /**
     * Методи:
     * 9) За еквивалентност equals по заглавие
     */
    @Override
    public boolean equals(Object o) {
        if (o==null) throw new NullPointerException();
        if (this.getClass()!=o.getClass()) throw new ClassCastException();
        Book other = (Book) o;
        return this.pages.get(0).equals(other.pages.get(0));
    }


}

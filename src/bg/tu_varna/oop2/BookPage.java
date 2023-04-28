package bg.tu_varna.oop2;

/**
 * 7-II. Да се състави клас Страница BookPage, Comparable
 * Скрити член променливи: Номер на страница- число int; Съдържание – низ string;
 */
class BookPage implements Comparable{
    private int pageNumber;
    private String pageContent;

    /**
     * Конструктори:
     * 1) експлицитен
     */
    BookPage(int pageNumber){
        this.pageNumber = pageNumber;
        pageContent = "";
    }

    /**
     * Конструктори:
     * 2) подразбиращ се – пореден номер страница, празен низ;
     */
    BookPage(){
        pageNumber = -1;
        pageContent = "";
    }

    /**
     * Методи:
     * 1) Четене на pageNumber
     */
    int getPageNumber() {
        return pageNumber;
    }

    /**
     * Методи:
     * 1) Запис на pageNumber
     */
    void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Методи:
     * 1) Четене на pageContent
     */
    String getPageContent() {
        return pageContent;
    }

    /**
     * Методи:
     * 1) Запис на pageContent
     */
    void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }

    /**
     * Методи:
     * 2) За размяна на съдържание на страница с подадената като параметър референция към страница;
     */
    void swapPages(BookPage bp2) {
        if(bp2==null) throw new NullPointerException("Impossible operation");
        String tmp = pageContent;
        setPageContent(bp2.getPageContent());
        bp2.setPageContent(tmp);
    }

    /**
     * Методи:
     * 3) За сравнение compareTo (по номер страница)
     */
    @Override
    public int compareTo(Object o) {
        if (o==null) throw new NullPointerException();
        if (this.getClass()!=o.getClass()) throw new ClassCastException();
        BookPage other = (BookPage) o;
        return Integer.compare(pageNumber,other.pageNumber);
    }

    /**
     * Методи:
     * 4) За еквивалентност equals по всички
     */
    @Override
    public boolean equals(Object o) {
        if (o==null) throw new NullPointerException();
        if (this.getClass()!=o.getClass()) throw new ClassCastException();
        BookPage other = (BookPage) o;
        return pageNumber == other.pageNumber;
    }

    /**
     * Методи:
     * 5) За извеждане toString
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(pageContent);
        sb.append('\n').append(pageNumber).append('\n');
        return sb.toString();
    }
}

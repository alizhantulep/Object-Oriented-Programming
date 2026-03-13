package problem1;

public class Book extends LibraryItem {
	private int numberOfPages;
	private String location;
	public Book(String title, String author, int year, int pages, String location) {
		super(title, author, year);
		this.numberOfPages = pages;
		this.location = location;
	}
	public String authorr() {
		return ("This book - " + gettitle() + "was written by " + getauthor() + " in " + location);
	}
}

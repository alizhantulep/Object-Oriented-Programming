package problem1;

public class LibraryItem {
	private String title, author;
	private int publicationYear;
	public LibraryItem(String t, String au, int pub) {
		this.title = t;
		this.author = au;
		this.publicationYear = pub;
	}
	public String gettitle() {
		return this.title;
	}
	public String getauthor() {
		return this.author;
	}
	public int getpublic() {
		return this.publicationYear;
	}
	public void settitle(String titl) {
		this.title = titl;
	}
	public void setauthor(String autho) {
		this.author = autho;
	}
	public void setpublic(int pub) {
		this.publicationYear = pub;
	}
	public String toString() {
		return ("The title is:" + title +  "The author is: " + author + " The publication year: " + publicationYear);
	}
}

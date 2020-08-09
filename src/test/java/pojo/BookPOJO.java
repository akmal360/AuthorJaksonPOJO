package pojo;

import java.time.LocalDate;

public class BookPOJO {

	private String bookName;
	private String title;
	private boolean inPrint;
	private LocalDate publishDate;

	public String getTitle() {
		return title;
	}

	public boolean isInPrint() {
		return inPrint;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setInPrint(boolean inPrint) {
		this.inPrint = inPrint;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}

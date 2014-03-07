package com.imaginea.controller;

import com.imaginea.domain.Book;
import com.imaginea.service.BookService;

import java.util.List;

import javax.portlet.RenderResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

/**
 * BookController shows the books in the book Catalog.
 * @author asarin
 *
 */
@Controller(value="bookController")
@RequestMapping(value = "VIEW")
public class BookController {

	// -- auto-wiring of service dependency
	@Autowired
	@Qualifier("myBookService")
	private BookService bookService;

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	// --maps the incoming portlet request to this method
	@RenderMapping
	public String showBooks(RenderResponse response) {
		return "home";
	}

	@ExceptionHandler({ Exception.class })
	public String handleException() {
		return "errorPage";
	}
	
	@ModelAttribute(value="books")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}
}

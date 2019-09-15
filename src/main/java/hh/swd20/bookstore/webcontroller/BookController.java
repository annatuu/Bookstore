package hh.swd20.bookstore.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@Controller
public class BookController {
	
	@Autowired
	private BookRepository bookrepository;
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/booklist")
	public String showBooklist(Model m) {
		m.addAttribute("books", bookrepository.findAll());
		return "booklist";
	}
	
	@RequestMapping("/addbook")
	public String addBook(Model m) {
		m.addAttribute("book", new Book());
		return "addbook";
	}
	
	@PostMapping("/savebook")
	public String saveBook(Book book) {
		bookrepository.save(book);
		return "redirect:booklist";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable("id") Long id, Model m) {
		bookrepository.deleteById(id);
		return "redirect:../booklist";
	}
	
	@RequestMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id, Model m) {
		m.addAttribute("book", bookrepository.findById(id));
		return "editbook";
	}

}

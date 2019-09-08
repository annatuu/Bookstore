package hh.swd20.bookstore.webcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/index")
	public String showIndexPage() {
		return "index";
	}

}
package hh.swd20.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.bookstore.domain.Book;
import hh.swd20.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			repository.save(new Book("Java-ohjelmointi", "Mika Vesterholm - Jorma Kyppö", 2003, "951-762-832-3", 49.99));
			repository.save(new Book("Suomi-englanti-suomi sanakirja", "Hurme - Malin - Pesonen - Syväoja", 2001, "951-0-24662-X", 54.50));
		};
	}

}

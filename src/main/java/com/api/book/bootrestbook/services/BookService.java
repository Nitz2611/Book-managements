package com.api.book.bootrestbook.services;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

//we can use @component also
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	//private static List<Book> list =new ArrayList<>();
	
//	static {
//		list.add(new Book(13,"java book","ramesh bhai"));
//		list.add(new Book(14,"python book","kamlesh bhai"));
//		list.add(new Book(15,"golang book","raj bhai"));
//	
//	}
	//get all books
	public List<Book> getAllBooks(){
		List<Book> find = (List<Book>) this.bookRepository.findAll();
		return find;
	}
	
	//get single book by id
	
	public Book getBookById(int id) {
		
		Book book=null;
		try {
		
		//matching book id from list
		//book=list.stream().filter(e->e.getId()==id).findFirst().get();
		
		book=this.bookRepository.findById(id);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
	
	public Book addBook(Book b) {
		Book res = bookRepository.save(b);
		return res;
	}
	
	//delete book
	
	public void deleteBook(int id) {
		
//		list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
		bookRepository.deleteById(id);
	}

	//update book
	
	public void updateBook(Book book, int id) {
//		list.stream().map(b->{
//			if(b.getId()==id) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		book.setId(id);
		
		bookRepository.save(book);
	}
}

package test.belilif.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.belilif.todo.dao.ProductRepository;
import test.belilif.todo.entities.Todo;

@RestController()
public class TodoController {

	@Autowired // injection de dépendance automatique (avec annotation)
	private ProductRepository productRepository;

	@RequestMapping("/test")
	public String test() {
		return "test";
	}

	@RequestMapping("/save")
	public Todo saveProduct(Todo p) {
		productRepository.save(p);
		return p;
	}
	
	@RequestMapping("/get")
	public Todo getProduct(Long id) {
		return productRepository.findOne(id);
	}
	
	@RequestMapping("/delete")
	public boolean deleteProduct(long id) {
		productRepository.delete(id);
		return !productRepository.exists(id);
	}
	
	@RequestMapping("/update")
	public Todo updateProduct(Todo p) {
		productRepository.saveAndFlush(p);
		return p;
	}

	@RequestMapping("/all")
	public List<Todo> getProducts() {
		return productRepository.findAll();
	}

	@RequestMapping("/todoList")
	public Page<Todo> getPageProducts(int pageNbr) {
		return productRepository.findAll(new PageRequest(pageNbr, 10));
	}

	@RequestMapping("/todoListByKeyWord")
	public Page<Todo> getPageProductsByKeyWord(String kw, int pageNbr) {
		return productRepository.findByKeyWord("%"+kw+"%", new PageRequest(pageNbr, 10));
	}

}

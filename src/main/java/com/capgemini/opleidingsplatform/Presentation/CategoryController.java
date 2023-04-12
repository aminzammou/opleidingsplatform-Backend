package com.capgemini.opleidingsplatform.Presentation;

import com.capgemini.opleidingsplatform.Application.CategoryService;
import com.capgemini.opleidingsplatform.Presentation.dto.CategoryDTO;
import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @PostMapping
    public String createCategory(@RequestBody CategoryDTO DTO) throws CategoryNotFoundException {
        return categoryService.createCategory(DTO);
    }

    @DeleteMapping("/{name}")
    public Category deleteCategory(@PathVariable String name) throws CategoryNotFoundException {
        return categoryService.deleteCategory(name);
    }

    @GetMapping
    public List<Category> getAll() throws CategoryNotFoundException {
        List<Category> cat = categoryService.findAll();
        return cat;
    }

    @GetMapping("/{id}")
    public Category getCategoryByCode(@PathVariable String id) throws CategoryNotFoundException {
        UUID uId = UUID.fromString(id);
        return categoryService.findById(uId);
    }

//    @GetMapping("/{name}")
//    public Category getCategoryByCode(@PathVariable String name) throws CategoryNotFoundException {
//        return categoryService.findByName(name);
//    }

}

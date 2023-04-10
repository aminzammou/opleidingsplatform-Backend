package com.capgemini.opleidingsplatform;

import com.capgemini.opleidingsplatform.Presentation.dto.CategoryDTO;
import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public String createCategory(CategoryDTO dto){
        try {
            this.findByName(dto.getName());
            throw new CategoryNotFoundException("An Category with this name already exists!");
        } catch(CategoryNotFoundException ex){
            Category category = CategoryByDTO(dto);
            category = categoryRepository.save(category);
            return category.getName();
        }
    }

    public Category updateCategory(CategoryDTO dto) throws CategoryNotFoundException {
        Category category = categoryRepository.findByCategoryName(dto.getName())
                .orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        category.setName(dto.getName());
        Category updated = categoryRepository.save(category);
        return updated;
    }
//
    public Category deleteCategory(String name) throws CategoryNotFoundException {
        Category category = categoryRepository.findByCategoryName(name).orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        categoryRepository.delete(category);
        return category;
    }

    public Category findByName(String name) throws CategoryNotFoundException {
        Category category = categoryRepository.findByCategoryName(name).orElseThrow(() -> new CategoryNotFoundException("Airport was not found !"));
        return category;
    }

    public List<Category> findAll(){
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

//    public CategoryDTO CategoryToDTO(Category category){
//        return new CategoryDTO(category.getName());
//    }

    public Category CategoryByDTO(CategoryDTO dto){
        return new Category(dto.getName());
    }

}

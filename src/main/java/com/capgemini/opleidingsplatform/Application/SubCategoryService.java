package com.capgemini.opleidingsplatform.Application;

import com.capgemini.opleidingsplatform.Data.CategoryRepository;
import com.capgemini.opleidingsplatform.Data.SubCategoryRepository;
import com.capgemini.opleidingsplatform.Presentation.dto.CategoryDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.SubCategoryDTO;
import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SubCategoryService {
    private final SubCategoryRepository subCategoryRepository;
    private final CategoryService categoryService;

    public SubCategoryService(SubCategoryRepository subCategoryRepository, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.categoryService = categoryService;
    }
    public String createSubCategory(SubCategoryDTO dto) throws CategoryNotFoundException {
        try {
            this.findByName(dto.getName());
            throw new CategoryNotFoundException("An subcategory with this name already exists!");
        } catch(CategoryNotFoundException ex){
            SubCategory subCategory = SubCategoryByDTO(dto);
            subCategory = subCategoryRepository.save(subCategory);
            return subCategory.getName();
        }
    }

    public SubCategory updateSubCategory(SubCategoryDTO dto) throws CategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findBySubCategoryName(dto.getName())
                .orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        subCategory.setName(dto.getName());
        SubCategory updated = subCategoryRepository.save(subCategory);
        return updated;
    }
//
    public SubCategory deleteSubCategory(String name) throws CategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findBySubCategoryName(name).orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        subCategoryRepository.delete(subCategory);
        return subCategory;
    }

    public SubCategory findByName(String name) throws CategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findBySubCategoryName(name).orElseThrow(() -> new CategoryNotFoundException("Airport was not found !"));
        return subCategory;
    }

    public List<SubCategory> findAll(){
        List<SubCategory> subCategories = subCategoryRepository.findAll();

        return subCategories;
    }

//    public CategoryDTO CategoryToDTO(Category category){
//        return new CategoryDTO(category.getName());
//    }

    public SubCategory findById(UUID id) throws CategoryNotFoundException {
        SubCategory subCategory = subCategoryRepository.findBySubCategoryId(id).orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        return subCategory;
    }

    public SubCategory SubCategoryByDTO(SubCategoryDTO dto) throws CategoryNotFoundException {
        System.out.println(dto.getName());
        UUID id = UUID.fromString(dto.getCategoryId());
        Category category = categoryService.findById(id);
        return new SubCategory(dto.getName(), dto.getDescription(),category);
    }

}

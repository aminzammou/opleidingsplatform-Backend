package com.capgemini.opleidingsplatform.Presentation;

import com.capgemini.opleidingsplatform.Application.SubCategoryService;
import com.capgemini.opleidingsplatform.Presentation.dto.CategoryDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.SubCategoryDTO;
import com.capgemini.opleidingsplatform.domain.Category;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
@RestController
@RequestMapping("/subCategory")
public class SubCategoryController {
    private final SubCategoryService subCategoryService;


    @Autowired
    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }


    @PostMapping
    public String createSubCategory(@RequestBody SubCategoryDTO DTO) throws CategoryNotFoundException {
        return subCategoryService.createSubCategory(DTO);
    }

    @DeleteMapping("/{name}")
    public SubCategory deleteSubCategory(@PathVariable String name) throws CategoryNotFoundException {
        return subCategoryService.deleteSubCategory(name);
    }

    @GetMapping
    public List<SubCategory> getAll() throws CategoryNotFoundException {
        List<SubCategory> cat = subCategoryService.findAll();
        return cat;
    }

    @GetMapping("/{id}")
    public SubCategory getSubCategoryByCode(@PathVariable String id) throws CategoryNotFoundException {
        UUID uId = UUID.fromString(id);
        return subCategoryService.findById(uId);
    }

//    @GetMapping("/{name}")
//    public SubCategory getSubCategoryByCode(@PathVariable String name) throws CategoryNotFoundException {
//        return subCategoryService.findByName(name);
//    }

}

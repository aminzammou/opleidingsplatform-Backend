package com.capgemini.opleidingsplatform.Presentation;

import com.capgemini.opleidingsplatform.Application.ItemService;
import com.capgemini.opleidingsplatform.Application.SubCategoryService;
import com.capgemini.opleidingsplatform.Presentation.dto.ItemDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.SubCategoryDTO;
import com.capgemini.opleidingsplatform.domain.Item;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;


    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @PostMapping
    public String createItem(@RequestBody ItemDTO DTO) throws CategoryNotFoundException {
        return itemService.createItem(DTO);
    }

    @DeleteMapping("/{name}")
    public Item deleteItem(@PathVariable String name) throws CategoryNotFoundException {
        return itemService.deleteItem(name);
    }

    @GetMapping
    public List<Item> getAll() throws CategoryNotFoundException {
        List<Item> cat = itemService.findAll();
        return cat;
    }

    @GetMapping("/{id}")
    public Item getItemByCode(@PathVariable String id) throws CategoryNotFoundException {
        UUID uId = UUID.fromString(id);
        return itemService.findById(uId);
    }

//    @GetMapping("/{name}")
//    public Item getItemByCode(@PathVariable String name) throws CategoryNotFoundException {
//        return itemService.findByName(name);
//    }

}

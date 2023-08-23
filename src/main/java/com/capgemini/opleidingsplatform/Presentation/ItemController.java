package com.capgemini.opleidingsplatform.Presentation;

import com.capgemini.opleidingsplatform.Application.ItemService;
import com.capgemini.opleidingsplatform.Presentation.dto.CodeDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.CodeResultDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.ItemDTO;
import com.capgemini.opleidingsplatform.domain.Item;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@CrossOrigin
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

    @PostMapping("/result")
    public CodeResultDTO getResultItem(@RequestBody CodeDTO DTO) throws JsonProcessingException {
        System.out.println(DTO.getCode() + " en  " + DTO.getTime());
         return itemService.createResultItem(DTO);
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

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody ItemDTO DTO) throws CategoryNotFoundException {
        return itemService.updateItem(DTO);
    }


//    @GetMapping("/{name}")
//    public Item getItemByCode(@PathVariable String name) throws CategoryNotFoundException {
//        return itemService.findByName(name);
//    }

}

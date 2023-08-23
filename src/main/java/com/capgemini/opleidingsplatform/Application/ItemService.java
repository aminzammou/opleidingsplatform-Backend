package com.capgemini.opleidingsplatform.Application;

import com.capgemini.opleidingsplatform.Data.HttpResultRespository;
import com.capgemini.opleidingsplatform.Data.ItemRepository;
import com.capgemini.opleidingsplatform.Presentation.dto.CodeDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.CodeResultDTO;
import com.capgemini.opleidingsplatform.Presentation.dto.ItemDTO;
import com.capgemini.opleidingsplatform.domain.Item;
import com.capgemini.opleidingsplatform.domain.SubCategory;
import com.capgemini.opleidingsplatform.domain.exception.CategoryNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final SubCategoryService subCategoryService;

    private HttpResultRespository httpResultRespository = new HttpResultRespository();

    public ItemService(ItemRepository itemRepository, SubCategoryService subCategoryService) {
        this.itemRepository = itemRepository;
        this.subCategoryService = subCategoryService;
    }
    public CodeResultDTO createResultItem(CodeDTO dto) throws JsonProcessingException {
       return httpResultRespository.makePostRequest(dto.getCode(), dto.getTime());
    }
    public String createItem (ItemDTO dto) throws CategoryNotFoundException {
        try {
            this.findByName(dto.getName());
            throw new CategoryNotFoundException("An item with this name already exists!");
        } catch(CategoryNotFoundException ex){
            Item item = ItemByDTO(dto);
            item = itemRepository.save(item);
            return item.getName();
        }
    }

    public Item updateItem(ItemDTO dto) throws CategoryNotFoundException {
        Item item = itemRepository.findByItemName(dto.getName())
                .orElseThrow(() -> new CategoryNotFoundException("item was not found !"));
        item.setName(dto.getName());
        item.setDescription(dto.getDescription());
        item.setStable(dto.getStable());
        item.setInplace(dto.getInplace());
        item.setCode(dto.getCode());
        Item updated = itemRepository.save(item);
        return updated;
    }

    public Item deleteItem(String name) throws CategoryNotFoundException {
        Item item = itemRepository.findByItemName(name).orElseThrow(() -> new CategoryNotFoundException("category was not found !"));
        itemRepository.delete(item);
        return item;
    }

    public Item findByName(String name) throws CategoryNotFoundException {
        Item item = itemRepository.findByItemName(name).orElseThrow(() -> new CategoryNotFoundException("Airport was not found !"));
        return item;
    }
    public Item findById(UUID id) throws CategoryNotFoundException {
        Item item = itemRepository.findByItemId(id).orElseThrow(() -> new CategoryNotFoundException("item was not found !"));
        return item;
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();
        return items;
    }





    public Item ItemByDTO(ItemDTO dto) throws CategoryNotFoundException {
        UUID id = UUID.fromString(dto.getSubCategoryId());
        SubCategory subCategory = subCategoryService.findById(id);
        return new Item(dto.getName(), dto.getDescription(), dto.getCode(),subCategory, dto.getInplace(), dto.getStable());
    }

}

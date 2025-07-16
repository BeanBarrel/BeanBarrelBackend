package com.zeezaglobal.BeanBarrelBackend.Controllers;

import com.zeezaglobal.BeanBarrelBackend.DTO.ItemDTO;
import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import com.zeezaglobal.BeanBarrelBackend.Entities.Item;
import com.zeezaglobal.BeanBarrelBackend.Repositories.GroupRepository;
import com.zeezaglobal.BeanBarrelBackend.Repositories.ItemRepository;
import com.zeezaglobal.BeanBarrelBackend.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepo;

    @Autowired
    private GroupRepository groupRepo;

    @GetMapping
    public List<ItemDTO> getAllItems() {
        return itemRepo.findAll()
                .stream()
                .map(Mapper::toItemDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ItemDTO getItemById(@PathVariable int id) {
        return itemRepo.findById(id)
                .map(Mapper::toItemDTO)
                .orElse(null);
    }

    @PostMapping("/group/{groupId}")
    public ItemDTO createItem(@PathVariable int groupId, @RequestBody ItemDTO itemDTO) {
        Group group = groupRepo.findById(groupId).orElse(null);
        if (group != null) {
            Item item = Mapper.toItemEntity(itemDTO);
            item.setGroup(group);
            Item saved = itemRepo.save(item);
            return Mapper.toItemDTO(saved);
        }
        return null;
    }

    @PutMapping("/{id}")
    public ItemDTO updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        return itemRepo.findById(id)
                .map(existingItem -> {
                    existingItem.setItemName(itemDTO.getItemName());
                    existingItem.setItemDescription(itemDTO.getItemDescription());
                    existingItem.setItemPrice(itemDTO.getItemPrice());
                    Item updated = itemRepo.save(existingItem);
                    return Mapper.toItemDTO(updated);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemRepo.deleteById(id);
    }
}
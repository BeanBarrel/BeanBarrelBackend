package com.zeezaglobal.BeanBarrelBackend.Utils;

import com.zeezaglobal.BeanBarrelBackend.DTO.GroupDTO;
import com.zeezaglobal.BeanBarrelBackend.DTO.ItemDTO;
import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import com.zeezaglobal.BeanBarrelBackend.Entities.Item;

import java.util.stream.Collectors;

public class Mapper {

    public static GroupDTO toGroupDTO(Group group) {
        GroupDTO dto = new GroupDTO();
        dto.setGroupId(group.getGroupId());
        dto.setGroupName(group.getGroupName());

        if (group.getItems() != null) {
            dto.setItems(group.getItems().stream()
                    .map(Mapper::toItemDTO)
                    .collect(Collectors.toList()));
        }

        return dto;
    }

    public static ItemDTO toItemDTO(Item item) {
        ItemDTO dto = new ItemDTO();
        dto.setItemId(item.getItemId());
        dto.setItemName(item.getItemName());
        dto.setItemDescription(item.getItemDescription());
        dto.setItemPrice(item.getItemPrice());
        return dto;
    }

    public static Item toItemEntity(ItemDTO dto) {
        Item item = new Item();
        item.setItemName(dto.getItemName());
        item.setItemDescription(dto.getItemDescription());
        item.setItemPrice(dto.getItemPrice());
        return item;
    }

    public static Group toGroupEntity(GroupDTO dto) {
        Group group = new Group();
        group.setGroupName(dto.getGroupName());
        // skipping items, add separately if needed
        return group;
    }
}

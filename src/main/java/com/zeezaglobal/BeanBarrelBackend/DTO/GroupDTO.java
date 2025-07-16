package com.zeezaglobal.BeanBarrelBackend.DTO;

import java.util.List;

public class GroupDTO {
    private int groupId;
    private String groupName;
    private List<ItemDTO> items;

    // Getters and setters

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }
}

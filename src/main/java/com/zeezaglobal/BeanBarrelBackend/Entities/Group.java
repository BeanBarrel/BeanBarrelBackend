package com.zeezaglobal.BeanBarrelBackend.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "group_table")
public class Group {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int groupId;

        @Column(name = "group_name")
        private String groupName;

        @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
        private List<Item> items;

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

        public List<Item> getItems() {
                return items;
        }

        public void setItems(List<Item> items) {
                this.items = items;
        }
}
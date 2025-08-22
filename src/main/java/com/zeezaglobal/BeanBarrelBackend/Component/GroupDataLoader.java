package com.zeezaglobal.BeanBarrelBackend.Component;

import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import com.zeezaglobal.BeanBarrelBackend.Repositories.GroupRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GroupDataLoader {

    @Autowired
    private GroupRepository groupRepository;

/*    @PostConstruct
    public void loadGroups() {
        List<Group> groups = Arrays.asList(
                createGroup("HOT BEV"),
                createGroup("HOT BEV SPL"),
                createGroup("ICED BEV"),
                createGroup("ICED BEV SPL"),
                createGroup("COLD COFFEE"),
                createGroup("COFFEE FRAPPE"),
                createGroup("AFFAGATO"),
                createGroup("MOJITTO"),
                createGroup("CRUSHERS"),
                createGroup("NONCOFFEE FRAPPE"),
                createGroup("POPCORN"),
                createGroup("POPSICLE"),
                createGroup("SNACKS")
        );

        groupRepository.saveAll(groups);
        System.out.println("Groups inserted successfully.");
    }*/

    private Group createGroup(String name) {
        Group group = new Group();
        group.setGroupName(name);
        return group;
    }
}

package com.zeezaglobal.BeanBarrelBackend.Controllers;

import com.zeezaglobal.BeanBarrelBackend.DTO.GroupDTO;
import com.zeezaglobal.BeanBarrelBackend.Entities.Group;
import com.zeezaglobal.BeanBarrelBackend.Repositories.GroupRepository;
import com.zeezaglobal.BeanBarrelBackend.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

    @Autowired
    private GroupRepository groupRepo;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupRepo.findAll()
                .stream()
                .map(Mapper::toGroupDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public GroupDTO getGroupById(@PathVariable int id) {
        return groupRepo.findById(id)
                .map(Mapper::toGroupDTO)
                .orElse(null);
    }

    @PostMapping
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        Group group = Mapper.toGroupEntity(groupDTO);
        Group savedGroup = groupRepo.save(group);
        return Mapper.toGroupDTO(savedGroup);
    }

    @PutMapping("/{id}")
    public GroupDTO updateGroup(@PathVariable int id, @RequestBody GroupDTO groupDTO) {
        return groupRepo.findById(id)
                .map(existingGroup -> {
                    existingGroup.setGroupName(groupDTO.getGroupName());
                    Group updatedGroup = groupRepo.save(existingGroup);
                    return Mapper.toGroupDTO(updatedGroup);
                })
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteGroup(@PathVariable int id) {
        groupRepo.deleteById(id);
    }
}
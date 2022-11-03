package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.mapper.RoleMapper;
import com.cydeo.repository.RoleRepository;
import com.cydeo.dto.RoleDTO;
import com.cydeo.entity.Role;
import com.cydeo.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Override
    public List<RoleDTO> listAllRoles() {
        //controller called this method and requesting all roledtos so it can show in the drop down in the ui
        //need to make a call to db and get all the roles from table so query?
        //go to repo and find a service which give me roles from db

       List<Role> roleList=roleRepository.findAll(); //this is a drive query

        //i have role entities from db so we need to convert to roledto using our modelmapper imported class
        //i already have a class called rolemapper and will inject and then call the method for this

       return roleList.stream().map(roleMapper::convertToDto).collect(Collectors.toList());
        //:: is a method reference we could also use the lambda

    }

    @Override
    public RoleDTO findById(Long id) {
        return roleMapper.convertToDto(roleRepository.findById(id).get());
    }



}

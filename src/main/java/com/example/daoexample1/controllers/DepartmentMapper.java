package com.example.daoexample1.controllers;

import com.example.daoexample1.models.DepartmentDto;
import com.example.daoexample1.models.DepartmentModel;


public class DepartmentMapper {
    // convert department jpa entity into department dto
    public static DepartmentDto mapToDepartmentDto(DepartmentModel department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    // convert department dto into department jpa entity
    public static DepartmentModel mapToDepartment(DepartmentDto departmentDto){
        return new DepartmentModel(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}

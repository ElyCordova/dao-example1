package com.example.daoexample1.services;

import lombok.AllArgsConstructor;
import com.example.daoexample1.models.DepartmentDto;
import com.example.daoexample1.models.DepartmentModel;
import com.example.daoexample1.exception.ResourceNotFoundException;
import com.example.daoexample1.controllers.DepartmentMapper;
import com.example.daoexample1.repositories.DepartmentJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentJpaRepository departmentJpaRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        DepartmentModel department = DepartmentMapper.mapToDepartment(departmentDto);
        DepartmentModel savedDepartment = departmentJpaRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartment(Long departmentId) {
        return null;
    }

    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {
        DepartmentModel department = departmentJpaRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<DepartmentModel> departments = departmentJpaRepository.findAll();
        return departments.stream().map(DepartmentMapper::mapToDepartmentDto)
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {

        DepartmentModel department = departmentJpaRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id:"+ departmentId)
        );

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());

        DepartmentModel savedDepartment = departmentJpaRepository.save(department);

        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        departmentJpaRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exists with a given id: " + departmentId)
        );

        departmentJpaRepository.deleteById(departmentId);
    }
}
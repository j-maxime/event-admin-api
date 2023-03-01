package com.services;

import com.dtos.AdminDto;

import java.util.List;

public interface AdminService {
    /**
     * Sauve a dog
     */
    AdminDto saveAdmin(AdminDto adminDto);

    /**
     * Get a dog by it's id
     */
    AdminDto getAdminById(Long adminId);

    /**
     * Delete a dog by it's id
     */
    boolean deleteAdmin(Long adminId);

    /**
     * Get all the dogs
     */
    List<AdminDto> getAllAdmin();


    public boolean loginAdmin(AdminDto AdminDto);


}

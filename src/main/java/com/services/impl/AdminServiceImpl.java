package com.services.impl;

import com.dtos.AdminDto;
import com.entities.Admin;
import com.repositories.AdminRepository;
import com.services.AdminService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private final AdminRepository AdminRepository;

    public AdminServiceImpl(AdminRepository AdminRepository){
        this.AdminRepository = AdminRepository;
    }

    @Override
    public AdminDto saveAdmin(AdminDto AdminDto) {
        // Converts the dto to the admin entity
        Admin admin = adminDtoToEntity(AdminDto);

        // Save the dog entity
        admin = AdminRepository.save(admin);
        // Return the new dto
        return adminEntityToDto(admin);
    }

    @Override
    public AdminDto getAdminById(Long adminId) {
        Admin admin = AdminRepository.findById(adminId).orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        return adminEntityToDto(admin);
    }

    @Override
    public boolean deleteAdmin(Long dogId) {
        AdminRepository.deleteById(dogId);
        return true;
    }

    @Override
    public List<AdminDto> getAllAdmin() {
        List<AdminDto> adminDtos = new ArrayList<>();
        List<Admin> admin = AdminRepository.findAll();
        admin.forEach(adm -> {
            adminDtos.add(adminEntityToDto(adm));
        });
        return adminDtos;
    }

    /**
     * Map dog dto to dog entity
     */
    private AdminDto adminEntityToDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setId(admin.getId());
        adminDto.setEmail(admin.getEmail());
        adminDto.setPassword(admin.getPassword());
        //dogDto.setId(dog.getId());
        //dogDto.setName(dog.getName());
        //dogDto.setRace(dog.getRace());
        return adminDto;
    }

    /**
     * Map dog entity to dog dto
     */
    private Admin adminDtoToEntity(AdminDto adminDto){
        Admin admin = new Admin();
        admin.setId(adminDto.getId());
        admin.setEmail(adminDto.getEmail());
        admin.setPassword(adminDto.getPassword());
        //admin.setName(dogDto.getName());
        //admin.setId(dogDto.getId());
        //admin.setRace(dogDto.getRace());
        return admin;
    }

    /*
    public int getAdminByName(String adminName){

        //Admin admin = AdminRepository.findByEmail(adminName).orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        //return adminEntityToDto(admin);
        return 1;
    }

     */


    public boolean loginAdmin(AdminDto AdminDto){
        // get adminBy EMAIL and PWD
        String passwd= AdminDto.getPassword();
        String email= AdminDto.getEmail();
        Long nb_count = AdminRepository.countByEmailAndPassword(email, passwd); //.orElseThrow(() -> new EntityNotFoundException("Admin not found"));
        //if( admin.getId() != null){ return true;}
        return nb_count > 0;

    }


}

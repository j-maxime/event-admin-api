package com.controllers;

import com.dtos.AdminDto;
import com.util.JwtTokenManager;
import com.util.JwtUtil;
import com.util.impl.JwtUtilImpl;
import org.springframework.web.bind.annotation.*;

import com.services.impl.AdminServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
	
	private final AdminServiceImpl adminService;

	public AdminController(AdminServiceImpl adminService) {
		this.adminService = adminService;
	}

	/**
	 * <p>Get all dogs in the system</p>
	 * @return List<AdminDto>
	 */
	@GetMapping
	public List<AdminDto> getAdmins() {
		return adminService.getAllAdmin();
	}

	/**
	 * Method to get the dog based on the ID
	 */
	@GetMapping("/{id}")
	public AdminDto getAdmin(@PathVariable Long id){
		return adminService.getAdminById(id);
	}

	/**
	 * Create a new Dog in the system
	 */
	@PostMapping
	public AdminDto saveAdmin(final @RequestBody AdminDto adminDto){

		System.out.printf(adminDto.getEmail());
		return adminService.saveAdmin(adminDto);
	}

	/**
	 * Delete a dog by it's id
	 */
	@DeleteMapping("/{id}")
	public Boolean deleteAdmin(@PathVariable Long id){
		return adminService.deleteAdmin(id);
	}

	@PostMapping("/login")
	public Boolean loginAdmin(final @RequestBody AdminDto adminDto){
		System.out.println("it check the login : \n");
		return adminService.loginAdmin(adminDto);
	}

	@GetMapping("/token")
	public String getToken(){
		String secretkey="";
		//JwtUtil token = new JwtUtilImpl("cenestpasuddskjdsjdskjsdkjdsjdsjkjdskjkjdkjdskjdskjsdjkjdskjdskjdskjdskjdskjnebonneidee", 10000);
		long minute = 60000;

		return JwtTokenManager.generateToken("test.email", minute * 30 );
		//return null;
		//return token.generateToken("test@gmail.com");
	}

	@GetMapping("/tokenIsValid")
	public Boolean tokenIsValid(@RequestBody String token){
		return JwtTokenManager.validateToken(token);
	}
	
}

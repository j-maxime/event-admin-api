package com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="t_admin_adm")
public class Admin {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="adm_id")
	private Long id;
	@Column(name="adm_email")
	private String email;
	@Column(name="adm_mdp")
	private String password;
	
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.dtos;

/**
 *
 * @author VGRCAORT
 */
public class UsuarioDto {
	private String userId;
	private String pass;

	public UsuarioDto(String userId, String pass) {
		this.userId = userId;
		this.pass = pass;
	}

	public String getUserId() {
		return userId;
	}

	public String getPass() {
		return pass;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}

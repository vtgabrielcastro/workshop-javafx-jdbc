package model.services;

import java.util.ArrayList;
import java.util.List;

import model.entities.Departamento;

public class DepartamentoServices {
	
	public List<Departamento> findAll(){
		List<Departamento> list = new ArrayList<>();
		list.add(new Departamento(1, "Books"));
		list.add(new Departamento(2, "Computers"));
		list.add(new Departamento(3, "Electronics"));
		return list;
	}
}

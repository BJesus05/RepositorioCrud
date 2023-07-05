package com.crudV2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudV2.interfaceServices.InterfaceExistenciasService;
import com.crudV2.interfaces.InterfaceExistencias;
import com.crudV2.modelo.Existencia;
@Service
public class ExistenciasService implements InterfaceExistenciasService{
	@Autowired
	private InterfaceExistencias data;
	@Override
	public List<Existencia> listar() {
			// TODO Auto-generated method stub
			return (List<Existencia>)data.findAll();
	}

	@Override
	public Optional<Existencia> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int save(Existencia existencia) {
		int respuesta = 0;
		Existencia existenciaResponse=data.save(existencia);
		if (!existenciaResponse.equals(null)) {
			respuesta = 1;
		}
		return respuesta;
	}

	@Override
	public void delete (int id) {
		data.deleteById(id);
	}

}

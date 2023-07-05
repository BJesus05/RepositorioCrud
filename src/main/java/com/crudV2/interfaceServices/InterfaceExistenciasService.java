package com.crudV2.interfaceServices;

import java.util.List;
import java.util.Optional;

import com.crudV2.modelo.Existencia;


public interface InterfaceExistenciasService {
	public List<Existencia> listar();
	public Optional<Existencia>listarId(int id);
	public int save(Existencia existencia);
	public void delete(int id);

}

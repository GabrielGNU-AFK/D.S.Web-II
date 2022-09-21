package com.idat.SetiembreIIIE.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.idat.SetiembreIIIE.model.Producto;

@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	List<Producto> almacenamiento=new ArrayList<>();
	
	@Override
	public void guardar(Producto producto) {
		almacenamiento.add(producto);

	}

	@Override
	public void actualizar(Producto producto) {
		Producto existe= obtener(producto.getIdProducto());
		eliminar(existe.getIdProducto());
		almacenamiento.add(producto);

	}

	@Override
	public void eliminar(Integer id) {
		Producto existe= obtener(id);
		almacenamiento.remove(existe);
	}

	@Override
	public Producto obtener(Integer id) {
		/*
		for(Producto producto: almacenamiento) {
			if(producto.getIdProducto()==id) {
				return producto;
			}
		}
		return null;
		*/
		
		return almacenamiento.stream().filter(p->p.getIdProducto()==id).findFirst().orElse(null);
	}

	@Override
	public List<Producto> listar() {
		// TODO Auto-generated method stub
		return almacenamiento;
	}

}

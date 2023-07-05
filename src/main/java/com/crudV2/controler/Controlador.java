package com.crudV2.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crudV2.interfaceServices.InterfaceExistenciasService;
import com.crudV2.modelo.Existencia;



import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private InterfaceExistenciasService service;
	@GetMapping("/")
	public String index(Model model) {
		return "inicio.html";
	};
		
	@GetMapping("/listar")
	public String listar(Model model) {
		
		List<Existencia>existencia = service.listar();
		model.addAttribute("existencia",existencia);
		return "index";
	};
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("existencia", new Existencia());
		return "formulario";
	};
	
	@PostMapping("/savee")
	public String save(Existencia existencia,Model model) {
		System.out.println("Exi:" + existencia);
		service.save(existencia);
		return "redirect:/listar";
	};
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Existencia>existencia=service.listarId(id);
		model.addAttribute("existencia",existencia);
		return "formulario";
	};
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);		
		 return "redirect:/listar";
	};
	
	@GetMapping("/generarPdf")
	public void generarPDF(HttpServletResponse response) throws Exception {
	    List<Existencia> existencia = service.listar();  


	    response.setContentType("application/pdf");
	    response.setHeader("Content-Disposition", "attachment; filename=\"existencia.pdf\"");


	    Document document = new Document();
	    PdfWriter.getInstance(document, response.getOutputStream());


	    
	    document.open();


	    PdfPTable table = new PdfPTable(5); 
	    
	    table.addCell("ID");
	    table.addCell("Cantidad");
	    table.addCell("ID Producto");
	    table.addCell("Fecha de Entrega");
	    table.addCell("Fecha de Salida");


	    for (Existencia e : existencia) {
	        table.addCell(String.valueOf(e.getId()));
	        table.addCell(String.valueOf(e.getCantidad()));
	        table.addCell(String.valueOf(e.getIdProducto()));
	        table.addCell(String.valueOf(e.getFechaEntrega()));
	        table.addCell(String.valueOf(e.getFechaSalida()));
	    }

	    
	    document.add(table);

	    document.close();
	    
	    
	}
	
	
}

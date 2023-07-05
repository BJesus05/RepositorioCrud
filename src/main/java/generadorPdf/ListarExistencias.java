package generadorPdf;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.crudV2.modelo.Existencia;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("redirect:/listar")
public class ListarExistencias extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		@SuppressWarnings("unchecked")
		List<Existencia>existencia = (List<Existencia>) model.get("existencia"); 
		
		
		PdfPTable tablaExistencia = new PdfPTable(5);
		
		existencia.forEach(listadoExistencia ->{
			
			tablaExistencia.addCell(String.valueOf(listadoExistencia.getId()));
			tablaExistencia.addCell(String.valueOf(listadoExistencia.getCantidad()));
			tablaExistencia.addCell(String.valueOf(listadoExistencia.getIdProducto()));
			tablaExistencia.addCell(String.valueOf(listadoExistencia.getFechaEntrega()));
			tablaExistencia.addCell(String.valueOf(listadoExistencia.getFechaSalida()));



			
		});
		document.add(tablaExistencia);
	}


}

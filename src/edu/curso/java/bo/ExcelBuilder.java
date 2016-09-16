package edu.curso.java.bo;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;


/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * @author www.codejava.net
 *
 */
@SuppressWarnings("deprecation")
public class ExcelBuilder extends AbstractExcelView {
	
	@Override
    protected void buildExcelDocument(Map<String, Object> model,
        HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
        throws Exception {
	    // get data model which is passed by the Spring container
		Proyecto proyecto = (Proyecto) model.get("proyecto");
	    
		List<Tarea> tareas = proyecto.getTareas();
	     
	    // create a new Excel sheet
	    HSSFSheet sheet = workbook.createSheet("Proyecto "+proyecto.getNombre());
	    sheet.setDefaultColumnWidth(18);
	     
	    // create style for header cells
	    CellStyle style = workbook.createCellStyle();
	    CellStyle contStyle = workbook.createCellStyle();
	    Font font = workbook.createFont();
	    font.setFontName("Arial");
	    style.setFillForegroundColor(HSSFColor.GREEN.index);
	    style.setFillPattern(CellStyle.SOLID_FOREGROUND);
	    font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	    font.setColor(HSSFColor.WHITE.index);
	    style.setFont(font);
	    style.setAlignment(CellStyle.ALIGN_CENTER);
	    style.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
	    style.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
	    style.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
	    style.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
	     
	    contStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
	    contStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
	    contStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
	    contStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
	    
	    // create header row
	    HSSFRow header = sheet.createRow(0);
	     
	    header.createCell(0).setCellValue("Id");
	    header.getCell(0).setCellStyle(style);
	    
	    header.createCell(1).setCellValue("Descripcion");
	    header.getCell(1).setCellStyle(style);
	     
	    header.createCell(2).setCellValue("Nombre");
	    header.getCell(2).setCellStyle(style);
	    
	    header.createCell(3).setCellValue("Usuario Principal");
	    header.getCell(3).setCellStyle(style);
	    
	    header.createCell(4).setCellValue("Fecha de Alta");
	    header.getCell(4).setCellStyle(style);
	    
	    header.createCell(5).setCellValue("Horas Estimadas");
	    header.getCell(5).setCellStyle(style);
	    
        HSSFRow aRow = sheet.createRow(1);
        aRow.createCell(0).setCellValue(proyecto.getId());
        aRow.getCell(0).setCellStyle(contStyle);
        aRow.createCell(1).setCellValue(proyecto.getDescripcion());
        aRow.getCell(1).setCellStyle(contStyle);
        aRow.createCell(2).setCellValue(proyecto.getNombre());
        aRow.getCell(2).setCellStyle(contStyle);
        aRow.createCell(3).setCellValue(proyecto.getUsuarioPrincipal().getNombreCompleto());
        aRow.getCell(3).setCellStyle(contStyle);
        aRow.createCell(4).setCellValue(new SimpleDateFormat("dd-mm-yyyy").format(proyecto.getFechaAlta()));
        aRow.getCell(4).setCellStyle(contStyle);
        aRow.createCell(5).setCellValue(proyecto.getTiempoEstimado());
        aRow.getCell(5).setCellStyle(contStyle);
        
        HSSFRow headerUsers = sheet.createRow(3);
        
        headerUsers.createCell(0).setCellValue("Usuarios");
        headerUsers.getCell(0).setCellStyle(style);
        
        
        if(!proyecto.getUsuarios().isEmpty()){
        	List<Usuario> usuarios = proyecto.getUsuarios();
        	int i=1;
        	for(Usuario usuario : usuarios){
        		headerUsers.createCell(i).setCellValue(usuario.getNombreCompleto());
        		headerUsers.getCell(i).setCellStyle(contStyle);
        		i++;
            }
        }
        
        
        header = sheet.createRow(5);
	     
	    header.createCell(0).setCellValue("Id");
	    header.getCell(0).setCellStyle(style);
	    
	    header.createCell(1).setCellValue("Titulo");
	    header.getCell(1).setCellStyle(style);
	     
	    header.createCell(2).setCellValue("Duracion Estimada");
	    header.getCell(2).setCellStyle(style);
	    
	    header.createCell(3).setCellValue("Descripción");
	    header.getCell(3).setCellStyle(style);
	    
	    header.createCell(4).setCellValue("Estado");
	    header.getCell(4).setCellStyle(style);
	    
	    header.createCell(5).setCellValue("Prioridad");
	    header.getCell(5).setCellStyle(style);
        
        int rowCount = 6;
	         
	        for (Tarea aTarea : tareas) {
	            HSSFRow tRow = sheet.createRow(rowCount++);
	            tRow.createCell(0).setCellValue(aTarea.getId());
	            tRow.getCell(0).setCellStyle(contStyle);
	            tRow.createCell(1).setCellValue(aTarea.getTitulo());
	            tRow.getCell(1).setCellStyle(contStyle);
	            tRow.createCell(2).setCellValue(aTarea.getDuracionEstimada());
	            tRow.getCell(2).setCellStyle(contStyle);
	            tRow.createCell(3).setCellValue(aTarea.getDescripcion());
	            tRow.getCell(3).setCellStyle(contStyle);
	            
	            if(aTarea.getEstado()){
	            	tRow.createCell(4).setCellValue("En Curso");
	            	tRow.getCell(4).setCellStyle(contStyle);
	            }
	            else{
	            	tRow.createCell(4).setCellValue("Completado");
	            	tRow.getCell(4).setCellStyle(contStyle);
	            }
	            
	            if(aTarea.getPrioridad()==1){
	            	tRow.createCell(5).setCellValue("Alta");
	            	tRow.getCell(5).setCellStyle(contStyle);
	            }
	            else if (aTarea.getPrioridad()==2){
	            	tRow.createCell(5).setCellValue("Media");
	            	tRow.getCell(5).setCellStyle(contStyle);
	            }
	            else{
	            	tRow.createCell(5).setCellValue("Baja");
	            	tRow.getCell(5).setCellStyle(contStyle);
	            }
	        }
	    }
 
}

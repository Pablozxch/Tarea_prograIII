/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.services;

import cr.ac.una.tareaprogra3.models.*;
import cr.ac.una.tareaprogra3.utils.*;
import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author jp015
 */
public class RegistroService
{

    public Respuesta getAll()
    {
        try
        {
            List<RegistroClienteDto> registtroClienteDto = new ArrayList<>();
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            List<RegistroDto> emp = port.regtodo();
            emp.forEach(empDto ->
            {

                registtroClienteDto.add(new RegistroClienteDto(empDto));
            });
            registtroClienteDto.forEach(t ->
            {
                System.out.println("Los valores del del cliente en sus registros on " + t.toString());
            });
            return new Respuesta(true , "" , "" , "Registro" , registtroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta getRegistrobyid(Long id)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto emp = port.getRegistro(id);
            return new Respuesta(true , "" , "" , "Registro" , new RegistroClienteDto(emp));
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta getRegistrosfindByFolio(String folioaBuscar)
    {
        try
        {
            List<RegistroClienteDto> registtroClienteDto = new ArrayList<>();
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            List<RegistroDto> emp = port.registroFolio(folioaBuscar);
            emp.forEach(empDto ->
            {

                registtroClienteDto.add(new RegistroClienteDto(empDto));
            });
            return new Respuesta(true , "" , "" , "Registro" , registtroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta saveRegistro(RegistroClienteDto registroClienteDto , EmpleadoClienteDto emp)
    {
        try
        {

            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto reg = registroClienteDto.getRegistroToService(emp);
            port.saveRegistro(reg);
            return new Respuesta(true , "" , "" , "user" , reg);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta saveRegistrobyid(RegistroClienteDto registroClienteDto)
    {
        try
        {

            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            RegistroDto reg = new RegistroDto();
            reg = registroClienteDto.getRegistroToService();
            System.out.println("El valor a gurdar es " + reg.getEmpId());
            port.saveRegistro(reg);
            return new Respuesta(true , "" , "" , "user" , reg);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error gurdando el dato." , "getUser " + ex.getMessage());
        }
    }

    public Respuesta eliminarRegistro(RegistroClienteDto registroClienteDto)
    {

        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            port.deleteRegistro(registroClienteDto.getId());
            return new Respuesta(true , "" , "" , "user" , registroClienteDto);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al eliminar registro" , "deleteReg " + ex.getMessage());
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void generarExcel(List<RegistroClienteDto> lista)
    {
        try
        {
            System.out.println("GENERANDO EXEL");
            Workbook workbook = new XSSFWorkbook();
            Sheet sh = workbook.createSheet("Registros");
            String[] columnHeadings =
            {
                "Empleado Folio" , "Fecha Entrada" , "Fecha Salida" , "Completo/Incompleto"
            };
            //BACKGORUND COLOR 
            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setFontHeightInPoints((short) 12);
            headerFont.setColor(IndexedColors.WHITE.index);
            //Create a CellStyle with the font
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setAlignment(HorizontalAlignment.JUSTIFY);
            headerStyle.setFont(headerFont);
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
            //CREATE THE HEADER ROW
            Row headerRow = sh.createRow(0);
            for(int i = 0; i < columnHeadings.length; i++)
            {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columnHeadings[i]);
                cell.setCellStyle(headerStyle);
            }
            //FILL DATA

            CreationHelper creationHelper = workbook.getCreationHelper();
            //ESTILO DEL NORMAL PAR
            CellStyle styleP = workbook.createCellStyle();
            styleP.setAlignment(HorizontalAlignment.CENTER);
            styleP.setBorderTop(BorderStyle.MEDIUM);
            styleP.setBorderBottom(BorderStyle.MEDIUM);
            styleP.setBorderLeft(BorderStyle.MEDIUM);
            styleP.setBorderRight(BorderStyle.MEDIUM);
            styleP.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            styleP.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
            styleP.setVerticalAlignment(VerticalAlignment.CENTER);
            styleP.setWrapText(true);
            //ESTILO DEL NORMAL PAR
            //ESTILO DEL NORMAL IMPAR
            CellStyle styleI = workbook.createCellStyle();
            styleI.setAlignment(HorizontalAlignment.CENTER);
            styleI.setBorderTop(BorderStyle.MEDIUM);
            styleI.setBorderBottom(BorderStyle.MEDIUM);
            styleI.setBorderLeft(BorderStyle.MEDIUM);
            styleI.setBorderRight(BorderStyle.MEDIUM);
            styleI.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            styleI.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
            styleI.setVerticalAlignment(VerticalAlignment.CENTER);
            styleI.setWrapText(true);
            //ESTILO DEL NORMAL IMPAR
            //ESTILO DE LA FECHA PAR
            CellStyle dateStyleP = workbook.createCellStyle();
            dateStyleP.setBorderTop(BorderStyle.MEDIUM);
            dateStyleP.setBorderBottom(BorderStyle.MEDIUM);
            dateStyleP.setBorderLeft(BorderStyle.MEDIUM);
            dateStyleP.setBorderRight(BorderStyle.MEDIUM);
            dateStyleP.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            dateStyleP.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
            dateStyleP.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
            dateStyleP.setAlignment(HorizontalAlignment.CENTER);
            dateStyleP.setVerticalAlignment(VerticalAlignment.CENTER);
            //ESTILO DE LA FECHA PAR
            //ESTILO DE LA FECHA IMPAR
            CellStyle dateStyleI = workbook.createCellStyle();
            dateStyleI.setBorderTop(BorderStyle.MEDIUM);
            dateStyleI.setBorderBottom(BorderStyle.MEDIUM);
            dateStyleI.setBorderLeft(BorderStyle.MEDIUM);
            dateStyleI.setBorderRight(BorderStyle.MEDIUM);
            dateStyleI.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
            dateStyleI.setAlignment(HorizontalAlignment.CENTER);
            dateStyleI.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            dateStyleI.setFillForegroundColor(IndexedColors.LIGHT_TURQUOISE.index);
            dateStyleI.setVerticalAlignment(VerticalAlignment.CENTER);
            //ESTILO DE LA FECHA IMPAR
            int rownum = 1;
            for(RegistroClienteDto i : lista)
            {
                Row row = sh.createRow(rownum++);
                CellStyle use = workbook.createCellStyle();
                CellStyle useDate = workbook.createCellStyle();
                if(rownum % 2 == 0)
                {
                    use = styleP;
                    useDate = dateStyleP;
                }
                else
                {
                    use = styleI;
                    useDate = dateStyleI;
                }
                row.createCell(0).setCellValue(i.getEmpId().getFolio());
                row.getCell(0).setCellStyle(use);

                Cell dateCell = row.createCell(1);
                row.getCell(1).setCellStyle(use);
                dateCell.setCellValue(i.getFechaIngreso());
                dateCell.setCellStyle(useDate);

                Cell dateCell2 = row.createCell(2);
                row.getCell(2).setCellStyle(use);
                dateCell2.setCellValue(i.getFechaSalida());
                dateCell2.setCellStyle(useDate);

                row.createCell(3).setCellValue(i.getCompletado());
                row.getCell(3).setCellStyle(use);

            }
            //Autosize columns
            for(int i = 0; i < columnHeadings.length; i++)
            {
                sh.autoSizeColumn(i);
            }

            FileOutputStream fileOut = new FileOutputStream("Registros.xlsx");
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

    public void createlist(RegistroClienteDto reg , Row row)
    {
        Cell cell = row.createCell(0);
        cell.setCellValue(reg.getEmpId().getFolio());

        cell = row.createCell(1);
        cell.setCellValue(reg.getFechaIngreso());

        cell = row.createCell(2);
        cell.setCellValue(reg.getFechaSalida());

        cell = row.createCell(3);
        cell.setCellValue(reg.getCompletado());
    }
}

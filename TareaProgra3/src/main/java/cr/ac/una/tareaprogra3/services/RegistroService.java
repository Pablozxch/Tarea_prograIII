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
import javafx.scene.control.*;
import javafx.stage.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
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
            //ESTILO ROJO TEXTO
            CellStyle RED = workbook.createCellStyle();
            RED.setAlignment(HorizontalAlignment.CENTER);
            RED.setBorderTop(BorderStyle.MEDIUM);
            RED.setBorderBottom(BorderStyle.MEDIUM);
            RED.setBorderLeft(BorderStyle.MEDIUM);
            RED.setBorderRight(BorderStyle.MEDIUM);
            RED.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            RED.setFillForegroundColor(IndexedColors.RED.index);
            RED.setVerticalAlignment(VerticalAlignment.CENTER);
            //ESTILO ROJO TEXTO
            //ESTILO DE LA FECHA PAR
            CellStyle dateStyleP = workbook.createCellStyle();
            dateStyleP.setBorderTop(BorderStyle.MEDIUM);
            dateStyleP.setBorderBottom(BorderStyle.MEDIUM);
            dateStyleP.setBorderLeft(BorderStyle.MEDIUM);
            dateStyleP.setBorderRight(BorderStyle.MEDIUM);
            dateStyleP.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
            dateStyleP.setAlignment(HorizontalAlignment.CENTER);
            dateStyleP.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            dateStyleP.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
            dateStyleP.setVerticalAlignment(VerticalAlignment.CENTER);
            //ESTILO DE LA FECHA PAR
//            FECHA RED
            CellStyle datered = workbook.createCellStyle();
            datered.setBorderTop(BorderStyle.MEDIUM);
            datered.setBorderBottom(BorderStyle.MEDIUM);
            datered.setBorderLeft(BorderStyle.MEDIUM);
            datered.setBorderRight(BorderStyle.MEDIUM);
            datered.setDataFormat(creationHelper.createDataFormat().getFormat("MM/dd/yyyy"));
            datered.setAlignment(HorizontalAlignment.CENTER);
            datered.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            datered.setFillForegroundColor(IndexedColors.RED1.index);
            datered.setVerticalAlignment(VerticalAlignment.CENTER);
//               FECHA RED
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

                    if("I".equals(i.getCompletado()))
                    {
                        use = RED;
                        useDate = datered;
                    }
                    else
                    {
                        use = styleP;
                        useDate = dateStyleP;
                    }
                }
                else
                {

                    if("I".equals(i.getCompletado()))
                    {
                        use = RED;
                        useDate = datered;
                    }
                    else
                    {
                        use = styleI;
                        useDate = dateStyleI;
                    }
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

            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("XLSX" , "*.xlsx"));
            fileChooser.setInitialFileName("*.xlsx");
            File selectedFile = fileChooser.showSaveDialog(new Stage());

            if(selectedFile != null)
            {
                FileOutputStream fileOut = new FileOutputStream(selectedFile.toPath().toString());
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                new Mensaje().show(Alert.AlertType.CONFIRMATION , "Guardado" , "Con exito");

            }

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

    public Respuesta obtenerJAll()
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            byte[] pdfJ = port.jasP();
            return new Respuesta(true , "" , "" , "Registro" , pdfJ);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al obtener registro" , "Registro obteniendo " + ex.getMessage());
        }
    }

    public Respuesta obtenerJEmpF(String Epm)
    {
        try
        {
            SoapWS_Service service = new SoapWS_Service();
            SoapWS port = service.getSoapWSPort();
            byte[] pdfJ = port.jasPFolio(Epm);
            return new Respuesta(true , "" , "" , "Registro" , pdfJ);
        }
        catch(Exception ex)
        {
            return new Respuesta(false , "Error al obtener registro" , "Registro obteniendo " + ex.getMessage());

        }
    }
}

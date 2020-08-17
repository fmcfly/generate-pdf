import java.util.ArrayList;
import java.util.List;

import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Font;
import com.itextpdf.text.BaseColor;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;

public class Principal{
    public static void main(String[] args) {
        List<Boleto> boletos = new ArrayList<Boleto>(); 

        Boleto boleto = new Boleto("A1","Sala 1");
        Boleto boletoDos = new Boleto("A2","Sala 1");

        boletos.add(boleto);
        boletos.add(boletoDos);

        //LLAMAMOS AL MÉTODO STATICO PARA CREAR PDF
        crearPDF(boletos);
    }

    public static void crearPDF(List<Boleto> boletos){
        // Se crea el documento
        Document documento= new Document();
        try{
            // El OutPutStream para el fichero donde crearemos el PDF
            FileOutputStream ficheroPDF = new FileOutputStream("boletos.pdf");    

            //Se asocia el dociumento de OutPutStream
            PdfWriter.getInstance(documento,ficheroPDF);

            //Se abre el documento
            documento.open();
            
            //Parrafo
            Paragraph titulo = new Paragraph("Lista de boletos \n\n",
                FontFactory.getFont("arial",
                    22,
                    Font.BOLD,
                    BaseColor.BLUE
                )
            );

            //añadimos el titulo al dcoumento
            documento.add(titulo);

            // creamos una tabla
            PdfPTable tabla = new PdfPTable(2);
            tabla.addCell("Sala");
            tabla.addCell("Nombre");
            for(Boleto boleto:boletos){
                tabla.addCell(boleto.getSala());
                tabla.addCell(boleto.getNombre());
            }

            documento.add(tabla);
            //Se cierra el documento
            documento.close();
        }catch(FileNotFoundException fnfe){
            System.out.println(fnfe.getMessage());
        }catch(DocumentException de){
            System.out.println(de.getMessage());
        }
        
    }
}
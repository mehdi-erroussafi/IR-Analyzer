/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Controle.PDFManager;
import java.io.IOException;

/**
 *
 * @author Anass
 */
public class allScrap {
    public static void main(String[] args) throws IOException {
        
         PDFManager pdfm =  new PDFManager();
         pdfm.setFilePath("C:/Users/Anass/Downloads/Documents/o2.pdf");
           int netNodes = pdfm.ToText().indexOf("Network Nodes Global Title Number Range(s)");
        //2eme indice
        int MSRN = pdfm.ToText().indexOf("MSRN Number Range(s)");
         System.out.println( pdfm.ToText().subSequence(netNodes+44, MSRN-1).toString());
    }
    }
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import entity.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anass
 */
@ManagedBean
public class NetworkNodeCtrl {

    private String pp = "C:/Users/Anass/Downloads/Documents/o2.pdf";
    private String path;
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //methode pour la lecture du page 2
    public ArrayList<NetworkNodes> ScrapNode() throws IOException {
        //appel de l'objet PDFManager
        PDFManager pdfm = new PDFManager();
        //définir le path
        ArrayList<NetworkNodes> al = new ArrayList<>();
        if(path!=null){
        pdfm.setFilePath(path);
        //l'indice premier
        int netNodes = pdfm.ToText().indexOf("Network Nodes Global Title Number Range(s)");
        //2eme indice
        int MSRN = pdfm.ToText().indexOf("MSRN Number Range(s)");

        //liste pour les données
        
        String[] tabl;
        tabl = pdfm.ToText().subSequence(netNodes + 44, MSRN - 1).toString().split("\n");
        for (int i = 0; i < tabl.length; i++) {
            String[] tabl1 = tabl[i].split(" ");
            NetworkNodes networkNodes = new NetworkNodes();
            networkNodes.setCountryCode(tabl1[0]);
            networkNodes.setNationalDestCode(tabl1[1]);
            networkNodes.setSnRangeStart(tabl1[2]);
            networkNodes.setSnRangeStop(tabl1[3]);
            al.add(networkNodes);

        }
        }
        //retourner la liste
        return al;

    }

    public ArrayList<NumberSeries> ScrapNumberSeries() throws IOException {
        PDFManager pdfm = new PDFManager();
        //définir le path
        pdfm.setFilePath(path);
        //l'indice premier
        int firstIndex = pdfm.ToText().indexOf("Code (MNC)");
        int SecondIndex = pdfm.ToText().indexOf("E. 214 Mobile Global Title (MGT)");

        ArrayList<NumberSeries> numberSerieses = new ArrayList<>();
        String[] tabl;
        tabl = pdfm.ToText().subSequence(firstIndex + 12, SecondIndex).toString().split("\n");
        for (int i = 0; i < tabl.length; i++) {
            NumberSeries ns = new NumberSeries();
            String[] tabl1 = tabl[i].split(" ");
            ns.setMobileCountryCode(tabl1[0]);
            ns.setMobileNetworkCode(tabl1[1]);
            numberSerieses.add(ns);
        }
        return numberSerieses;
    }

    public ArrayList<MobileGT> ScrapMobileGlobalTitle() throws IOException {
        PDFManager pdfm = new PDFManager();
        //définir le path
        pdfm.setFilePath(path);
        //l'indice premier
        int firstIndex = pdfm.ToText().indexOf("MGT (NC)");
        int SecondIndex = pdfm.ToText().indexOf("Does Number Portability apply");
        ArrayList<MobileGT> mgt = new ArrayList<>();
        String[] tabl;
        tabl = pdfm.ToText().subSequence(firstIndex + 10, SecondIndex).toString().split("\n");
        for (int i = 0; i < tabl.length; i++) {
            MobileGT m = new MobileGT();
            String[] tabl1 = tabl[i].split(" ");
            m.setCountryCode(tabl1[0]);
            m.setNetworkCode(tabl1[1]);
            mgt.add(m);
        }
        return mgt;
    }

//    public ArrayList<ListOfApn> ScrapAPN() throws IOException{
//        PDFManager pdfm =  new PDFManager();
//        //définir le path
//        pdfm.setFilePath(path);
//        //l'indice premier
//        int firstIndex = pdfm.ToText().indexOf("MGT (NC)");
//        
//        int SecondIndex = pdfm.ToText().indexOf("Does Number Portability apply");
//    }
}

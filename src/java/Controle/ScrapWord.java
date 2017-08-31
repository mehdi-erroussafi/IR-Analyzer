/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import entity.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

/**
 *
 * @author Anass
 */
@ManagedBean
public class ScrapWord {
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    
    public ArrayList<String> InitInformition(){
         File file = null;
        WordExtractor extractor = null;
        ArrayList<String> list = new ArrayList<>();
        if(path!=null){
        try {
            
            file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            String allDoc = null;
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    allDoc = allDoc + fileData[i];
            }
            String [] tabl;
            tabl = allDoc.split("");
            String doc = null;
            for (int i = 0; i < tabl.length; i++) {
               doc = doc + tabl[i];
            }
            
            int deb = doc.indexOf("Operator name: ");
            int fin = doc.indexOf("(Abbreviated according to ISO 3166):");
            
            list.add((String) doc.subSequence(deb + 17, fin-10));
            list.add((String) doc.subSequence(fin + 36, fin + 40));
            fis.close();
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        }
        return list;
    }
    
    
     public ArrayList<NumberSeries> NumbrSer(){
         File file = null;
        WordExtractor extractor = null;
        ArrayList<NumberSeries> list = new ArrayList<>();
        NumberSeries n = new NumberSeries();
        if(path!=null){
        try {

            file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            String allDoc = null;
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    allDoc = allDoc + fileData[i];
            }
            String [] tabl;
            tabl = allDoc.split("");
            String doc = null;
            for (int i = 0; i < tabl.length; i++) {
               doc = doc + tabl[i];
            }
            
            int deb = doc.indexOf("Mobile Network Code");
            int fin = doc.indexOf("E.214 Mobile Global");
            n.setMobileCountryCode((String) doc.subSequence(deb + 27, deb+30));
            n.setMobileNetworkCode((String) doc.subSequence(deb + 31, deb+32));
            list.add(n);
            fis.close();
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        }
        return list;
    }
     
     public ArrayList<MobileGT> MobileGlob(){
         File file = null;
        WordExtractor extractor = null;
        ArrayList<MobileGT> list = new ArrayList<>();
        MobileGT n = new MobileGT();
        if(path!=null){
        try {

            file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            String allDoc = null;
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    allDoc = allDoc + fileData[i];
            }
            String [] tabl;
            tabl = allDoc.split("");
            String doc = null;
            for (int i = 0; i < tabl.length; i++) {
               doc = doc + tabl[i];
            }
            
            int deb = doc.indexOf("Network Code of MGT ");
            int fin = doc.indexOf("Does Number Portability apply");
            n.setCountryCode((String) doc.subSequence(deb+26, deb+29));
            n.setNetworkCode((String) doc.subSequence(deb + 29, deb+31));
            list.add(n);
            fis.close();
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        }
        return list;
    }
     
     
      public ArrayList<ListOfApn> ApnList(){
         File file = null;
        WordExtractor extractor = null;
        ArrayList<ListOfApn> list = new ArrayList<>();
        ListOfApn n = new ListOfApn();
        if(path!=null){
        try {

            file = new File(path);
            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
            HWPFDocument document = new HWPFDocument(fis);
            extractor = new WordExtractor(document);
            String[] fileData = extractor.getParagraphText();
            String allDoc = null;
            for (int i = 0; i < fileData.length; i++)
            {
                if (fileData[i] != null)
                    allDoc = allDoc + fileData[i];
            }
            String [] tabl;
            tabl = allDoc.split("");
            String doc = null;
            for (int i = 0; i < tabl.length; i++) {
               doc = doc + tabl[i];
            }
            
            int deb = doc.indexOf("APN Operator Identifier");
            int fin = doc.indexOf("Does Number Portability apply");
            n.setId((String) doc.subSequence(deb+27, deb+45));
            list.add(n);
            fis.close();
        } catch (Exception exep) {
            exep.printStackTrace();
        }
        }
        return list;
    }
      
      
}

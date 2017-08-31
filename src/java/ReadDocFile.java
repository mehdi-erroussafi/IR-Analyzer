
import Controle.ScrapWord;
import entity.ApnWeb;
import entity.ListOfApn;
import entity.MobileGT;
import entity.NumberSeries;
import java.io.*;
import java.util.ArrayList;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

public class ReadDocFile {

    public static void main(String[] args) {
//        File file = null;
//        WordExtractor extractor = null;
//        try {
//
//            file = new File("C:\\Users\\Anass\\Desktop\\bo.doc");
//            FileInputStream fis = new FileInputStream(file.getAbsolutePath());
//            HWPFDocument document = new HWPFDocument(fis);
//            extractor = new WordExtractor(document);
//            String[] fileData = extractor.getParagraphText();
//            String allDoc = null;
//            for (int i = 0; i < fileData.length; i++) {
//                if (fileData[i] != null) {
//                    allDoc = allDoc + fileData[i];
//                }
//            }
//            String[] tabl;
//            tabl = allDoc.split("");
//            String doc = null;
//            for (int i = 0; i < tabl.length; i++) {
//                doc = doc + tabl[i];
//            }
//            int deb = doc.indexOf("Operator name: ");
//            int fin = doc.indexOf("(Abbreviated according to ISO 3166):");
//            System.out.println(fin);
//            System.out.println((String) doc.subSequence(deb + 17, fin-10));
//            System.out.println((String) doc.subSequence(fin + 36, fin + 40));
//            fis.close();
//        } catch (Exception exep) {
//            exep.printStackTrace();
//       
    }
}

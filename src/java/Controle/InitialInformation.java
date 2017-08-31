/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import entity.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Anass
 */
@ManagedBean
public class InitialInformation {

    private String path;
    private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //methode pour la lecture du page 2
    public ArrayList<String> Scrap() throws IOException {
        //appel de l'objet PDFManager
        PDFManager pdfm = new PDFManager();
        //définir le path
        ArrayList<String> al = new ArrayList<>();
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int OrgNameIndex = pdfm.ToText().indexOf("Organisation name");
            //2eme indice
            int ContryInIndex = pdfm.ToText().indexOf("Country initials");
            //ajouter les données à la liste
            al.add((String) pdfm.ToText().subSequence(OrgNameIndex + 18, ContryInIndex));
            al.add((String) pdfm.ToText().subSequence(ContryInIndex + 17, ContryInIndex + 21));
        }

        //retourner la liste
        return al;

    }

    public ArrayList<NetworkNodes> ScrapNode() throws IOException {
        //appel de l'objet PDFManager
        PDFManager pdfm = new PDFManager();
        //définir le path
        ArrayList<NetworkNodes> al = new ArrayList<>();
        if (path != null) {
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
        ArrayList<NumberSeries> numberSerieses = new ArrayList<>();
        if (path != null) {
            int firstIndex = pdfm.ToText().indexOf("Code (MNC)");
            int SecondIndex = pdfm.ToText().indexOf("E. 214 Mobile Global Title (MGT)");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 12, SecondIndex).toString().split("\n");
            for (int i = 0; i < tabl.length; i++) {
                NumberSeries ns = new NumberSeries();
                String[] tabl1 = tabl[i].split(" ");
                ns.setMobileCountryCode(tabl1[0]);
                ns.setMobileNetworkCode(tabl1[1]);
                numberSerieses.add(ns);
            }
        }
        return numberSerieses;
    }

    public ArrayList<MobileGT> ScrapMobileGlobalTitle() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<MobileGT> mgt = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("MGT (NC)");
            int SecondIndex = pdfm.ToText().indexOf("Does Number Portability apply");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 10, SecondIndex).toString().split("\n");
            for (int i = 0; i < tabl.length; i++) {
                MobileGT m = new MobileGT();
                String[] tabl1 = tabl[i].split(" ");
                m.setCountryCode(tabl1[0]);
                m.setNetworkCode(tabl1[1]);
                mgt.add(m);
            }
        }
        return mgt;
    }

    public ArrayList<GTPVersion> ScrapGTP() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<GTPVersion> gtp = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("GTP Version");
            int SecondIndex = pdfm.ToText().indexOf("List of Data Service supported");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 13, SecondIndex).toString().split("\n");

            GTPVersion g = new GTPVersion();

            g.setGGSN(tabl[1].toString().split(" ")[1]);
            g.setSGSN(tabl[0].toString().split(" ")[1]);
            gtp.add(g);
        }

        return gtp;
    }

    public ArrayList<ListOfApn> ScrapAPN() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<ListOfApn> apn = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("List of APN Operator Identifiers");
            int SecondIndex = pdfm.ToText().indexOf("List of APN's available for testing and troubleshooting");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 34, SecondIndex).toString().split("\n");
            for (int i = 1; i < tabl.length; i++) {
                String[] tabl1 = tabl[i].split(" ");
                ListOfApn a = new ListOfApn();
                a.setId(tabl1[0]);
                if (tabl1.length >1) {
                    a.setDescreption(tabl1[1]);
                } else {
                    a.setDescreption("N/A");
                }
                if (tabl1.length >1) {
                    a.setExemple(tabl1[2]);
                } else {
                    a.setExemple("N/A");
                }
                apn.add(a);
            }

        }

        return apn;
    }
    
    
    public ArrayList<ApnWeb> ScrapAPNWeb() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<ApnWeb> apnw = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("APN WEB List");
            int SecondIndex = pdfm.ToText().indexOf("APN WAP List");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 14, SecondIndex).toString().split("\n");
            for (int i = 2; i < tabl.length; i++) {
                String[] tabl1 = tabl[i].split(" ");
                ApnWeb aw = new ApnWeb();
                aw.setApn(tabl1[0]);
                aw.setUsername(tabl1[1]);
                aw.setPassword(tabl1[2]);
                aw.setIspDnsPrim(tabl1[3]);
                aw.setIspDnsSecon(tabl1[4]);
                apnw.add(aw);
            }

        }

        return apnw;
    }
    
    
    public ArrayList<IpList> ScrapIP() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<IpList> ip = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("Section ID: 17 (Conditional)");
            int SecondIndex = pdfm.ToText().indexOf("RAI Additional MCC/MNC List");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex +30, SecondIndex).toString().split("\n");
            for (int i = 4; i < tabl.length; i++) {
                String[] tabl1 = tabl[i].split(" ");
                IpList ipp = new IpList();
                ipp.setIPAddressRange(tabl1[0]);
                ip.add(ipp);
            }

        }
        
        return ip;
    }
    
    
    public ArrayList<PmnList> ScrapPMN() throws IOException {
        PDFManager pdfm = new PDFManager();
        ArrayList<PmnList> pmn = new ArrayList<>();
        //définir le path
        if (path != null) {
            pdfm.setFilePath(path);
            //l'indice premier
            int firstIndex = pdfm.ToText().indexOf("DNS server IP addresses and names");
            int SecondIndex = pdfm.ToText().indexOf("List of GRX Providers");

            String[] tabl;
            tabl = pdfm.ToText().subSequence(firstIndex + 34, SecondIndex).toString().split("\n");
            for (int i = 1; i < tabl.length; i++) {
                String[] tabl1 = tabl[i].split(" ");
                PmnList pm = new PmnList();
                pm.setIPAdresses(tabl1[0]);
                pm.setDNSName(tabl1[1]);
                pmn.add(pm);
            }

        }

        return pmn;
    }
}

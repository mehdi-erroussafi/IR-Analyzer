/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Anass
 */
@Entity
public class CoreCsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ArrayList<ListOfApn> listOfApns;
    private ArrayList<ApnWeb> apnWebs;
    private ArrayList<GTPVersion> gtpvs;
    private ArrayList<IpList> ipLists;
    private ArrayList<PmnList> pmnLists;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<ListOfApn> getListOfApns() {
        return listOfApns;
    }

    public void setListOfApns(ArrayList<ListOfApn> listOfApns) {
        this.listOfApns = listOfApns;
    }

    public ArrayList<ApnWeb> getApnWebs() {
        return apnWebs;
    }

    public void setApnWebs(ArrayList<ApnWeb> apnWebs) {
        this.apnWebs = apnWebs;
    }

    public ArrayList<GTPVersion> getGtpvs() {
        return gtpvs;
    }

    public void setGtpvs(ArrayList<GTPVersion> gtpvs) {
        this.gtpvs = gtpvs;
    }

    public ArrayList<IpList> getIpLists() {
        return ipLists;
    }

    public void setIpLists(ArrayList<IpList> ipLists) {
        this.ipLists = ipLists;
    }

    public ArrayList<PmnList> getPmnLists() {
        return pmnLists;
    }

    public void setPmnLists(ArrayList<PmnList> pmnLists) {
        this.pmnLists = pmnLists;
    }

   
    
}

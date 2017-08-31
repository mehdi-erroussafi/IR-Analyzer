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
public class CorePsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private ArrayList<NetworkNodes> networkNodes;
    private ArrayList<MobileGT> mobileGTs;
    private ArrayList<NumberSeries> numberSerieses;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNetworkNodes(ArrayList<NetworkNodes> networkNodes) {
        this.networkNodes = networkNodes;
    }

    public void setMobileGTs(ArrayList<MobileGT> mobileGTs) {
        this.mobileGTs = mobileGTs;
    }

    public void setNumberSerieses(ArrayList<NumberSeries> numberSerieses) {
        this.numberSerieses = numberSerieses;
    }


   
    
}

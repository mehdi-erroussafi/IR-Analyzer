/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;

/**
 *
 * @author Anass
 */
@Entity
public class GTPVersion {
    private String SGSN;
    private String GGSN ;

    public String getSGSN() {
        return SGSN;
    }

    public void setSGSN(String SGSN) {
        this.SGSN = SGSN;
    }

    public String getGGSN() {
        return GGSN;
    }

    public void setGGSN(String GGSN) {
        this.GGSN = GGSN;
    }
    
}

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
public class PmnList {
    private String IPAdresses;
    private String DNSName;

    public String getIPAdresses() {
        return IPAdresses;
    }

    public void setIPAdresses(String IPAdresses) {
        this.IPAdresses = IPAdresses;
    }

    public String getDNSName() {
        return DNSName;
    }

    public void setDNSName(String DNSName) {
        this.DNSName = DNSName;
    }
    
}

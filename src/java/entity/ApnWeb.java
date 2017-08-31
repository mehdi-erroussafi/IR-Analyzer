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
public class ApnWeb {
    private String apn;
    private String username;
    private String password;
    private String ispDnsPrim;
    private String ispDnsSecon;

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIspDnsPrim() {
        return ispDnsPrim;
    }

    public void setIspDnsPrim(String ispDnsPrim) {
        this.ispDnsPrim = ispDnsPrim;
    }

    public String getIspDnsSecon() {
        return ispDnsSecon;
    }

    public void setIspDnsSecon(String ispDnsSecon) {
        this.ispDnsSecon = ispDnsSecon;
    }
    
}

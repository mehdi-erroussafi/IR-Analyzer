/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Anass
 */
@Entity
public class NetworkNodes implements Serializable {
    @Id
    private String countryCode;
    private String NationalDestCode;
    private String snRangeStart;
    private String snRangeStop;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getNationalDestCode() {
        return NationalDestCode;
    }

    public void setNationalDestCode(String NationalDestCode) {
        this.NationalDestCode = NationalDestCode;
    }

    public String getSnRangeStart() {
        return snRangeStart;
    }

    public void setSnRangeStart(String snRangeStart) {
        this.snRangeStart = snRangeStart;
    }

    public String getSnRangeStop() {
        return snRangeStop;
    }

    public void setSnRangeStop(String snRangeStop) {
        this.snRangeStop = snRangeStop;
    }
    
    
}

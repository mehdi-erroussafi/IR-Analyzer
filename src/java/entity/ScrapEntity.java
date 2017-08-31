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
public class ScrapEntity {
    private String organisationName;
    private String counntryInitials;
    private CoreCsEntity coreCsEntity;
    private CorePsEntity corePsEntity;

    public String getOrganisationName() {
        return organisationName;
    }

    public void setOrganisationName(String organisationName) {
        this.organisationName = organisationName;
    }

    public String getCounntryInitials() {
        return counntryInitials;
    }

    public void setCounntryInitials(String counntryInitials) {
        this.counntryInitials = counntryInitials;
    }

    public CoreCsEntity getCoreCsEntity() {
        return coreCsEntity;
    }

    public void setCoreCsEntity(CoreCsEntity coreCsEntity) {
        this.coreCsEntity = coreCsEntity;
    }

    public CorePsEntity getCorePsEntity() {
        return corePsEntity;
    }

    public void setCorePsEntity(CorePsEntity corePsEntity) {
        this.corePsEntity = corePsEntity;
    }
    
    
}

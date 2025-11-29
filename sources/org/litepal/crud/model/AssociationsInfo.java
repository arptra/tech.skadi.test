package org.litepal.crud.model;

import java.lang.reflect.Field;

public class AssociationsInfo {
    private Field associateOtherModelFromSelf;
    private Field associateSelfFromOtherModel;
    private String associatedClassName;
    private int associationType;
    private String classHoldsForeignKey;
    private String selfClassName;

    public boolean equals(Object obj) {
        if (!(obj instanceof AssociationsInfo)) {
            return false;
        }
        AssociationsInfo associationsInfo = (AssociationsInfo) obj;
        if (obj == null || associationsInfo == null || associationsInfo.getAssociationType() != this.associationType || !associationsInfo.getClassHoldsForeignKey().equals(this.classHoldsForeignKey)) {
            return false;
        }
        if (!associationsInfo.getSelfClassName().equals(this.selfClassName) || !associationsInfo.getAssociatedClassName().equals(this.associatedClassName)) {
            return associationsInfo.getSelfClassName().equals(this.associatedClassName) && associationsInfo.getAssociatedClassName().equals(this.selfClassName);
        }
        return true;
    }

    public Field getAssociateOtherModelFromSelf() {
        return this.associateOtherModelFromSelf;
    }

    public Field getAssociateSelfFromOtherModel() {
        return this.associateSelfFromOtherModel;
    }

    public String getAssociatedClassName() {
        return this.associatedClassName;
    }

    public int getAssociationType() {
        return this.associationType;
    }

    public String getClassHoldsForeignKey() {
        return this.classHoldsForeignKey;
    }

    public String getSelfClassName() {
        return this.selfClassName;
    }

    public void setAssociateOtherModelFromSelf(Field field) {
        this.associateOtherModelFromSelf = field;
    }

    public void setAssociateSelfFromOtherModel(Field field) {
        this.associateSelfFromOtherModel = field;
    }

    public void setAssociatedClassName(String str) {
        this.associatedClassName = str;
    }

    public void setAssociationType(int i) {
        this.associationType = i;
    }

    public void setClassHoldsForeignKey(String str) {
        this.classHoldsForeignKey = str;
    }

    public void setSelfClassName(String str) {
        this.selfClassName = str;
    }
}

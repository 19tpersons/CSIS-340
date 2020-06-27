/*
8 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deckpackage.row;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author 19tpe
 */
public class TableRow {
    private final SimpleStringProperty materialName = new SimpleStringProperty("");
    private final SimpleStringProperty materialUnit = new SimpleStringProperty("");
    private final SimpleStringProperty materialPPU = new SimpleStringProperty("");
    private final SimpleStringProperty materialQuantity = new SimpleStringProperty("");
    
    /**
     *
     * @param materialName
     */
    public TableRow(String materialName, String materialUnit, String materialPPU, String materialQuantity) {
        setMaterialName(materialName);
        setMaterialUnit(materialUnit);
        setMaterialPPU(materialPPU);
        setMaterialQuantity(materialQuantity);
    } 
    
    public void setMaterialName(String materialName) {
        this.materialName.set(materialName);
    }
    
    public String getMaterialName() {
        return this.materialName.get();
    }
    
    public void setMaterialUnit(String materialUnit) {
        this.materialUnit.set(materialUnit);
    }
    
    public String getMaterialUnit() {
        return this.materialUnit.get();
    }
    
    public void setMaterialPPU(String materialPPU) {
        this.materialPPU.set(materialPPU);
    }
    
    public String getMaterialPPU() {
        return this.materialPPU.get();
    }
    
    public void setMaterialQuantity(String materialQuantity) {
        this.materialQuantity.set(materialQuantity);
    }
    
    public String getMaterialQuantity() {
        return this.materialQuantity.get();
    }
}

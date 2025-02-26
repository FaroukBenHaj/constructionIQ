package com.example.Stock.Material;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long materialID;

    private String materialName;
    private float cost;

    @Enumerated(EnumType.STRING)
    private  UnitOfMeasure   materialUnit;

    public Long getMaterialID() {
        return materialID;
    }

    public void setMaterialID(Long materialID) {
        this.materialID = materialID;
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public UnitOfMeasure  getMaterialUnit() {
        return materialUnit;
    }

    public void setMaterialUnit(UnitOfMeasure  materialUnit) {
        this.materialUnit = materialUnit;
    }
}

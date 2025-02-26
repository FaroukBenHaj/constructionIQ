package com.example.Stock.Material;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;
    public Optional<Material> findByMaterialName( String materialName ) {
        return materialRepository.findByMaterialName( materialName );
    }
    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterialById(Long id) {
        return materialRepository.findById(id);
    }

    public Material saveMaterial(Material material) {
        return materialRepository.save(material);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }
    public Optional<Material> getMaterialByName(String materialName) {
        return materialRepository.findByMaterialName(materialName);
    }
}

package co.com.personalsoft.micro_materiales.models.service;

import co.com.personalsoft.micro_materiales.models.entity.Material;

import java.util.List;

public interface IMaterialService {

     public List<Material> findAll();
     public Material findById(Long id);
     public Material save(Material material);
     public void deleteMaterial(Long id);
     public Material findByName(String name);
     public void updateQuantity(int cantidad, Long id);

}

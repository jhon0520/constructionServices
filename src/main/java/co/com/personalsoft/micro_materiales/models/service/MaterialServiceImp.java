package co.com.personalsoft.micro_materiales.models.service;

import co.com.personalsoft.micro_materiales.models.dao.MaterialDao;
import co.com.personalsoft.micro_materiales.models.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialServiceImp implements IMaterialService{

    @Autowired
    private MaterialDao materialDao;

    @Override
    @Transactional(readOnly = true)
    public List<Material> findAll() {
        return (List<Material>) materialDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Material findById(Long id) {
        return materialDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Material save(Material material){
        return  materialDao.save(material);
    }

    @Override
    @Transactional
    public Material findByName(String name){
        return  materialDao.findByName(name);
    }

    @Override
    @Transactional
    public void deleteMaterial(Long id){
        materialDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateQuantity(int cantidad, Long id){
        materialDao.updateQuantity(cantidad,id);
    }

}

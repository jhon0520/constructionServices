package co.com.personalsoft.micro_materiales.models.service;

import co.com.personalsoft.micro_materiales.models.dao.ConstruccionDao;
import co.com.personalsoft.micro_materiales.models.entity.Construccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConstruccionServiceImp implements IConstruccionService{

    @Autowired
    private ConstruccionDao construccionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Construccion> findAll() {
        return (List<Construccion>) construccionDao.findAll();
    }

    @Override
    @Transactional
    public Construccion saveConstruction(Construccion construccion){
        return construccionDao.save(construccion);
    }

    @Override
    @Transactional(readOnly = true)
    public Construccion addConstruction(String coordenada){
        return construccionDao.findByCoordenada(coordenada);
    }
}

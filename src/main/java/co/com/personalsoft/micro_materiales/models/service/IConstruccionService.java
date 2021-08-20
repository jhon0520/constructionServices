package co.com.personalsoft.micro_materiales.models.service;

import co.com.personalsoft.micro_materiales.models.entity.Construccion;

import java.util.List;

public interface IConstruccionService {
    public List<Construccion> findAll();
    public Construccion saveConstruction(Construccion construccion);
    public Construccion addConstruction(String coodernada);

}

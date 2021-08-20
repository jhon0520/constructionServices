package co.com.personalsoft.micro_materiales.controllers;

import co.com.personalsoft.micro_materiales.models.entity.Material;
import co.com.personalsoft.micro_materiales.models.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MaterialController  {

    @Autowired
    private IMaterialService materialService;

    @GetMapping("/listarMateriales")
    public List<Material> listar(){
        return materialService.findAll();
    }

    @GetMapping("/verMaterial/{id}")
    public Material detalle(@PathVariable Long id){
        return materialService.findById(id);
    }

    @GetMapping("/material/{name}")
    public Material findByName(@PathVariable String name){
        return materialService.findByName(name);
    }

    @PutMapping("/editarMaterial/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Material modificar(@RequestBody Material material, @PathVariable Long id){

        Material materialDb = materialService.findById(id);
        materialDb.setCantidad(material.getCantidad());

        return materialService.save(materialDb);
    }

    @PutMapping("/editarCantidad/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateQuantity(@RequestBody Material material, @PathVariable Long id){

        materialService.updateQuantity(material.getCantidad(), material.getId());

    }
}

package co.com.personalsoft.micro_materiales.controllers;

import co.com.personalsoft.micro_materiales.models.entity.Construccion;
import co.com.personalsoft.micro_materiales.models.entity.Material;
import co.com.personalsoft.micro_materiales.models.service.IConstruccionService;
import co.com.personalsoft.micro_materiales.models.service.IMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Locale;

@RestController
public class ConstruccionController {

    @Autowired
    private IConstruccionService construccionService;

    @Autowired
    private SendMailController sendMailController;

    @Autowired
    private IMaterialService materialService;

    @GetMapping("/listarconstrucciones")
    public List<Construccion> listar(){
        return construccionService.findAll();
    }

    @PostMapping("/crearConstruccion")
    @ResponseStatus(HttpStatus.CREATED)
    public Construccion crearConstruccion (@RequestBody Construccion construccion){
        Boolean haveMaterials = false;
        int remainingCement = 0;
        int remainingGravel = 0;
        int remainingSand = 0;
        int remainingWood = 0;
        int remainingAdobe = 0;
        Construccion construccionDb = construccionService.addConstruction(construccion.getCoordenada());


        if(construccionDb != null){
            System.err.println("Coordenadas utilizadas!!!");
            sendMailController.sendSimpleEmail("email@gmail.com","Creacion fallida","El proyecto de construccion no pudo guardarse con exito debido a que el area de construccion deseada se encuentra ocupada o los materiales son insuficientes");
            return null;
        }

        List<Material> materiales = materialService.findAll();

        String constructionType = construccion.getTipo().toUpperCase(Locale.ROOT);


        switch (constructionType){
            case "CASA":
                remainingCement = materiales.get(0).getCantidad() - 100;
                remainingGravel = materiales.get(1).getCantidad() - 50;
                remainingSand = materiales.get(2).getCantidad() - 90;
                remainingWood = materiales.get(3).getCantidad() - 20;
                remainingAdobe = materiales.get(4).getCantidad() - 100;

                if(remainingCement > 0 && remainingGravel > 0 &&
                        remainingSand > 0 && remainingWood > 0 &&
                        remainingAdobe > 0){
                    haveMaterials = true;

                    materialService.updateQuantity(remainingCement, 1L);
                    materialService.updateQuantity(remainingGravel, 2L);
                    materialService.updateQuantity(remainingSand, 3L);
                    materialService.updateQuantity(remainingWood, 4L);
                    materialService.updateQuantity(remainingAdobe, 5L);
                }

                break;
            case "Lago":

                remainingCement = materiales.get(0).getCantidad() - 50;
                remainingGravel = materiales.get(1).getCantidad() - 60;
                remainingSand = materiales.get(2).getCantidad() - 80;
                remainingWood = materiales.get(3).getCantidad() - 10;
                remainingAdobe = materiales.get(4).getCantidad() - 20;

                if(remainingCement > 0 && remainingGravel > 0 &&
                        remainingSand > 0 && remainingWood > 0 &&
                        remainingAdobe > 0){
                    haveMaterials = true;

                    materialService.updateQuantity(remainingCement, 1L);
                    materialService.updateQuantity(remainingGravel, 2L);
                    materialService.updateQuantity(remainingSand, 3L);
                    materialService.updateQuantity(remainingWood, 4L);
                    materialService.updateQuantity(remainingAdobe, 5L);
                }

                break;
            case "CANCHA DE FUTBOL":
            case "CANCHA":
                remainingCement = materiales.get(0).getCantidad() - 20;
                remainingGravel = materiales.get(1).getCantidad() - 20;
                remainingSand = materiales.get(2).getCantidad() - 20;
                remainingWood = materiales.get(3).getCantidad() - 20;
                remainingAdobe = materiales.get(4).getCantidad() - 20;

                if(remainingCement > 0 && remainingGravel > 0 &&
                        remainingSand > 0 && remainingWood > 0 &&
                        remainingAdobe > 0){
                    haveMaterials = true;

                    materialService.updateQuantity(remainingCement, 1L);
                    materialService.updateQuantity(remainingGravel, 2L);
                    materialService.updateQuantity(remainingSand, 3L);
                    materialService.updateQuantity(remainingWood, 4L);
                    materialService.updateQuantity(remainingAdobe, 5L);
                }

                break;
            case "EDIFICIO":
                remainingCement = materiales.get(0).getCantidad() - 200;
                remainingGravel = materiales.get(1).getCantidad() - 100;
                remainingSand = materiales.get(2).getCantidad() - 180;
                remainingWood = materiales.get(3).getCantidad() - 40;
                remainingAdobe = materiales.get(4).getCantidad() - 200;

                if(remainingCement > 0 && remainingGravel > 0 &&
                        remainingSand > 0 && remainingWood > 0 &&
                        remainingAdobe > 0){
                    haveMaterials = true;

                    materialService.updateQuantity(remainingCement, 1L);
                    materialService.updateQuantity(remainingGravel, 2L);
                    materialService.updateQuantity(remainingSand, 3L);
                    materialService.updateQuantity(remainingWood, 4L);
                    materialService.updateQuantity(remainingAdobe, 5L);
                }

                break;
            case "GYMNASIO":
                remainingCement = materiales.get(0).getCantidad() - 50;
                remainingGravel = materiales.get(1).getCantidad() - 25;
                remainingSand = materiales.get(2).getCantidad() - 45;
                remainingWood = materiales.get(3).getCantidad() - 10;
                remainingAdobe = materiales.get(4).getCantidad() - 50;

                if(remainingCement > 0 && remainingGravel > 0 &&
                        remainingSand > 0 && remainingWood > 0 &&
                        remainingAdobe > 0){
                    haveMaterials = true;

                    materialService.updateQuantity(remainingCement, 1L);
                    materialService.updateQuantity(remainingGravel, 2L);
                    materialService.updateQuantity(remainingSand, 3L);
                    materialService.updateQuantity(remainingWood, 4L);
                    materialService.updateQuantity(remainingAdobe, 5L);
                }

                break;
        }

        if (haveMaterials){
            sendMailController.sendSimpleEmail("email@gmail.com","Creacion exitosa","El proyecto de construccion fue guardado exitosamente en la base de datos");
            return construccionService.saveConstruction(construccion);

        }else{
            sendMailController.sendSimpleEmail("email@gmail.com","Creacion fallida","El proyecto de construccion no pudo guardarse con exito debido a que el area de construccion deseada se encuentra ocupada o los materiales son insuficientes");
            return null;
        }
    }
}

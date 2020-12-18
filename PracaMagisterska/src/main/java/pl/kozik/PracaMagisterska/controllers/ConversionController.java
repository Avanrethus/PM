/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kozik.PracaMagisterska.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kozik.PracaMagisterska.storage.StorageService;

/**
 *
 * @author Avanrethus
 */
@Controller
public class ConversionController {
    
    private StorageService storageService;

    public ConversionController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/conversion")
    public String conversionPage(){
        return "conversion";
    }
}
package sut.sa.g21.controller;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g21.entity.*;
import sut.sa.g21.repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller{
    @Autowired private PreorderRepository preorderRepository;
    @Autowired private ProductRepository productRepository;
    @Autowired private ProvinceRepository ProvinceRepository;
    @Autowired private StatusPreorderRepository statusPreorderRepository;
    @Autowired private UserRepository userRepository;
     


    //Province
     @GetMapping("/provinces")
     public Collection<Province> provinces(){
         return ProvinceRepository.findAll().stream().collect(Collectors.toList());
     }
 
     @GetMapping("/Provinces/{provinceId}")
     public Optional<Province> takeinClassificationByid(@PathVariable Long provinceId ){
         return ProvinceRepository.findById(provinceId);
     }
}
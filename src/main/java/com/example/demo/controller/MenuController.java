package com.example.demo.controller;

import com.example.demo.dto.MenuRequest;
import com.example.demo.dto.MenuResponse;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    @PostMapping
    public MenuResponse createMenu(@RequestBody MenuRequest menuRequest){
        return menuService.createMenu(menuRequest);
    }

    @GetMapping("/{id}")
    public MenuResponse readMenu(@PathVariable Long id){
        return menuService.readMenu(id);
    }

    @GetMapping
    public List<MenuResponse> readAllMenu(){
        return menuService.readAllMenu();
    }

    @PutMapping("/{id}")
    public MenuResponse updateMenu(@RequestBody MenuRequest menuRequest, @PathVariable Long id){
        return menuService.updateMenu(menuRequest,id);
    }

    @DeleteMapping("/{id}")
    public MenuResponse deleteMenu(@PathVariable Long id){
        return menuService.deleteMenu(id);
    }

}

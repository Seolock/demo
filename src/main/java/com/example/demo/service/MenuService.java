package com.example.demo.service;

import com.example.demo.domain.Menu;
import com.example.demo.dto.MenuRequest;
import com.example.demo.dto.MenuResponse;
import com.example.demo.repository.MenuRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public MenuResponse createMenu(MenuRequest menuRequest){
        Menu menu = menuRepository.save(Menu.from(menuRequest));
        return MenuResponse.from(menu);
    }

    public MenuResponse readMenu(Long id){
        Menu menu = menuRepository.findById(id).orElseThrow();
        return MenuResponse.from(menu);
    }

    public List<MenuResponse> readAllMenu(){
        List<Menu> menus = menuRepository.findAll();
        return menus.stream().map(MenuResponse::from).toList();
    }

    @Transactional
    public MenuResponse updateMenu(MenuRequest menuRequest, Long id){
        Menu menu = menuRepository.findById(id).orElseThrow();
        menu.update(menuRequest);
        return MenuResponse.from(menu);
    }

    public MenuResponse deleteMenu(Long id){
        Menu menu = menuRepository.findById(id).orElseThrow();
        menuRepository.deleteById(id);
        return MenuResponse.from(menu);
    }

}

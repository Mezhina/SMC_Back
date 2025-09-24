package com.smc.demo.controller;

import com.smc.demo.entity.EntityData;
import com.smc.demo.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/entities")
public class EntityController {

    @Autowired
    private EntityRepository entityRepository;

    @GetMapping("/api")
    @ResponseBody
    public List<EntityData> getEntitiesApi() {
        try {
            return entityRepository.findAll();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    @GetMapping
    public String getEntities(Model model) {
        try {
            // Получаем данные из базы данных
            List<EntityData> entities = entityRepository.findAll();
            model.addAttribute("entities", entities);
            model.addAttribute("title", "Список сущностей");
            return "entities";
        } catch (Exception e) {
            // Если ошибка с базой данных, показываем пустой список
            model.addAttribute("entities", new ArrayList<>());
            model.addAttribute("title", "Список сущностей (нет данных)");
            model.addAttribute("error", "Ошибка подключения к базе данных: " + e.getMessage());
            return "entities";
        }
    }
    
}
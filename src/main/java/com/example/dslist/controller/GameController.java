package com.example.dslist.controller;


import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameIdDTO;
import com.example.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameDTO> findAll(){
        List<GameDTO> result = gameService.findAll();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameIdDTO findById(@PathVariable Long id){
        GameIdDTO result = gameService.findById(id);
        return result;
    }


}

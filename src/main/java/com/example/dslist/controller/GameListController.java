package com.example.dslist.controller;

import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameIdDTO;
import com.example.dslist.dto.GameListDTO;
import com.example.dslist.dto.ReplacemetDTO;
import com.example.dslist.service.GameListService;
import com.example.dslist.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameDTO> findByList(@PathVariable Long listId){
        List<GameDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacemetDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }



}

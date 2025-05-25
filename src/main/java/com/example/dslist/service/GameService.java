package com.example.dslist.service;


import com.example.dslist.dto.GameDTO;
import com.example.dslist.dto.GameIdDTO;
import com.example.dslist.entities.Game;
import com.example.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameIdDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameIdDTO dto = new GameIdDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameDTO(x)).toList();

    }

}

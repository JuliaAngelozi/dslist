package com.example.dslist.service;


import com.example.dslist.dto.GameListDTO;
import com.example.dslist.entities.GameList;
import com.example.dslist.projection.GameProjection;
import com.example.dslist.repository.GameListRepository;
import com.example.dslist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();

    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){

        List<GameProjection> list = gameRepository.searchByList(listId);

         GameProjection obj = list.remove(sourceIndex);
         list.add(destinationIndex, obj);

         int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
         int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

         for(int i = min; i<= max; i++){
             gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
         }


    }

}

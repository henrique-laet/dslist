package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.services.GameListServices;
import com.devsuperior.dslist.services.GameServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListServices gameListServices;

    @Autowired
    private GameServices gameServices;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListServices.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameServices.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListServices.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}

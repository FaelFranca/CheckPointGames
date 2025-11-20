
package com.checkpointgames.app.controller;

import com.checkpointgames.app.entity.Users;
import com.checkpointgames.app.entity.Games;
import com.checkpointgames.app.service.GamesService;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/games")
public class GamesController {
    
    @Autowired
    private GamesService gamesService;
    
    @PostMapping("/createGame")
    public Games saveGame(@Valid @RequestBody Games game){
        return gamesService.saveGame(game);
    }
    
    @PostMapping("/updateGames")
    public Games updateUser(@Valid @RequestBody Games game){
        return gamesService.updateGames(game);
    }

    @GetMapping("/showGames")
    public List<Games> showGames(Games game){
        return gamesService.showGames(game);
    }
    
    @GetMapping("/showActivityGames")
    public List<Games> showActivityGames (Games game){
        return gamesService.showActivityGames(game);
    }
    
    @GetMapping("/showGamesById/{id}")
    public ResponseEntity<Games> showGamesById (@PathVariable Integer id){
        return gamesService.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}

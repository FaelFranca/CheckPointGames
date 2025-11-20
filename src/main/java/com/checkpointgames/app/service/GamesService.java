package com.checkpointgames.app.service;

import com.checkpointgames.app.entity.Games;
import com.checkpointgames.app.exception.InvalidIdException;
import com.checkpointgames.app.repository.GamesRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamesService {
    
    @Autowired
    private GamesRepository gamesRepository;
    
    public Games saveGame(Games game){
        return gamesRepository.save(game);
    }
    
    public Games updateGames(Games games) {
        gamesRepository.findById(games.getId())
            .orElseThrow(() -> new InvalidIdException("Jogo não encontrado"));
        
        gamesRepository.updateGames(games.getName(), games.getDescription(), games.getInventory(), games.getValue(), games.getStatus(), games.getLinkImage(), games.getId());
        
        return gamesRepository.findById(games.getId())
            .orElseThrow(() -> new RuntimeException("Erro ao atualizar a senha"));
    }    
    
    public List<Games> showGames(Games game) {
        return gamesRepository.findAll();
    }
    
    public List<Games> showActivityGames (Games game){
        return gamesRepository.findActivityGames();
    }
    
    public Optional<Games> findById (Integer id) {
        return gamesRepository.findById(id);
    }
    
}

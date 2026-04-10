package com.Hageli.FLiigaFantasy.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromTeam (String teamName) {
        return playerRepository.findAll().stream()
                .filter(player -> teamName.equals(player.getTeamName()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchString) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPosition(String searchString) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getPosition().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByNation(String searchString) {
        return playerRepository.findAll().stream()
                .filter(player -> player.getNationality().toLowerCase().contains(searchString.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String teamSearch, String positionSearch) {
        return playerRepository.findAll().stream()
                .filter(player -> teamSearch.equals(player.getTeamName()) && positionSearch.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepository.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeamName(updatedPlayer.getName());
            playerToUpdate.setPosition(updatedPlayer.getName());
            playerToUpdate.setNationality(updatedPlayer.getName());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playerName) {
        playerRepository.deleteByName(playerName);
    }

}


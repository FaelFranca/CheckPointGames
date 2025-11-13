package com.checkpointgames.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "GameKeys")
public class GameKeys {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_GAME", referencedColumnName = "ID")
    private Games idGame;
    
    @NotBlank
    @Column(name = "KEY", columnDefinition = "TEXT")
    private String key;
    
    @NotBlank
    @Size(max = 1)
    @Column(name = "STATUS", columnDefinition = "integer default 0")
    private String status;    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Games getIdGame() {
        return idGame;
    }

    public void setIdGame(Games idGame) {
        this.idGame = idGame;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    
}

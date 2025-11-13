package com.checkpointgames.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "ITENS")
public class Itens {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotBlank
    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_GAME", referencedColumnName = "ID")
    private Games idGame;

    @NotBlank
    @ManyToOne(optional = true)
    @JoinColumn(name = "ID_ORDER", referencedColumnName = "ID")
    private Order idOrder;

    @NotBlank
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_KEY", referencedColumnName = "ID")
    private GameKeys idKey;

    @Column(name = "DISCOUNT", precision = 15, scale = 3)
    private BigDecimal discount;
    
    @Column(name = "ADDITION", precision = 15, scale = 3)
    private BigDecimal addition;
    
    @Column(name = "VALUE", precision = 15, scale = 3)
    private BigDecimal value;
            
    
}

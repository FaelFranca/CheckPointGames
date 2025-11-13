package com.checkpointgames.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ORDERS")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_COSTUMER", referencedColumnName = "ID")
    private Users costumer;
    
    @NotNull
    @Column(name = "SALE_VALUE", precision = 15, scale = 3)
    private BigDecimal saleValue;
    
    @NotNull
    @Column(name = "ITENS_VALUE", precision = 15, scale = 3)
    private BigDecimal itensValue;
    
    @Column(name = "DISCOUNT", precision = 15, scale = 3)
    private BigDecimal discount;
    
    @Column(name = "ADDITION", precision = 15, scale = 3)
    private BigDecimal addition;
    
    @NotNull
    @Column(name = "DATE")
    private LocalDate date;
   
    @Column(name = "STATUS", columnDefinition = "integer default 0")
    @NotNull
    private Integer status = 0;
}
    


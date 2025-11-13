package com.checkpointgames.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "GAMES")
public class Games {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;

    @NotBlank
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;

    @NotBlank
    @Column(name = "INVENTORY")
    private Integer inventory;
    
    @NotNull
    @Column(name = "VALUE",precision = 15, scale = 3)
    private BigDecimal value;

    @Column(name = "LINK_IMAGE", columnDefinition = "TEXT")
    private String linkImage;
    
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    
}

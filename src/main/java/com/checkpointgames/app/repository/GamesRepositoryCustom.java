package com.checkpointgames.app.repository;

import java.math.BigDecimal;

public interface GamesRepositoryCustom {
        void updateGames(String name, String description, Integer inventory, BigDecimal value, Integer status, String linkImage, Integer id);
}
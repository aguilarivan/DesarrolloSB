package com.example.desarrollo_tp.repository;

import com.example.desarrollo_tp.model.ItemMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, Integer> {
}

package com.soft.buserapp.model.linha;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LinhaRepository extends JpaRepository<Linha, Long> {
}

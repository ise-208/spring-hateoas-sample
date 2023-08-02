package com.example.springhateoassample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringHateoasRepository extends JpaRepository<SpringHateoasModel, String> {
    List<SpringHateoasModel> findByName(String name);
}

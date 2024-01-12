package com.example.lab5.repository;

import java.util.List;
import com.example.lab5.entity.Carti;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Carti> findAll() {
        return jdbcTemplate.query("SELECT * FROM carti", (resultSet, rowNum) -> {
            Carti carte = new Carti();
            carte.setIdCarte(resultSet.getLong("id_carte"));
            carte.setTitlu(resultSet.getString("titlu"));
            carte.setIdAutor(resultSet.getInt("id_autor"));
            carte.setAnPublicatie(resultSet.getInt("an_publicatie"));
            carte.setGen(resultSet.getString("gen"));
            return carte;
        });
    }

    public Carti findById(Long id) {
        String sql = "SELECT * FROM carti WHERE id_carte = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Carti(
                        resultSet.getLong("id_carte"),
                        resultSet.getString("titlu"),
                        resultSet.getInt("id_autor"),
                        resultSet.getInt("an_publicatie"),
                        resultSet.getString("gen")
                ));
    }

    public void create(Carti carte) {
        String sql = "INSERT INTO carti(titlu, id_autor, an_publicatie, gen) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, carte.getTitlu(), carte.getIdAutor(), carte.getAnPublicatie(), carte.getGen());
    }

    public void update(Long id, Carti carte) {
        String sql = "UPDATE carti SET titlu = ?, id_autor = ?, an_publicatie = ?, gen = ? WHERE id_carte = ?";

        jdbcTemplate.update(sql, carte.getTitlu(), carte.getIdAutor(), carte.getAnPublicatie(), carte.getGen(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM carti WHERE id_carte = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(Long id) {
        String sql = "SELECT COUNT(*) FROM carti WHERE id_carte = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;
    }
}

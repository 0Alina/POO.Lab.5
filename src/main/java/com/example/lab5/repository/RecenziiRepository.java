package com.example.lab5.repository;

import java.util.List;
import com.example.lab5.entity.Recenzii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecenziiRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Recenzii> findAll() {
        return jdbcTemplate.query("SELECT * FROM recenzii", (resultSet, rowNum) -> {
            Recenzii recenzie = new Recenzii();
            recenzie.setIdRecenzie(resultSet.getInt("id_recenzie"));
            recenzie.setIdCarte(resultSet.getInt("id_carte"));
            recenzie.setNota(resultSet.getInt("nota"));
            recenzie.setComentariu(resultSet.getString("comentariu"));
            return recenzie;
        });
    }

    public Recenzii findById(int id) {
        String sql = "SELECT * FROM recenzii WHERE id_recenzie = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Recenzii(
                        resultSet.getInt("id_recenzie"),
                        resultSet.getInt("id_carte"),
                        resultSet.getInt("nota"),
                        resultSet.getString("comentariu")
                ));
    }

    public void create(Recenzii recenzie) {
        String sql = "INSERT INTO recenzii(id_carte, nota, comentariu) VALUES (?, ?, ?)";

        jdbcTemplate.update(sql, recenzie.getIdCarte(), recenzie.getNota(), recenzie.getComentariu());
    }

    public void update(int id, Recenzii recenzie) {
        String sql = "UPDATE recenzii SET id_carte = ?, nota = ?, comentariu = ? WHERE id_recenzie = ?";

        jdbcTemplate.update(sql, recenzie.getIdCarte(), recenzie.getNota(), recenzie.getComentariu(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM recenzii WHERE id_recenzie = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT COUNT(*) FROM recenzii WHERE id_recenzie = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;
    }
}

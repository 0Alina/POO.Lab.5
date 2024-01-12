package com.example.lab5.repository;

import java.util.List;
import com.example.lab5.entity.Autori;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AutoriRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Autori> findAll() {
        return jdbcTemplate.query("SELECT * FROM autori", (resultSet, rowNum) -> {
            Autori autori = new Autori();
            autori.setId(resultSet.getInt("id"));
            autori.setNumeAutor(resultSet.getString("nume_autor"));
            autori.setOrigine(resultSet.getString("origine"));
            return autori;
        });
    }

    public Autori findById(int id) {
        String sql = "SELECT * FROM autori WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, rowNum) ->
                new Autori(
                        resultSet.getInt("id_autor"),
                        resultSet.getString("nume_autor"),
                        resultSet.getString("origine")
                ));
    }

    public void create(Autori autor) {
        String sql = "INSERT INTO autori(nume_autor, origine) VALUES (?, ?)";

        jdbcTemplate.update(sql, autor.getNumeAutor(), autor.getOrigine());
    }

    public void update(int id, Autori autor) {
        String sql = "UPDATE autori SET nume_autor = ?, origine = ? WHERE id = ?";

        jdbcTemplate.update(sql, autor.getNumeAutor(), autor.getOrigine(), id);
    }

    public void delete(int id) {
        String sql = "DELETE FROM autori WHERE id = ?";

        jdbcTemplate.update(sql, id);
    }

    public boolean existById(int id) {
        String sql = "SELECT COUNT(*) FROM autori WHERE id = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);

        return count != null && count > 0;
    }

    public boolean existByNumeAutor(String numeAutor) {
        String sql = "SELECT COUNT(*) FROM autori WHERE nume_autor = ?";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, numeAutor);

        return count != null && count > 0;
    }
}

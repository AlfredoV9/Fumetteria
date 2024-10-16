package com.example.progetto.repository;

import com.example.progetto.entity.Fumetto;
import com.example.progetto.enumCostanti.FumettoTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FumettoRepository extends JpaRepository<Fumetto, Integer> {

    List<Fumetto> findByGeneriNomeAndTipo(String genere, FumettoTipo tipo);

    List<Fumetto> findByCasaEditriceNomeAndTipo(String casaEditrice, FumettoTipo tipo);

    List<Fumetto> findByTipo(FumettoTipo tipo);

    @Query("SELECT f FROM Fumetto f WHERE " +
            "f.tipo = :tipo " +
            "AND (:nome IS NULL OR f.autore.nome LIKE %:nome%) " +
            "AND (:cognome IS NULL OR f.autore.cognome LIKE %:cognome%)")
    List<Fumetto> findByAutoreNomeCognomeAndTipo(
            @Param("nome") String nome,
            @Param("cognome") String cognome,
            @Param("tipo") FumettoTipo tipo);


    List<Fumetto> findByRaccomandatoAndTipo(boolean raccomandato, FumettoTipo tipo);

    List<Fumetto> findByFranchiseAndTipo(String franchise, FumettoTipo tipo);

    @Query(value = """
        SELECT DISTINCT f.*
        FROM fumetto f
        WHERE f.tipo = :tipo
        AND f.id NOT IN (
            SELECT f3.id
            FROM fumetto f3
            JOIN volume v3 ON f3.id = v3.fumetto_id
            JOIN capitolo c3 ON v3.id = c3.volume_id
            JOIN capitololetto cl3 ON c3.id = cl3.capitolo_id
            WHERE cl3.utente_id = :utenteId
        )
        AND f.id IN (
            SELECT fg.fumetto_id
            FROM fumetto_genere fg
            WHERE fg.genere_id IN (
                SELECT fg2.genere_id
                FROM fumetto f2
                JOIN fumetto_genere fg2 ON f2.id = fg2.fumetto_id
                JOIN volume v2 ON f2.id = v2.fumetto_id
                JOIN capitolo c2 ON v2.id = c2.volume_id
                JOIN capitololetto cl2 ON c2.id = cl2.capitolo_id
                WHERE cl2.utente_id = :utenteId
            )
            GROUP BY fg.fumetto_id
            HAVING COUNT(fg.genere_id) >= 2
        )
    """, nativeQuery = true)
    List<Fumetto> findRecommendedFumetti(@Param("tipo") String tipo, @Param("utenteId") Integer utenteId);

    Fumetto findByTitolo(String titolo);
}

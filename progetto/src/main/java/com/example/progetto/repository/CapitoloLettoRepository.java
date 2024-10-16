package com.example.progetto.repository;

import com.example.progetto.entity.CapitoloLetto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CapitoloLettoRepository extends JpaRepository<CapitoloLetto, Integer> {

    @Query(value = """
            SELECT 
                cl.fumetto_id AS fumetto_id,
                cl.fumetto_titolo AS fumetto_titolo,
                cl.fumetto_descrizione AS fumetto_descrizione,
                cl.fumetto_data_rilascio AS fumetto_data_rilascio,
                cl.fumetto_stato AS fumetto_stato,
                cl.volume_id AS volume_id,
                cl.volume_numero AS volume_numero,
                cl.capitolo_id AS capitolo_id,
                cl.capitolo_numero AS capitolo_numero,
                cl.capitolo_titolo AS capitolo_titolo,
                cl.capitolo_data_pubblicazione AS capitolo_data_pubblicazione,
                cl.utente_id,
                cl.id,
                cl.stato
            FROM 
                (
                    SELECT 
                        f.id AS fumetto_id,
                        f.titolo AS fumetto_titolo,
                        f.descrizione AS fumetto_descrizione,
                        f.data_rilascio AS fumetto_data_rilascio,
                        f.stato AS fumetto_stato,
                        v.id AS volume_id,
                        v.numero AS volume_numero,
                        c.id AS capitolo_id,
                        c.numero AS capitolo_numero,
                        c.titolo AS capitolo_titolo,
                        c.data_pubblicazione AS capitolo_data_pubblicazione,
                        cl2.utente_id,
                        cl2.id,
                        cl2.stato
                    FROM 
                        fumetto f
                    JOIN 
                        volume v ON f.id = v.fumetto_id
                    JOIN 
                        capitolo c ON c.volume_id = v.id
                    JOIN 
                        capitololetto cl2 ON cl2.capitolo_id = c.id
                    WHERE 
                        cl2.utente_id = :utenteId 
                        AND c.id = (
                            SELECT 
                                c2.id 
                            FROM 
                                capitololetto cl3
                            JOIN 
                                capitolo c2 ON cl3.capitolo_id = c2.id
                            JOIN 
                                volume v2 ON c2.volume_id = v2.id
                            WHERE 
                                cl3.utente_id = cl2.utente_id 
                                AND v2.fumetto_id = f.id
                            ORDER BY 
                                c2.numero DESC 
                            LIMIT 1
                        )
                ) AS cl
            WHERE 
                cl.fumetto_stato = 'IN_CORSO' 
                OR cl.volume_numero < (
                    SELECT MAX(v2.numero) 
                    FROM volume v2 
                    WHERE v2.fumetto_id = cl.fumetto_id
                ) 
                OR (
                    cl.volume_numero = (
                        SELECT MAX(v2.numero) 
                        FROM volume v2 
                        WHERE v2.fumetto_id = cl.fumetto_id
                    ) 
                    AND cl.capitolo_numero < (
                        SELECT MAX(c2.numero) 
                        FROM capitolo c2 
                        WHERE c2.volume_id = cl.volume_id
                    )
                )
            """, nativeQuery = true)
    List<CapitoloLetto> findCapitoliLettiByUtente(@Param("utenteId") Integer utenteId);
}

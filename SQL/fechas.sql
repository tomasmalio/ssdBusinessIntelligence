CREATE TABLE IF NOT EXISTS fechas(
	idfecha DATE NOT NULL PRIMARY KEY,
    dia INT,
    mes INT,
    anio INT,
    trimestre INT,
    estacion VARCHAR(50),
    diadelasemana VARCHAR(50)
);


/* Generacion de Fechas */
DROP PROCEDURE IF EXISTS GenerarCalendario;

DELIMITER $$
    CREATE PROCEDURE GenerarCalendario(desde DATE, hasta DATE)
    BEGIN
		DECLARE fechaCompleta DATE;
        DECLARE trimestre INT;
        DECLARE estacion VARCHAR(50);
        DECLARE intDiaDeLaSemana INT;
        DECLARE diadelasemana VARCHAR(50);
        
		SET fechaCompleta = desde;
        
		WHILE fechaCompleta <= hasta DO
			IF MONTH(fechaCompleta) < 3 OR MONTH(fechaCompleta) = 12 THEN
				SET estacion = 'Verano';
            END IF;
            IF MONTH(fechaCompleta) > 2 AND MONTH(fechaCompleta) < 6 THEN
				SET estacion = 'Otoño';
            END IF;
            IF MONTH(fechaCompleta) > 5  AND MONTH(fechaCompleta) < 9 THEN
				SET estacion = 'Invierno';
            END IF;
             IF MONTH(fechaCompleta) > 8  AND MONTH(fechaCompleta) < 12 THEN
				SET estacion = 'Primavera';
            END IF;
            
			SET intDiaDeLaSemana = DAYOFWEEK(fechaCompleta);
            
			CASE intDiaDeLaSemana
				WHEN 1 THEN 
					SET diadelasemana = 'Lunes';
				WHEN 2 THEN 
					SET diadelasemana = 'Martes';
				WHEN 3 THEN 
					SET diadelasemana = 'Miércoles';
				WHEN 4 THEN 
					SET diadelasemana = 'Jueves';
                WHEN 5 THEN 
					SET diadelasemana = 'Viernes';
				WHEN 6 THEN 
					SET diadelasemana = 'Sábado';
				WHEN 7 THEN 
					SET diadelasemana = 'Domingo';
			END CASE;
            
            IF ((MONTH(fechaCompleta) > 3) AND (MONTH(fechaCompleta) < 7)) THEN 
				SET trimestre = 2;
			ELSEIF ((MONTH(fechaCompleta) > 6) AND (MONTH(fechaCompleta) < 10)) THEN 
				SET trimestre = 3;
			ELSEIF ((MONTH(fechaCompleta) > 9) AND (MONTH(fechaCompleta) < 13)) THEN 
				SET trimestre = 4;
			ELSEIF (MONTH(fechaCompleta) < 4) THEN 
				SET trimestre = 1;
			END IF;
			
			
			INSERT IGNORE INTO fechas 
            VALUES(fechaCompleta, DAY(fechaCompleta), MONTH(fechaCompleta), YEAR(fechaCompleta), trimestre, estacion, diadelasemana);
			
            SET fechaCompleta = ADDDATE(fechaCompleta, INTERVAL 1 DAY);
            
		END WHILE;
    END$$
DELIMITER ;

CALL GenerarCalendario('1996-01-01', '1999-12-31');
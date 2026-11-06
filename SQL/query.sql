
-- ============================= ESERCIZI =============================

-- 1. Mostrare tutti gli autori ordinati per cognome e nome
-- ASC indica l'ordinamento crescente.

SELECT Autori.cognome, Autori.nome
FROM Autori
ORDER BY Autori.cognome ASC, Autori.nome ASC;


-- 2. Mostrare titolo e anno dei libri pubblicati dopo il 2000

SELECT Libri.titolo, Libri.anno
FROM Libri
WHERE Libri.anno > '1999-12-31';


-- 3. Trovare gli autori italiani

SELECT Autori.nazionalita
FROM Autori
WHERE Autori.nazionalita LIKE 'IT';


-- 4. Trovare i libri il cui titolo contiene la lettera "a"
-- Senza distinguere tra maiuscole e minuscole.

SELECT Libri.titolo
FROM Libri
WHERE LOWER(Libri.titolo) LIKE LOWER('%a%');


-- 5. Elencare le case editrici presenti, senza duplicati.
-- DISTINCT elimina i duplicati.

SELECT DISTINCT Copie.casa_editrice
FROM Copie;


-- 6. Mostrare i 5 libri più recenti.
-- DESC ordina i risultati in ordine decrescente.
-- LIMIT limita il numero di risultati a 5.

SELECT Libri.anno
FROM Libri
ORDER BY Libri.anno DESC
LIMIT 5;


-- 7. Mostrare ogni libro con il nome del suo genere.

SELECT Libri.titolo, Generi.nome, Generi.idGenere
FROM Libri
JOIN Generi ON Libri.fk_genere = Generi.idGenere;


-- 8. Mostrare ogni libro con nome e cognome dei suoi autori
-- Passando attraverso la tabella Libri_Autori.

SELECT Libri.titolo, Autori.nome, Autori.cognome
FROM Libri
JOIN Libri_Autori
    ON Libri.isbn = Libri_Autori.fk_isbn
JOIN Autori
    ON Libri_Autori.fk_autore = Autori.idAutore;


-- 9. Trovare tutti i libri scritti da un autore dato il suo cognome.

SELECT Libri.titolo, Autori.cognome
FROM Libri
JOIN Libri_Autori
    ON Libri.isbn = Libri_Autori.fk_isbn
JOIN Autori
    ON Libri_Autori.fk_autore = Autori.idAutore
WHERE Autori.cognome LIKE 'Joyce';


-- 10. Trovare i libri di genere "Fantasy" che hanno almeno una copia disponibile.

SELECT Libri.titolo, Generi.nome, Copie.num_copie
FROM Copie
JOIN Libri
    ON Copie.fk_isbn = Libri.isbn
JOIN Generi
    ON Libri.fk_genere = Generi.idGenere
WHERE Generi.nome LIKE 'Fantasy'
  AND Copie.num_copie > 0;


-- 11. Mostrare gli autori che hanno scritto almeno un libro
-- di un certo genere, senza duplicati.

SELECT DISTINCT Autori.nome, Autori.cognome, Generi.nome
FROM Autori
JOIN Libri_Autori
    ON Autori.idAutore = Libri_Autori.fk_autore
JOIN Libri
    ON Libri_Autori.fk_isbn = Libri.isbn
JOIN Generi
    ON Libri.fk_genere = Generi.idGenere
WHERE Generi.nome LIKE 'Romanzo';

package br.com.api.repository;

import br.com.api.models.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryNotaFiscal extends JpaRepository<NotaFiscal, Long> {
    List<NotaFiscal> findByNumeroNota(int numeroNota);
}

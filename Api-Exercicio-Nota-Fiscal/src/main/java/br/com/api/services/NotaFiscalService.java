package br.com.api.services;

import br.com.api.models.NotaFiscal;
import br.com.api.repository.RepositoryNotaFiscal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {

    @Autowired
    private RepositoryNotaFiscal repositoryNotaFiscal;

    public NotaFiscal getNotaFiscal(long codigo){
        Optional<NotaFiscal> notaFiscal = repositoryNotaFiscal.findById(codigo);
        if(!notaFiscal.isPresent()){
            return null;
        }
        return notaFiscal.get();
    }

    public List<NotaFiscal> getNotaByNumero(int numeroNota){
        List<NotaFiscal> notaFiscal = repositoryNotaFiscal.findByNumeroNota(numeroNota);

        if (notaFiscal.isEmpty()){
            return null;
        }
        return notaFiscal;
    }

    public List<NotaFiscal> getALL(){
        return repositoryNotaFiscal.findAll();
    }

    public void saveNF(NotaFiscal notaFiscal){
        repositoryNotaFiscal.save(notaFiscal);
    }

    public void removerNF(NotaFiscal notaFiscal){
        repositoryNotaFiscal.delete(notaFiscal);
    }

    public void adicionarNFTeste(){
        if(getALL().isEmpty()){

            NotaFiscal nf = new NotaFiscal();
            nf.setEmitente("11111");
            nf.setDestinatario("22222");
            nf.setNumeroNota(1010);
            nf.setValor(15000);
            saveNF(nf);

            nf = new NotaFiscal();
            nf.setEmitente("33333");
            nf.setDestinatario("44444");
            nf.setNumeroNota(1011);
            nf.setValor(16000);
            saveNF(nf);


        }
    }
}

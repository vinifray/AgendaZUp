package br.com.zup.ZupAgenda.services;

import br.com.zup.ZupAgenda.repositories.ContatoRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
    @Autowired
    private ContatoRepostory contatoRepostory;

}

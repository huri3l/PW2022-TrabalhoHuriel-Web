/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Livro;
import br.edu.ifsul.util.Ordem;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author 20201PF.CC0165
 */
@Stateful
public class LivroDAO<TIPO> extends DAOGenerico<Livro> implements Serializable {

    public LivroDAO() {
        super();
        classePersistente = Livro.class;
        
        listaOrdem.add(new Ordem("isbn", "ISBN", "="));
        listaOrdem.add(new Ordem("codigo_barras", "Código de Barras", "="));
        listaOrdem.add(new Ordem("numero_paginas", "Número de Páginas", "="));
        listaOrdem.add(new Ordem("valor", "Valor", "="));
        listaOrdem.add(new Ordem("editora", "Editora", "like"));
        listaOrdem.add(new Ordem("resumo", "Resumo", "like"));
        listaOrdem.add(new Ordem("titulo", "Título", "like"));
        
        ordemAtual = listaOrdem.get(6);

        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }

    public void remover(String id) throws Exception {
        Livro obj = (Livro) em.find(classePersistente, id);
        em.remove(obj);
    }
}

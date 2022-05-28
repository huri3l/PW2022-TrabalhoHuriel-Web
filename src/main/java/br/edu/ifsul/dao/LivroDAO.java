/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Livro;
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
    }

    public void remover(String id) throws Exception {
        Livro obj = (Livro) em.find(classePersistente, id);
        em.remove(obj);
    }
}

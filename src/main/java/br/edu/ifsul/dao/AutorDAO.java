/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Autor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author hurie
 */
@Stateful
public class AutorDAO<TIPO> extends DAOGenerico<Autor> implements Serializable {
    public AutorDAO() {
        super();
        classePersistente = Autor.class;
    }
}

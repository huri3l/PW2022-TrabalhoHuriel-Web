/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Catalogo;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author hurie
 */
@Stateful
public class CatalogoDAO<TIPO> extends DAOGenerico<Catalogo> implements Serializable {
    public CatalogoDAO() {
        super();
        classePersistente = Catalogo.class;
    }
}

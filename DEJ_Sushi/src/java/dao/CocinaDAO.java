/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author VSPC
 */
public class CocinaDAO {
    private Connection cnx;

    public CocinaDAO(Connection cnx) {
        this.cnx = cnx;
    }
}

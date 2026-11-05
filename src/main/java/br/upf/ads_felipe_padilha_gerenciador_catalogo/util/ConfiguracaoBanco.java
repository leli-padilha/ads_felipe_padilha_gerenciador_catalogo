/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.upf.ads_felipe_padilha_gerenciador_catalogo.util;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

/**
 *
 * @author User
 */
@DataSourceDefinition(
        name = "java:app/jdbc/catalogoDS",
        className = "org.postgresql.ds.PGSimpleDataSource",
        serverName = "localhost",
        portNumber = 5432,
        databaseName = "dbsurfcatalog",
        user = "postgres",
        password = "masterkey")
@Singleton
@Startup
public class ConfiguracaoBanco {
}

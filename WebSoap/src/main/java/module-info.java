/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module WebSoap
{
    requires java.jws;
    requires jakarta.activation;

    
    requires javaee.api;
    requires java.logging;

    requires java.base;

    requires java.desktop;
    requires java.naming;
    requires java.instrument;
    requires java.xml.bind;
    requires java.sql;
    
    exports cr.ac.una.websoap.models;
    opens cr.ac.una.websoap.services;
 
}

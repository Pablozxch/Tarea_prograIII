/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

module cr.ac.una.tareaprogra
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires jakarta.activation;
    requires com.jfoenix;
    requires javafx.media;
    requires java.logging;

    requires java.base;

    requires java.desktop;

    requires java.instrument;

    requires java.jws;
    requires java.xml.ws;
    requires java.xml.bind;
    requires poi;
    requires poi.ooxml;
    requires AnimateFX;
    opens cr.ac.una.tareaprogra3.controllers to javafx.fxml;
    exports cr.ac.una.tareaprogra3.clases;
    exports cr.ac.una.tareaprogra3.models;
    opens cr.ac.una.tareaprogra3.services;

}

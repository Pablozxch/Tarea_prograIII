module cr.ac.una.tareaprogra
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires com.jfoenix;

    requires java.logging;

    requires java.base;

    requires java.desktop;

    requires java.instrument;

    requires java.jws;
    requires java.xml.ws;
    requires java.xml.bind;

    opens cr.ac.una.tareaprogra3.controllers to javafx.fxml;
    exports cr.ac.una.tareaprogra3.clases;
    exports cr.ac.una.tareaprogra3.models;
    opens cr.ac.una.tareaprogra3.services;

}

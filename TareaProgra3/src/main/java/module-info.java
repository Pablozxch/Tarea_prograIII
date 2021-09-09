module cr.ac.una.tareaprogra
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    requires com.jfoenix;

    requires java.logging;

    requires java.base;

    requires java.desktop;

    requires java.sql;
    requires java.persistence;

    requires java.xml.bind;
//    
    requires java.instrument;
    requires org.eclipse.persistence.core;


    opens cr.ac.una.tareaprogra3.models to org.eclipse.persistence.core;
    opens cr.ac.una.tareaprogra3.controllers to javafx.fxml;
    exports cr.ac.una.tareaprogra3.clases;
    exports cr.ac.una.tareaprogra3.utils;
        
}

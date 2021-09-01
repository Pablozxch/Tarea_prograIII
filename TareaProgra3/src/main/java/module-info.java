module cr.ac.una.tareaprogra3 
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    
    requires com.jfoenix;
   

    requires java.logging;
    
    requires java.base;
  
    
    /*
       requires java.instrument;
        requires java.sql;
        requires java.persistence;
        requires org.eclipse.persistence.core;
        requires java.desktop;
    */
    
    opens cr.ac.una.tareaprogra3.controllers to javafx.fxml;
    exports cr.ac.una.tareaprogra3.clases;
    exports cr.ac.una.tareaprogra3.utils;
}

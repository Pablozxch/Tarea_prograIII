/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.tareaprogra3.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.*;
import animatefx.animation.*;
import javafx.scene.image.*;
import javafx.scene.paint.*;
import javafx.util.*;

/**
 * FXML Controller class
 *
 * @author jp015
 */
public class FelizBirdController  extends Controller implements Initializable
{

    @FXML
    private Label lblF2;
    @FXML
    private Label lblF1;
    @FXML
    private ImageView imgCumplea;
    @FXML
    private ImageView imgcake;
    @FXML
    private ImageView imgf;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url , ResourceBundle rb)
    {
        //new GlowBackground(lblF2 , Color.rgb(114 , 163 , 209) , Color.rgb(92 , 118 , 215) , 50).setCycleCount(400).play();
        new Shake(lblF2).setSpeed(0.2).setCycleCount(Integer.MAX_VALUE).play();
        new GlowText(lblF2 , Color.rgb(190 , 77 , 80) , Color.rgb(166 , 124 , 196)).setCycleCount(Integer.MAX_VALUE).play();

        new SlideInRight(imgCumplea).setSpeed(0.4).setCycleCount(1).play();
        new Shake(imgCumplea).setDelay(Duration.seconds(2)).setSpeed(0.2).setCycleCount(Integer.MAX_VALUE).play();
        
        new LightSpeedIn(imgf).setSpeed(0.2).setCycleCount(1).play();
        
        new SlideInLeft(imgcake).setSpeed(0.4).setCycleCount(1).play();
        new Shake(imgcake).setDelay(Duration.seconds(2)).setSpeed(0.2).setCycleCount(Integer.MAX_VALUE).play();

        new Shake(lblF1).setSpeed(0.2).setCycleCount(Integer.MAX_VALUE).play();
        new GlowText(lblF1 , Color.rgb(190 , 77 , 80) , Color.rgb(166 , 124 , 196)).setCycleCount(Integer.MAX_VALUE).play();

    }

    @Override
    public void initialize()
    {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

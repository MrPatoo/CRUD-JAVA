package Controlador;

import Modelo.Visitas;
import Vista.frmVisitas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

//heredarde la clase que detecta las acciones
public class ctrlVisitas implements MouseListener{
    
    //1. mandar a llamar a las otras capas(modelo y vista)
    
    private Visitas modelo;
    private frmVisitas vista;
    
    //2. crear constructor
    public ctrlVisitas (Visitas modelo, frmVisitas Vista){
        this.modelo = modelo;
        this.vista = vista;
        
        vista.btnAgregar.addMouseListener(this);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == vista.btnAgregar){
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setEspecialidad(vista.txtEspecialidad.getName());
            
            modelo.Guardar();
            
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       
    }
    
}

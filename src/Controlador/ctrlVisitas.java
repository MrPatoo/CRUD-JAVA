package Controlador;

import Modelo.Visitas;
import Vista.frmVisitas;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;

//heredarde la clase que detecta las acciones
public class ctrlVisitas implements MouseListener, KeyListener{
    
    //1. mandar a llamar a las otras capas(modelo y vista)
    
    private Visitas modelo;
    private frmVisitas vista;
    
    //2. crear constructor
    public ctrlVisitas (Visitas modelo, frmVisitas Vista){
        this.modelo = modelo;
        this.vista = Vista;
       
        vista.btnAgregar.addMouseListener(this);
        modelo.Mostrar(vista.jtbPaciente);
        vista.btnEliminar.addMouseListener(this);
        vista.jtbPaciente.addMouseListener(this);
        vista.btnActualizar.addMouseListener(this);
        vista.btnLimpiar.addMouseListener(this);
        vista.btnBuscar.addKeyListener(this);
        vista.txtBuscar.addKeyListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(e.getSource() == vista.btnAgregar){
            modelo.setNombre(vista.txtNombre.getText());
            modelo.setEdad(Integer.parseInt(vista.txtEdad.getText()));
            modelo.setEspecialidad(vista.txtEspecialidad.getText());
            
            modelo.Guardar();
            modelo.Mostrar(vista.jtbPaciente);
        }
        
        if(e.getSource() == vista.btnEliminar)
        {
            modelo.Eliminar(vista.jtbPaciente);
            modelo.Mostrar(vista.jtbPaciente);
        }


       if(e.getSource() == vista.jtbPaciente){
           modelo.cargarDatosTabla(vista);
            
        }
       
       if(e.getSource()== vista.btnActualizar){
           modelo.setNombre(vista.txtNombre.getText());
           modelo.setEdad(Integer.parseInt(vista.txtEdad.getText()));
           modelo.setEspecialidad(vista.txtEspecialidad.getText());
           
           modelo.Actualizar(vista.jtbPaciente);
           modelo.Mostrar(vista.jtbPaciente);
       }
       
       if(e.getSource() == vista.btnLimpiar){
           modelo.LimpiarDatos(vista);
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

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getSource() == vista.txtBuscar){
            modelo.Buscar(vista.jtbPaciente, vista.txtBuscar);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}

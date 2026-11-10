
package paquete1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow extends JFrame {
    private JList<Name> listaNombres;
    private DefaultListModel<Name> modelo;
    private JButton botonEliminarTodo;

    public MainWindow() {
        modelo = new DefaultListModel<>();
        initComponentes();
    }

    private void initComponentes() {
        setTitle("Mostrar Nombres");
        setSize(300, 400);
        setLocationRelativeTo(null);

        //Agregar algunos nombres al modelo
        modelo.addElement(new Name("Juan"));
        modelo.addElement(new Name("Pedro"));
        modelo.addElement(new Name("Ana"));

        listaNombres = new JList<>(modelo);
        listaNombres.addMouseListener(new MouseHandler());
        
        botonEliminarTodo = new JButton("Eliminar Todo");
        botonEliminarTodo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                modelo.clear();
            }
        });

        add(new JScrollPane(listaNombres), BorderLayout.CENTER);
        add(botonEliminarTodo, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class MouseHandler extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            JList<Name> lista = (JList<Name>) e.getSource();
            if (e.getClickCount() == 2) {
                int indice = lista.locationToIndex(e.getPoint());
                new EnterView(indice).setVisible(true);
            }
        }
    }

    class EnterView extends JDialog {
        private JTextField campoNombre;
        private JButton botonAceptar;
        private JButton botonCancelar;
        private JButton botonEliminar;
        private int indice;

        public EnterView(int indice) {
            this.indice = indice;
            initComponentes();
            
            if (indice >= 0) {
                //Si se está editando, cargamos el nombre en el campo
                Name nombre = modelo.getElementAt(indice);
                campoNombre.setText(nombre.getName());
                botonEliminar.setEnabled(true);
            } else {
                //Si se está creando un nuevo nombre, limpiamos el campo
                campoNombre.setText("");
                botonEliminar.setEnabled(false);
            }
        }

        private void initComponentes() {
            setTitle("Ingresar Nombre");
            setSize(300, 150);
            setLocationRelativeTo(null);

            campoNombre = new JTextField();
            botonAceptar = new JButton("Aceptar");
            botonCancelar = new JButton("Cancelar");
            botonEliminar = new JButton("Eliminar");

            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2));
            panel.add(new JLabel("Nombre:"));
            panel.add(campoNombre);
            panel.add(botonAceptar);
            panel.add(botonCancelar);

            add(panel, BorderLayout.CENTER);
            add(botonEliminar, BorderLayout.SOUTH);

            botonAceptar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    aceptar();
                }
            });

            botonCancelar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dialogoCerrado();
                }
            });

            botonEliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    eliminar();
                }
            });
        }

        public void aceptar() {
            if (indice >= 0) {
                //Si el índice es positivo, estamos editando un nombre
                Name nombre = modelo.getElementAt(indice);
                nombre.setName(campoNombre.getText());
                modelo.set(indice, nombre); 
            } else {
                //Si el índice es negativo, estamos creando un nuevo nombre
                Name nuevoNombre = new Name(campoNombre.getText());
                modelo.addElement(nuevoNombre);
            }
            dialogoCerrado();
        }

        private void eliminar() {
            if (indice >= 0) {
                //Si el índice es positivo, estamos eliminando un nombre
                modelo.remove(indice);
                dialogoCerrado();
            }
        }

        private void dialogoCerrado() {
            setVisible(false);
            dispose();
        }
    }

    class Name {
        private String name;

        public Name(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}




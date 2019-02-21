/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tree;

import app.Cliente;
import app.GraficaBarra;
import app.GraficaLinea;
import app.Tool;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ozmarescobar
 */
public class Galeria {
    
    public Valor titulo;
    LinkedList<Valor> nombres;

    public Galeria(Valor titulo, LinkedList<Valor> nombres) {
        this.titulo = titulo;
        this.nombres = nombres;
    }

    public void setNombres(LinkedList<Valor> nombres) {
        this.nombres = nombres;
    }

    public void setTitulo(Valor titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString()
    {
        String text = "<Galeria Path: " + titulo.toString() + ", lista_graficas: " + nombres.toString() + ">";
        return text;
    }
    
    public boolean ejecutar(LinkedList<Declaracion> globales, LinkedList<Grafica> graficas)
    {
        boolean errorSemantico = false;
        boolean variableExiste = false;
        switch(titulo.tipo)
        {
            case STRING:
                break;
            case IDENTIFICADOR:
                for (Declaracion d : globales)
                {
                    if(titulo.valor.equals(d.identificador))
                    {
                        variableExiste = true;
                        if(d.tipo == Declaracion.Tipo.STRING)
                        {
                            titulo.valor = d.valor;
                        }
                        else
                        {
                            errorSemantico = true;
                        }
                        break;
                    }
                }
                if(!variableExiste)
                    errorSemantico = true;
                break;
            default:
                errorSemantico = true;
        }
        if(!errorSemantico)
        {
            for (Valor v : nombres)
            {
                if(v.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(v.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                v.tipo = d.valor.tipo;
                                v.valor = d.valor.valor;
                            }
                            else
                            {
                                errorSemantico = true;
                            }
                            break;
                        }
                    }
                    if(!variableExiste)
                        errorSemantico = true;
                }
                else if(v.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
            }
        }
        if(!errorSemantico)
        {
            for (Valor v : nombres)
            {
                boolean vContained = false;
                for (Grafica g : graficas) 
                {
                    if(v.valor.equals(g.getID().valor))
                    {
                        vContained = true;
                        break;
                    }
                }
                if(!vContained)
                {
                    errorSemantico = true;
                    break;
                }
            }
        }
        
        
        if(!errorSemantico)//generacion de graficas, en este punto todo esta validado
        {
            File f;
            try
            {
                f = Tool.crearDirectorio("./" + titulo.valor.toString());
            
                for (Valor v : nombres)
                {
                    for (Grafica g : graficas)
                    {
                        if(v.valor.equals(g.getID().valor))
                        {
                            System.out.println(f.getCanonicalPath()+ "/");
                            switch(g.tipo)
                            {
                                case BARRA:
                                    GraficaBarra.generarGrafica(f.getCanonicalPath() + "/", g);
                                    break;
                                case LINEA:
                                    GraficaLinea.generarGrafica(f.getCanonicalPath() + "/", g);
                                    break;

                            }
                        }
                    }
                }
            }
            catch(IOException e)
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
        return errorSemantico;
    }
}

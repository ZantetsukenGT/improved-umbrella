/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tree;

import java.util.LinkedList;

/**
 *
 * @author ozmarescobar
 */
public class Grafica {
    
    public static enum Tipo
    {
        LINEA,
        BARRA
    }
    
    public final Tipo tipo;
    public LinkedList<Caracteristica> caracteristicas;
    
    public Grafica(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString()
    {
        String text = "<Grafica, Tipo: " + tipo.toString() + ", caracteristicas: " + caracteristicas.toString() + ">";
        return text;
    }
    
    public Valor getID()
    {
        Valor v = null;
        for(Caracteristica c: caracteristicas)
        {
            if(c.identificador == Caracteristica.Tipo.ID)
            {
                v = c.valor;
            }
        }
        return v;
    }
    
    public boolean ejecutar(LinkedList<Declaracion> globales)
    {
        boolean errorSemantico = false;
        boolean f1 = false;
        boolean f2 = false;
        boolean f3 = false;
        boolean f4 = false;
        boolean f5 = false;
        boolean f6 = false;
        boolean f7 = false;
        boolean f8 = false;
        boolean f9 = false;
        boolean f10 = false;
        boolean f11 = false;
        boolean f12 = false;
        
        for(Caracteristica c: caracteristicas)
        {
            switch(c.identificador)
            {
                case ID:
                    f1 = true;
                    break;
                case TITULO:
                    f2 = true;
                    break;
                case TITULOX:
                    f3 = true;
                    break;
                case TITULOY:
                    f4 = true;
                    break;
                case EJEX:
                    f5 = true;
                    break;
                case EJEY:
                    f6 = true;
                    break;
                case PUNTOSXY:
                    f7 = true;
                    break;
                case NOMBRE:
                    f8 = true;
                    break;
                case COLOR:
                    f9 = true;
                    break;
                case GROSOR:
                    f10 = true;
                    break;
                case PUNTOS:
                    f11 = true;
                    break;
                case DEFINIRXYLINE:
                    f12 = true;
                    break;
            }
        }
        switch(tipo)
        {
            case LINEA:
                if(f1 && f2 && f3 && f4 && f12)
                {
                    for (Caracteristica c : caracteristicas)
                    {
                        switch(c.identificador)
                        {
                            case ID:
                            case TITULO:
                            case TITULOX:
                            case TITULOY:
                            case DEFINIRXYLINE:
                                errorSemantico = c.ejecutar(globales);
                                break;
                            default:
                                errorSemantico = true;
                        }
                        if(errorSemantico)
                            break;
                    }
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case BARRA:
                if(f1 && f2 && f3 && f4 && f5 && f6 && f7)
                {
                    for (Caracteristica c : caracteristicas)
                    {
                        switch(c.identificador)
                        {
                            case ID:
                            case TITULO:
                            case TITULOX:
                            case TITULOY:
                            case EJEX:
                            case EJEY:
                            case PUNTOSXY:
                                errorSemantico = c.ejecutar(globales);
                                break;
                            default:
                                errorSemantico = true;
                        }
                        if(errorSemantico)
                            break;
                    }
                }
                else
                {
                    errorSemantico = true;
                }
                break;
        }
        return errorSemantico;
    }
}

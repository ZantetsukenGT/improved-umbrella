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
public class Caracteristica {
    
    public static enum Tipo
    {
        ID,
        TITULO,
        EJEX,
        EJEY,
        PUNTOSXY,
        TITULOX,
        TITULOY,
        NOMBRE,
        COLOR,
        GROSOR,
        PUNTOS,
        DEFINIRXYLINE
    }
    
    public final Tipo identificador;
    public Valor valor;

    public Caracteristica(Tipo identificador, Valor valor) {
        this.identificador = identificador;
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        String text = "<Caracteristica Id: " + identificador.toString() + ", valor: " + valor.toString() + ">";
        return text;
    }
    
    public boolean ejecutar(LinkedList<Declaracion> globales)
    {
        boolean errorSemantico = false;
        switch(identificador)
        {
            case ID:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case TITULO:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case EJEX:
                if(valor.tipo == Valor.Tipo.ARREGLO)
                {
                    LinkedList<Valor> valores = (LinkedList<Valor>)valor.valor;
                    for (Valor v : valores)
                    {
                        if(v.tipo == Valor.Tipo.IDENTIFICADOR)
                        {
                            boolean variableExiste = false;
                            for (Declaracion d : globales) {
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
                            {
                                errorSemantico = true;
                            }
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
                else
                {
                    errorSemantico = true;
                }
                break;
            case EJEY:
                if(valor.tipo == Valor.Tipo.ARREGLO)
                {
                    LinkedList<Valor> valores = (LinkedList<Valor>)valor.valor;
                    for (Valor v : valores)
                    {
                        if(v.tipo == Valor.Tipo.IDENTIFICADOR)
                        {
                            boolean variableExiste = false;
                            for (Declaracion d : globales) {
                                if(v.valor.equals(d.identificador))
                                {
                                    variableExiste = true;
                                    if(d.tipo == Declaracion.Tipo.ENTERO)
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
                        else if(v.tipo == Valor.Tipo.ENTERO)
                        {

                        }
                        else
                        {
                            errorSemantico = true;
                        }
                    }
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case PUNTOSXY:
                if(valor.tipo == Valor.Tipo.ARREGLO)
                {
                    LinkedList<Valor> valores = (LinkedList<Valor>)valor.valor;
                    for (Valor v : valores)
                    {
                        if(v.tipo == Valor.Tipo.ARREGLO)
                        {
                            LinkedList<Valor> parDeEnteros = (LinkedList<Valor>)v.valor;
                            
                            if(parDeEnteros.size() == 2)
                            {
                                for(Valor num: parDeEnteros)
                                {
                                    if(num.tipo == Valor.Tipo.IDENTIFICADOR)
                                    {
                                        boolean variableExiste = false;
                                        for (Declaracion d : globales)
                                        {
                                            if(num.valor.equals(d.identificador))
                                            {
                                                variableExiste = true;
                                                if(d.tipo == Declaracion.Tipo.ENTERO)
                                                {
                                                    num.tipo = d.valor.tipo;
                                                    num.valor = d.valor.valor;
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
                                    else if(num.tipo == Valor.Tipo.ENTERO)
                                    {

                                    }
                                    else
                                    {
                                        errorSemantico = true;
                                    }
                                }
                            }
                            else
                            {
                                errorSemantico = true;
                            }
                        }
                        else
                        {
                            errorSemantico = true;
                        }
                    }
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case TITULOX:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case TITULOY:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case NOMBRE:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case COLOR:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.STRING)
                            {
                                valor = d.valor;
                                switch(((String)valor.valor).toLowerCase())
                                {
                                    case "rojo":
                                    case "amarillo":
                                    case "naranja":
                                    case "azul":
                                    case "negro":
                                    case "verde":
                                        break;
                                    default:
                                        errorSemantico = true;
                                }
                                    
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
                else if(valor.tipo == Valor.Tipo.STRING)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case GROSOR:
                if(valor.tipo == Valor.Tipo.IDENTIFICADOR)
                {
                    boolean variableExiste = false;
                    for (Declaracion d : globales)
                    {
                        if(valor.valor.equals(d.identificador))
                        {
                            variableExiste = true;
                            if(d.tipo == Declaracion.Tipo.ENTERO)
                            {
                                valor = d.valor;
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
                else if(valor.tipo == Valor.Tipo.ENTERO)
                {
                    
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case PUNTOS:
                if(valor.tipo == Valor.Tipo.ARREGLO)
                {
                    LinkedList<Valor> valores = (LinkedList<Valor>)valor.valor;
                    for (Valor v : valores)
                    {
                        if(v.tipo == Valor.Tipo.ARREGLO)
                        {
                            LinkedList<Valor> parDeEnteros = (LinkedList<Valor>)v.valor;
                            
                            if(parDeEnteros.size() == 2)
                            {
                                for(Valor num: parDeEnteros)
                                {
                                    if(num.tipo == Valor.Tipo.IDENTIFICADOR)
                                    {
                                        boolean variableExiste = false;
                                        for (Declaracion d : globales)
                                        {
                                            if(num.valor.equals(d.identificador))
                                            {
                                                variableExiste = true;
                                                if(d.tipo == Declaracion.Tipo.ENTERO)
                                                {
                                                    num.tipo = d.valor.tipo;
                                                    num.valor = d.valor.valor;
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
                                    else if(num.tipo == Valor.Tipo.ENTERO)
                                    {

                                    }
                                    else
                                    {
                                        errorSemantico = true;
                                    }
                                }
                            }
                            else
                            {
                                errorSemantico = true;
                            }
                        }
                        else
                        {
                            errorSemantico = true;
                        }
                    }
                }
                else
                {
                    errorSemantico = true;
                }
                break;
            case DEFINIRXYLINE:
                if(valor.tipo == Valor.Tipo.XYLINE)
                {
                    boolean f1 = false;
                    boolean f2 = false;
                    boolean f3 = false;
                    boolean f4 = false;
                    for(Caracteristica c: (LinkedList<Caracteristica>)valor.valor)
                    {
                        switch(c.identificador)
                        {
                            case NOMBRE:
                                f1 = true;
                                break;
                            case COLOR:
                                f2 = true;
                                break;
                            case GROSOR:
                                f3 = true;
                                break;
                            case PUNTOS:
                                f4 = true;
                                break;
                        }
                    }
                    for (Caracteristica c : (LinkedList<Caracteristica>)valor.valor)
                    {
                        if(f1 && f2 && f3 && f4)
                        {
                            switch(c.identificador)
                            {
                                case NOMBRE:
                                case COLOR:
                                case GROSOR:
                                case PUNTOS:
                                    errorSemantico = c.ejecutar(globales);
                                    break;
                                default:
                                    errorSemantico = true;
                            }
                            if(errorSemantico)
                                break;
                        }
                        else
                        {
                            errorSemantico = true;
                        }
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

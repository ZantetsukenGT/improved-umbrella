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
public class Declaracion {

    public static enum Tipo
    {
        ENTERO,
        STRING
    }
    
    public final Tipo tipo;
    public String identificador;
    public Valor valor;

    public Declaracion(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        String text = "<Declaracion Tipo: " + tipo.toString() + ", Id: " + identificador + " valor: " + valor.toString() + ">";
        return text;
    }
    
    public boolean ejecutar()
    {
        boolean errorSemantico = false;
        switch(tipo)
        {
            case ENTERO:
                if(valor.tipo != Valor.Tipo.ENTERO)
                {
                    errorSemantico = true;
                }
                break;
            case STRING:
                if(valor.tipo != Valor.Tipo.STRING)
                {
                    errorSemantico = true;
                }
                break;
        }
        return errorSemantico;
    }
    
    
}

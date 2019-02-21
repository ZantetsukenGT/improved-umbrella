/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.tree;

/**
 *
 * @author ozmarescobar
 */
public class Valor {
    
    public static enum Tipo
    {
        ARREGLO,
        ENTERO,
        STRING,
        IDENTIFICADOR,
        XYLINE
    }
    
    public Tipo tipo;
    public Object valor;

    public Valor(Object valor, Tipo tipo) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString()
    {
        String text = "<Valor Tipo: " + tipo.toString() + ", valor: " + valor.toString() + ">";
        return text;
    }
    
    
    
}

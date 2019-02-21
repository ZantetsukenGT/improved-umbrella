/* ==================
 * BarChartDemo1.java
 * ==================
 *
 * Copyright (c) 2005-2014, Object Refinery Limited.
 * All rights reserved.
 *
 * http://www.jfree.org/jfreechart/index.html
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   - Neither the name of the Object Refinery Limited nor the
 *     names of its contributors may be used to endorse or promote products
 *     derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE 
 * ARE DISCLAIMED. IN NO EVENT SHALL OBJECT REFINERY LIMITED BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   -;
 *
 * Changes
 * -------
 * 09-Mar-2005 : Version 1 (DG);
 * 11-Mar-2014 : Use new ChartFactory method (DG);
 * 25-Jun-2014 : Update to use real data (DG);
 * 
 */
package app;

import app.tree.*;
import java.awt.Color;
import java.io.File;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaBarra
{
    /**
     * Creates a sample chart.
     *
     * @param dataset the dataset.
     * @param titulo  titulo de grafica.
     * @param tituloX  titulo de eje horizontal.
     * @param tituloY   titulo de eje vertical.
     *
     * @return The chart.
     */
    private static JFreeChart createChart(CategoryDataset dataset, String titulo, String tituloX, String tituloY)
    {
        JFreeChart chart = ChartFactory.createBarChart(titulo, tituloX , tituloY, dataset);
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();

        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        return chart;
    }

    public static boolean generarGrafica(String directorio, Grafica g)
    {
        boolean errorSemantico = false;
        String titulo = "";
        String tituloX = "";
        String tituloY = "";
        LinkedList<Valor> ejeX = null;
        LinkedList<Valor> ejeY = null;
        LinkedList<Valor> puntosXY = null;
        
        for(Caracteristica c: g.caracteristicas)
        {
            switch(c.identificador)
            {
                case ID:
                    directorio += c.valor.valor.toString();
                    break;
                case TITULO:
                    titulo = c.valor.valor.toString();
                    break;
                case TITULOX:
                    tituloX = c.valor.valor.toString();
                    break;
                case TITULOY:
                    tituloY = c.valor.valor.toString();
                    break;
                case EJEX:
                    ejeX = (LinkedList<Valor>) c.valor.valor;
                    break;
                case EJEY:
                    ejeY = (LinkedList<Valor>) c.valor.valor;
                    break;
                case PUNTOSXY:
                    puntosXY = (LinkedList<Valor>) c.valor.valor;
                    break;
            }
        }
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        JFreeChart chart = createChart(dataset, titulo, tituloX, tituloY);
        for (int i = 0; i < puntosXY.size(); i++)
        {
            LinkedList<Valor> puntoXY = (LinkedList<Valor>) puntosXY.get(i).valor;
            dataset.setValue((Number) ejeY.get((Integer)puntoXY.get(1).valor).valor, ejeX.get((Integer)puntoXY.get(0).valor).valor.toString(), ejeX.get((Integer)puntoXY.get(0).valor).valor.toString());
        }

        try
        {
            ChartUtilities.saveChartAsJPEG(new File(directorio + ".jpeg"), chart, 800, 600);
        } catch (Exception e)
        {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
        }
        return errorSemantico;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.tree.*;
import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.*;
import org.jfree.chart.ChartFactory; 
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.JFreeChart; 
import org.jfree.chart.ChartUtilities; 
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

/**
 *
 * @author ozmarescobar
 */
public class GraficaLinea {
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

    private static JFreeChart createChart(XYSeriesCollection dataset, String titulo, String tituloX, String tituloY)
    {
        JFreeChart chart = ChartFactory.createXYLineChart(titulo, tituloX, tituloY, dataset, PlotOrientation.VERTICAL, true, true, false);
        chart.setBackgroundPaint(Color.white);
        XYPlot plot = (XYPlot) chart.getXYPlot();

        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
        renderer.setBaseShapesFilled(true);
        renderer.setBaseShapesVisible(true);
        return chart;
    }

    public static boolean generarGrafica(String directorio, Grafica g)
    {
        boolean errorSemantico = false;
        String titulo = "";
        String tituloX = "";
        String tituloY = "";
        
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
                case DEFINIRXYLINE:
                    break;
            }
        }
        
        
        XYSeriesCollection dataset= new XYSeriesCollection();
        JFreeChart chart = createChart(dataset, titulo, tituloX, tituloY);
        XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) chart.getXYPlot().getRenderer();
        
        
        double size = 8.0;
        double delta = size / 2.0;
        for(Caracteristica c: g.caracteristicas)
        {
            if(c.identificador == Caracteristica.Tipo.DEFINIRXYLINE)
            {
                LinkedList<Caracteristica> caracteristicasXYLine = (LinkedList<Caracteristica>)c.valor.valor;
                
                String nombre = "";
                Color color = null;
                String grosor = "";
                LinkedList<Valor> puntos = null;
                for (Caracteristica cXY : caracteristicasXYLine)
                {
                    switch(cXY.identificador)
                    {
                        case NOMBRE:
                            nombre = cXY.valor.valor.toString();
                            break;
                        case COLOR:
                            System.out.print(((String)cXY.valor.valor).toLowerCase());
                            switch(((String)cXY.valor.valor).toLowerCase())
                            {
                                case "rojo":
                                    color = Color.RED;
                                    break;
                                case "amarillo":
                                    color = Color.YELLOW;
                                    break;
                                case "naranja":
                                    color = Color.ORANGE;
                                    break;
                                case "azul":
                                    color = Color.BLUE;
                                    break;
                                case "negro":
                                    color = Color.BLACK;
                                    break;
                                case "verde":
                                    color = Color.GREEN;
                                    break;
                                default:
                                    errorSemantico = true;
                            }
                            break;
                        case GROSOR:
                            grosor = cXY.valor.valor.toString();
                            break;
                        case PUNTOS:
                            puntos = (LinkedList<Valor>)cXY.valor.valor;
                            break;
                    }
                    if(errorSemantico)
                        break;
                }
                if(errorSemantico)
                    break;
                
                XYSeries linea = new XYSeries(nombre);
                for (int i = 0; i < puntos.size(); i++)
                {
                    LinkedList<Valor> punto = (LinkedList<Valor>)puntos.get(i).valor;
                    linea.add((Integer)punto.get(0).valor,(Integer)punto.get(1).valor);
                }

                dataset.addSeries(linea);
                BasicStroke stroke = new BasicStroke(Float.valueOf(grosor));
                
                Shape rect = new Rectangle2D.Double(-delta, -delta, size, size);
                renderer.setSeriesStroke(dataset.getSeriesCount() - 1, stroke);
                renderer.setSeriesPaint(dataset.getSeriesCount() - 1, color);
                renderer.setSeriesShape(dataset.getSeriesCount() - 1, rect);
            }
        }
        System.out.println(" "  + errorSemantico);
        if(!errorSemantico)
        {
            try 
            {
                ChartUtilities.saveChartAsJPEG(new File(directorio + ".jpeg"), chart, 800, 600);
            }
            catch (IOException e)
            {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return errorSemantico;
    }
}

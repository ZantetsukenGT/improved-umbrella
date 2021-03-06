package gu.language;

/**
 * 
 * @author ozmarescobar
 */
public class ErrorAnalisis {
    String gravedad;
    String token;
    String descripcion;
    int linea;
    int columna;
    
    public ErrorAnalisis(String gravedad,String token, String descripcion, int linea, int columna){
        this.gravedad = gravedad;
        this.token = token;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }
    
    @Override
    public String toString()
    {
        String text = ""
                + "\t\t\t\t\t<td>" + gravedad + "</td>\n"
                + "\t\t\t\t\t<td>" + token + "</td>\n"
                + "\t\t\t\t\t<td>" + linea + "</td>\n"
                + "\t\t\t\t\t<td>" + columna + "</td>\n"
                + "\t\t\t\t\t<td>" + descripcion + "</td>\n";
        return text;
    }
}

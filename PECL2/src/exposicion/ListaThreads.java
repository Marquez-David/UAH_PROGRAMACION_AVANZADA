package exposicion;
import java.util.*;
import javax.swing.JTextField;

/* La clase ListaThreads permite gestionar las listas de threads en los monitores,
con métodos para meter y sacar threads en ella. Cada vez que una lista se modifica,
se imprime su nuevo contenido en el JTextField que toma como parámetro el constructor. */
public class ListaThreads {
    ArrayList<Thread> lista;
    JTextField tf;
    
    public ListaThreads(JTextField tf)
    {
        lista=new ArrayList<Thread>();
        this.tf=tf;
    }
    
    public synchronized void meter(Thread t)
    {
        lista.add(t);
        imprimir();
    }
    
    public synchronized void sacar(Thread t)
    {
        lista.remove(t);
        imprimir();
    }
    
    public void imprimir()
    {
        String contenido="";
        for(int i=0; i<lista.size(); i++)
        {
           contenido=contenido+lista.get(i).getName()+" ";
        }
        tf.setText(contenido);
    }
}

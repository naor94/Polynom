package myMath;

import java.awt.Color;


import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class DrawGraph extends JFrame {
    public DrawGraph(Polynom p,double X,double Y) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        // Insert rest of the code here
        
        DataTable data = new DataTable(Double.class, Double.class);
        DataTable maxmin = new DataTable(Double.class, Double.class);

        for (double x = X; x <=Y; x+=0.001) {
            double y = p.f(x);
            if (p.derivative().f(x)<0.01&& p.derivative().f(x)>-0.01) {
            	maxmin.add(x,y);}
            data.add(x, y);
        }
        
        XYPlot points = new XYPlot(maxmin);	
        getContentPane().add(new InteractivePanel(points));
    
        XYPlot plot = new XYPlot(data,maxmin);
        getContentPane().add(new InteractivePanel(plot));   
        
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
        
        Color color = new Color(0.0f, 0.8f, 0.1f); 
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        
    }
    
   
   
    public static void main(String[] args) {
    	Polynom p=new Polynom("0.2*x^4-1.5*x^3+3.0*x^2-1*x^1-5*x^0");
        DrawGraph frame = new DrawGraph(p,-2,6);
        frame.setVisible(true);
    }
}
package myMath;

import java.awt.Color;


import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
/*
 * this class has consructor that get 3 arguments:
 *  Object Polynom, int x, int y. The constructor gets the Polynom amd the range that difined by x and y and 
 *  draws the graph between the range. It also indicates the extreme points of the graph
 

 *@author Naor eliav and michael garusi.
 */
public class LinePlotTest extends JFrame {
    public LinePlotTest(Polynom p,double x,double x1) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        // Insert rest of the code here
        
        DataTable data = new DataTable(Double.class, Double.class); // contains the points to build the graph
        DataTable maxmin = new DataTable(Double.class, Double.class); // contains the min max points

          // loop that runs over the function points at range, and saves them 
        for (; x <=x1; x+=0.001) { 
            double y = p.f(x);		// saves y value using the f function of polynom
            if (p.derivative().f(x)<0.01&& p.derivative().f(x)>-0.01) {  // calculates and saves the min max points
            	maxmin.add(x,y);}
            data.add(x, y); // add the polynom points to the collection
        }
        
        XYPlot points = new XYPlot(maxmin);	//plot of min max points
        getContentPane().add(new InteractivePanel(points));
    
        XYPlot plot = new XYPlot(data,maxmin);// common plot of the polynom graph, and the points
        getContentPane().add(new InteractivePanel(plot));   
        
        LineRenderer lines = new DefaultLineRenderer2D(); // using the line function to create a graph from the ' data' points
        plot.setLineRenderers(data, lines);
        
       Color color = new Color(0.0f, 0.8f, 0.1f);  //sets the colors, polynom graph - green, point - black
        plot.getPointRenderers(data).get(0).setColor(color);
        plot.getLineRenderers(data).get(0).setColor(color);
        
    }
    
   
   
    public static void main(String[] args) {
    	Polynom p=new Polynom("0.2*x^4-1.5*x^3+3.0*x^2-1*x^1-5*x^0"); // creats a polynom 
        
    	// calls to a plot construction, input: 1.p- polynom. 2.the range of the polynom display in the graph
    	LinePlotTest frame = new LinePlotTest(p,-2,6);				   
        
    	frame.setVisible(true); // display the polynom graph 
    }
}
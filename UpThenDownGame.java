import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**

   Exam 2 animation question.

   @author Jim Teresco
   @version Spring 2020
*/

public class UpThenDownGame extends MouseAdapter implements Runnable {

    // list of up/down ball objects currently on the screen
    private java.util.List<UpDownBall> list;
    
    private JPanel panel;

    /**
       The run method to set up the graphical user interface
    */
    @Override
    public void run() {
	
	JFrame.setDefaultLookAndFeelDecorated(true);
	JFrame frame = new JFrame("UpThenDownGame");
	frame.setPreferredSize(new Dimension(800,800));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// JPanel with a paintComponent method
	panel = new JPanel() {
		@Override
		public void paintComponent(Graphics g) {
		    
		    super.paintComponent(g);

		    // display the Up/Down Ball objects
		    for (UpDownBall b : list) {
			b.paint(g);
		    }
		}
	    };
	frame.add(panel);
	panel.addMouseListener(this);

	list = new ArrayList<UpDownBall>();
	
	frame.pack();
	frame.setVisible(true);
    }

    /**
       Mouse press event handler to create a new UpDownBall centered
       at the press point.

       @param e mouse event info
    */
    @Override
    public void mousePressed(MouseEvent e) {

	list.add(new UpDownBall(e.getPoint(), panel));
	panel.repaint();
    }

    /**
       Mouse release event handler that will cause the just-created ball
       to stop moving up and start moving down.

       @param e mouse event info
    */
    @Override
    public void mouseReleased(MouseEvent e) {


    }
    
    public static void main(String args[]) {

	javax.swing.SwingUtilities.invokeLater(new UpThenDownGame());
    }
}
   

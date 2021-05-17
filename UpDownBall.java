import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
   The UpDownBall class is responsible for managing the life of one
   ball that moves up the screen, then down, and stopping when it
   reaches the bottom of the window.
*/
class UpDownBall extends Thread {

    // ball size
    public static final int SIZE = 50;

    // delay time between frames of animation (ms)
    public static final int DELAY_TIME = 33;

    // pixels to move each frame
    public static final int Y_SPEED = 4;

    // latest location of the ball
    private Point upperLeft;

    // how far to fall?
    private int bottom;

    // who do we live in so we can repaint?
    private JComponent container;

    /**
       Construct a new UpDownBall object.

       @param startCenter the initial point at which the center of the
       ball should be drawn
       @param container the Swing component in which this ball is being
       drawn to allow it to call that component's repaint method
    */
    public UpDownBall(Point startCenter, JComponent container) {

	upperLeft = new Point(startCenter.x - SIZE/2, startCenter.y - SIZE/2);
	this.bottom = container.getHeight();
	this.container = container;
    }

    /**
       Draw the ball at its current location.

       @param g the Graphics object on which the ball should be drawn
    */
    public void paint(Graphics g) {

	g.fillOval(upperLeft.x, upperLeft.y, SIZE, SIZE);
    }

    /**
       This object's run method, which manages the life of the ball as it
       moves up and then down the screen.
    */
    @Override
    public void run() {

    }

}


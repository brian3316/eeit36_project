package tw.brian.winbuilder;

import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import tw.brian.winbuilder.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class Jslider1 extends JComponent implements ChangeListener {

    JPanel gui;
    //display image
    JLabel imageCanvas;
    Dimension size;
    double scale = 1.0;
    public BufferedImage image;

    public Jslider1() {
        size = new Dimension(10, 10);
        setBackground(Color.black);
        
        try {
            image = ImageIO.read(new URL("file:///C:/Users/user/eclipse-eeit36/eeit36_java/src/tw/brian/myproject/Taiwanview.jpg"));
        } catch (Exception ex) {
            if(image == null)
            {
            	JOptionPane.showMessageDialog(null, "圖片跑哪了!!!");
            	
            }
        	
        }
    }

    public void setImage(Image image) {
        imageCanvas.setIcon(new ImageIcon(image));
    }

    public void initComponents() {
        if (gui == null) {
            gui = new JPanel(new BorderLayout());
            gui.setBorder(new EmptyBorder(5, 5, 5, 5));
            imageCanvas = new JLabel();
            JPanel imageCenter = new JPanel(new GridBagLayout());
            imageCenter.add(imageCanvas);
            JScrollPane imageScroll = new JScrollPane(imageCenter);
            imageScroll.setPreferredSize(new Dimension(300, 100));
            gui.add(imageScroll, BorderLayout.CENTER);
        }
    }

    public Container getGui() {
        initComponents();
        return gui;
    }

    public void stateChanged(ChangeEvent e) {
        int value = ((JSlider) e.getSource()).getValue();
        scale = value / 100.0;
        paintImage();
    }

    protected void paintImage() {
        int w = getWidth();
        int h = getHeight();
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();
        BufferedImage bi = new BufferedImage(
                (int)(imageWidth*scale), 
                (int)(imageHeight*scale), 
                image.getType());
        Graphics2D g2 = bi.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        double x = (w - scale * imageWidth) / 2;
        double y = (h - scale * imageHeight) / 2;
        AffineTransform at = AffineTransform.getTranslateInstance(0, 0);
        at.scale(scale, scale);
        g2.drawRenderedImage(image, at);
        setImage(bi);
    }

    public Dimension getPreferredSize() {
        int w = (int) (scale * size.width);
        int h = (int) (scale * size.height);
        return new Dimension(w, h);
    }

    public JSlider getControl()  {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0,1000,0);
        
        slider.setMajorTickSpacing(100);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(this);
        slider.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent evt) {
				
				if (evt.getWheelRotation() < 0 )//Picture zoom in and out
		        {
		            int NewValue = slider.getValue() - slider.getMinorTickSpacing()  ;
		            if (NewValue >= slider.getMinimum())
		            {
		            	slider.setValue(NewValue);
		            }
		            else
		            {
		            	slider.setValue(0);
		            }
		        }
		        else
		        {
		            int NewValue = slider.getValue() + slider.getMinorTickSpacing()  ;
		            if (NewValue <= slider.getMaximum())
		            {
		            	slider.setValue(NewValue);
		            }
		            else
		            {
		            	slider.setValue(slider.getMaximum());
		            }
		        }
			
			
			}});
        return slider;
    }
   
    
    
    public static void main(String[] args) {
//        Jslider1 app = new Jslider1();
       
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(app.getGui());
//        app.setImage(app.image);
//
//        // frame.getContentPane().add(new JScrollPane(app));  
//        frame.getContentPane().add(app.getControl(), "Last");
//        frame.setSize(1920,1080);
//        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//        //frame.setLocation(200, 200);
//        frame.setVisible(true);
    }

	
}

package view.components;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class PanelSlide extends javax.swing.JLayeredPane {

    private Animator animator;
    private float animate = 1.F;
    private boolean slideleft;

    public PanelSlide() {
        TimingTarget target = new TimingTargetAdapter(){
            @Override
            public void timingEvent(float fraction) {
                animate = fraction;
            }
        };
    }



    public void paint(Graphics graphics){
        super.paint(graphics);
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        float x=0;
        float y=0;
        int centerY = height/2;
        
        g2.dispose();
    }

    private float easeOutBounce(float x){
        float n1 = 7.5625f;
        float d1 = 2.75f;
        double result;
        if (x < 1 / d1) {
            result = n1 * x * x;
        } else if (x < 2 / d1) {
            result = n1 * (x -= 1.5 / d1) * x + 0.75;
        } else if (x < 2.5 / d1) {
            result = n1 * (x -= 2.25 / d1) * x + 0.9375;
        } else {
            result = n1 * (x -= 2.625 / d1) * x + 0.984375;
        }
        return (float) result;
    }

    private float easeOutQuint(float x) {
        double result;
        result = 1 - Math.pow(1 - x, 5);
        return (float) result;
    }
}

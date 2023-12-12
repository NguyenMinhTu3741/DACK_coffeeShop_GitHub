package view.components;
import utils.MySQLConnect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
// import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
public class JPanelSlide extends javax.swing.JLayeredPane{
    public void setFram(JFrame fram) {
        this.fram = fram;
    }
    private final Animator animator;
    private float animate = 1f;
    private boolean slideLeft;
    private final PanelLogin login;
    private final PanelLoading loading;
    private Thread th;
    private MigLayout layout;
    private JFrame fram;
    public PanelSlide() {
        initComponents();
        setPreferredSize(new Dimension(350, 450));
        layout = new MigLayout("inset 0", "[fill]", "[fill]");
        setLayout(layout);
        login = new PanelLogin();
        loading = new PanelLoading();
        loading.setVisible(false);
        Color color = new Color(67, 99, 132);
        setBackground(color);
        loading.setBackground(color);
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void begin() {
                if (slideLeft) {
                    loading.setVisible(true);
                } else {
                    login.setVisible(true);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                double width = getWidth();
                animate = fraction;
                float a = easeOutQuint(fraction);
                int x = (int) (a * width);
                loading.setAnimate(slideLeft, fraction);
                layout.setComponentConstraints(loading, "pos " + x + " 0 100% 100%");
                revalidate();
                repaint();
            }

            @Override
            public void end() {
                if (slideLeft) {
                    login.setVisible(false);
                } else {
                    loading.setVisible(false);
                    loading.reset();
                }
            }
        };
        animator = new Animator(1000, target);
        animator.setResolution(0);
        add(loading, " pos 0 0 0 0, w 0!");
        add(login);
        login.addEventLogin(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    if (login.checkUser()) {
                        showSlide(true);
                        login(login.getUserName(), login.getPassword());
                    }
                }
            }
        });
        loading.addEventContinue(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Main main = new Main();
                main.setData(loading.getData());
                main.setVisible(true);
                //  Close login form
                fram.dispose();
            }
        });
        loading.addEventBack(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    th.interrupt();
                    showSlide(false);
                }
            }
        });
    }
    public void showSlide(boolean show) {
        slideLeft = show;
        animator.start();
    }
    private void login(String userName, String password) {
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    String sql = "select UserID, UserName, `Profile` from `user` where BINARY(UserName)=? and BINARY(`Password`)=? limit 1";
                    PreparedStatement p = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
                    p.setString(1, userName);
                    p.setString(2, password);
                    ResultSet r = p.executeQuery();
                    if (r.first()) {
                        int id = r.getInt("UserID");
                        String user = r.getString("UserName");
                        Icon profile;
                        if (r.getObject("Profile") != null) {
                            profile = new ImageIcon(r.getBytes("Profile"));
                        } else {
                            profile = new ImageIcon(getClass().getResource("/com/raven/icon/user.png"));
                        }
                        ModelUser data = new ModelUser(id, user, profile);
                        loading.doneLogin(data);
                    } else {
                        loading.showError("User and Password Incorrect");
                    }
                    r.close();
                    p.close();

                } catch (InterruptedException e) {

                } catch (Exception e) {
                    loading.showError("Erro Server");
                }
            }
        });
        th.start();
    }
    @SuppressWarnings("unchecked")

}

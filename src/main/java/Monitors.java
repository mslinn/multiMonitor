import javax.swing.*;
import java.awt.*;
import java.util.stream.IntStream;

public class Monitors {
    static GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    static GraphicsDevice[] screens = ge.getScreenDevices();

    private void dumpScreenInfo(int i) {
        GraphicsDevice screen = screens[i];
        GraphicsConfiguration config = screen.getDefaultConfiguration();
        Rectangle bounds = config.getBounds();
        System.out.println("Screen #" + i + ": " + bounds);
    }

    private void showOnScreen(GraphicsDevice[] screens, int i) {
        GraphicsDevice screen = screens[i];
        JFrame jframe = new JFrame(screen.getDefaultConfiguration());
        if (i > -1 && i < screens.length)
            screen.setFullScreenWindow(jframe);
        else if (screens.length > 0)
            screens[0].setFullScreenWindow(jframe);
        else
            throw new RuntimeException("No Screens Found");
    }

    public static void main(String[] args) {
        Monitors monitors = new Monitors();
        IntStream.range(0, 5).forEachOrdered( i -> {
            monitors.dumpScreenInfo(i);
            //showOnScreen(i);
        });
    }
}

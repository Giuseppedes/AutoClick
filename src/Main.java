import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Main {

    private static int xButton;
    private static int yButton;

    private static int xProgressBar;
    private static int yProgressBar;
    private static Color progressBarColor;


    public static void main(String[] args) throws AWTException, InterruptedException {

        Robot robot = new Robot();

        System.out.println("Punta la progress bar");
        Thread.sleep(2000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);

        Point progressBarPosition = MouseInfo.getPointerInfo().getLocation();
        xProgressBar = (int) progressBarPosition.getX();
        yProgressBar = (int) progressBarPosition.getY();
        progressBarColor = robot.getPixelColor(xProgressBar, yProgressBar);

        System.out.println(xProgressBar + " - "  + yProgressBar + " / Colore: " + progressBarColor.toString());

        //individuo il punto finale della progress bar
        while (progressBarColor.equals(robot.getPixelColor(xProgressBar, yProgressBar))) {
            xProgressBar++;
        }
        xProgressBar--;

        System.out.println("Post Shift: " + xProgressBar + " - "  + yProgressBar);

        System.out.println("Punta il pulsante");
        Thread.sleep(2000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("1");
        Thread.sleep(1000);

        Point buttonPosition = MouseInfo.getPointerInfo().getLocation();
        xButton = (int) buttonPosition.getX();
        yButton = (int) buttonPosition.getY();

        System.out.println(xButton + " - "  + yButton);

        System.out.println("Buon divertimento!");

        moveAndClick(robot);

    }

    private static void moveAndClick(Robot robot) throws InterruptedException {

        //eseguo solo se il colore della progress bar non è uguale al colore iniziale
        if (!robot.getPixelColor(xProgressBar, yProgressBar).equals(progressBarColor)) {

            //aspetto un altro mezzo secondo, per sicurezza.
            Thread.sleep(500);

            //posizione attuale del mouse
            Point originalPointer = MouseInfo.getPointerInfo().getLocation();

            //sposto il mouse e clicco sul punto desiderato
            robot.mouseMove(xButton,yButton);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            //riporto il mouse alla posizione iniziale
            robot.mouseMove((int)originalPointer.getX(),(int)originalPointer.getY());
        }

        //aspetto X millisecondi e ripeto l'operazione
        Thread.sleep(5000); //millisecondi

        //chiamata ricorsiva
        moveAndClick(robot);

    }
}
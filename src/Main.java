import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Main {

  private static int xButton;
  private static int yButton;

  private static int xA;
  private static int yA;

  private static int xB;
  private static int yB;

  private static int screenshotRectangleWidth;
  private static int screenshotRectangleHeight;

  private static int index = 0;
  private static int pages = 230;
  private static int xProgressBar;
  private static int yProgressBar;
  private static Color progressBarColor;


  public static void main(String[] args) throws AWTException, InterruptedException, IOException {

    String currentDir = new File(".").getAbsolutePath();
    System.out.println ("Current directory: " + currentDir);

    Robot robot = new Robot();

/*
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
*/

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

    System.out.println("rettangolo punto A");
    Thread.sleep(2000);
    System.out.println("3");
    Thread.sleep(1000);
    System.out.println("2");
    Thread.sleep(1000);
    System.out.println("1");
    Thread.sleep(1000);

    Point APosition = MouseInfo.getPointerInfo().getLocation();
    xA = (int) APosition.getX();
    yA = (int) APosition.getY();

    System.out.println(xA + " - "  + yA);

    System.out.println("rettangolo punto B");
    Thread.sleep(2000);
    System.out.println("3");
    Thread.sleep(1000);
    System.out.println("2");
    Thread.sleep(1000);
    System.out.println("1");
    Thread.sleep(1000);

    Point BPosition = MouseInfo.getPointerInfo().getLocation();
    xB = (int) BPosition.getX();
    yB = (int) BPosition.getY();

    System.out.println(xB + " - "  + yB);

    screenshotRectangleWidth = xB - xA ;
    screenshotRectangleHeight = yB - yA ;

    System.out.println(screenshotRectangleWidth + " x "  + screenshotRectangleHeight);


    System.out.println("Buon divertimento!");

    while (index < pages) {
      clickAndScreenshot(robot, index);
      index++;
    }

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

      //premo invio nel caso in cui venga visualizzato l'alert: "Video non terminato!"
      Thread.sleep(500);

      robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
    }

    //aspetto X millisecondi e ripeto l'operazione
    Thread.sleep(5000); //millisecondi

    //chiamata ricorsiva
    moveAndClick(robot);

  }

  private static void clickAndScreenshot(Robot robot, int index) throws InterruptedException, IOException {

    //wait and screenshot
    Thread.sleep(1000);

    BufferedImage screenShot = robot.createScreenCapture(new Rectangle(xA, yA, screenshotRectangleWidth, screenshotRectangleHeight));
    ImageIO.write(screenShot, "JPG", new File("./doc/" + index + ".jpg"));

    //wait and click
    Thread.sleep(1000);

    //posizione attuale del mouse
    Point originalPointer = MouseInfo.getPointerInfo().getLocation();

    //sposto il mouse e clicco sul punto desiderato
    robot.mouseMove(xButton,yButton);
    robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    //riporto il mouse alla posizione iniziale
    robot.mouseMove((int)originalPointer.getX(),(int)originalPointer.getY());

  }

}

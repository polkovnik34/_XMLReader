package ru.atc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Thread.sleep;

public class Screen {
    static public void GetScreen(String pathSave_Screen) throws InterruptedException, IOException {
        Date date = new Date();
        String nameTest[] = pathSave_Screen.split("/");
        sleep(500);
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("HH_mm_ss");
        BufferedImage image;
        try {
            image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            ImageIO.write(image, "png", new File("./Logs/Screen/" +  "screenshot_" + nameTest[2] + "-" + formatForDateNow.format(date) + ".PNG"));
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

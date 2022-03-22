/*  
   Anthony Gutierrez
   09/30/2021
   House.java
   This line of code contains an animation
   for a screensaver.
 */

import acm.program.GraphicsProgram;
import java.awt.Color;
import acm.graphics.GOval;
import acm.graphics.GPolygon;
import acm.graphics.GLine;
import acm.graphics.GArc;


public class Screensaver extends GraphicsProgram 
{
   public static void main(String[] args) 
      {
         Screensaver program = new Screensaver();
         program.start();
      }
  
   public void init()
      {
         setTitle("Screensaver Program");
         setSize(1000, 700);
      }
   
   public void run()
      {
         //Creates the custom colors for the program
         Color night = new Color(4,9,28);
         Color clouds = new Color(208,208,208);
         setBackground(night);
         
         //Draws a moon
         GOval fullMoon = new GOval(600, 100, 200, 200);
         add(fullMoon);
         fullMoon.setFillColor(Color.WHITE);
         fullMoon.setFilled(true);
         
         //Draws the shadow for the moon above
         GOval newMoon = new GOval(400, 105, 180, 180);
         add(newMoon);
         newMoon.setColor(night);
         newMoon.setFillColor(night);
         newMoon.setFilled(true);
         
         //Draws all the stars
         GOval star1 = new GOval(50, 25, 5, 5);
         add(star1);
         star1.setFillColor(Color.WHITE);
         star1.setFilled(true);
         
         GOval star2 = new GOval(570, 45, 5, 5);
         add(star2);
         star2.setFillColor(Color.WHITE);
         star2.setFilled(true);
         
         GOval star3 = new GOval(400, 35, 5, 5);
         add(star3);
         star3.setFillColor(Color.WHITE);
         star3.setFilled(true);
         
         GOval star4 = new GOval(25, 150, 5, 5);
         add(star4);
         star4.setFillColor(Color.WHITE);
         star4.setFilled(true);
         
         GOval star5 = new GOval(200, 25, 5, 5);
         add(star5);
         star5.setFillColor(Color.WHITE);
         star5.setFilled(true);
         
         GOval star6 = new GOval(100, 255, 5, 5);
         add(star6);
         star6.setFillColor(Color.WHITE);
         star6.setFilled(true);
         
         GOval star7 = new GOval(150, 300, 5, 5);
         add(star7);
         star7.setFillColor(Color.WHITE);
         star7.setFilled(true);
         
         GOval star8 = new GOval(45, 350, 5, 5);
         add(star8);
         star8.setFillColor(Color.WHITE);
         star8.setFilled(true);
         
         GOval star9 = new GOval(175, 165, 5, 5);
         add(star9);
         star9.setFillColor(Color.WHITE);
         star9.setFilled(true);
         
         GOval star10 = new GOval(70, 45, 5, 5);
         add(star10);
         star10.setFillColor(Color.WHITE);
         star10.setFilled(true);
         
         GOval star11 = new GOval(500, 100, 5, 5);
         add(star11);
         star11.setFillColor(Color.WHITE);
         star11.setFilled(true);
         
         GOval star12 = new GOval(420, 245, 5, 5);
         add(star12);
         star12.setFillColor(Color.WHITE);
         star12.setFilled(true);
         
         GOval star13 = new GOval(595, 345, 5, 5);
         add(star13);
         star13.setFillColor(Color.WHITE);
         star13.setFilled(true);
         
         GOval star14 = new GOval(670, 430, 5, 5);
         add(star14);
         star14.setFillColor(Color.WHITE);
         star14.setFilled(true);
         
         GOval star15 = new GOval(370, 345, 5, 5);
         add(star15);
         star15.setFillColor(Color.WHITE);
         star15.setFilled(true);
         
         GOval star16 = new GOval(170, 245, 5, 5);
         add(star16);
         star16.setFillColor(Color.WHITE);
         star16.setFilled(true);
         
         GOval star17 = new GOval(250, 300, 5, 5);
         add(star17);
         star17.setFillColor(Color.WHITE);
         star17.setFilled(true);
         
         //Creates the origin of the shooting star
         GLine shootingStar = new GLine(0, 0, 1, 1);
         add(shootingStar);
         shootingStar.setColor(Color.WHITE);
         
         //Draws the mountains from left to right
         GPolygon mountain = new GPolygon();
         mountain.addVertex(0, 700);
         mountain.addVertex(200, 450);
         mountain.addVertex(300, 450);
         mountain.addVertex(500, 700);
         add(mountain);
         mountain.setFillColor(Color.WHITE);
         mountain.setFilled(true);
         
         GArc top = new GArc(200, 430, 100, 50, 0, 180);
         add(top);
         top.setColor(Color.WHITE);
         top.setFillColor(Color.WHITE);
         top.setFilled(true);
         
         GPolygon mountain1 = new GPolygon();
         mountain1.addVertex(0, 700);
         mountain1.addVertex(200, 450);
         mountain1.addVertex(300, 450);
         mountain1.addVertex(500, 700);
         add(mountain1);
         mountain1.setFillColor(Color.WHITE);
         mountain1.setFilled(true);
         
         GArc top1 = new GArc(200, 433, 100, 50, 0, 180);
         add(top1);
         top1.setColor(Color.WHITE);
         top1.setFillColor(Color.WHITE);
         top1.setFilled(true);
         
         GPolygon mountain2 = new GPolygon();
         mountain2.addVertex(300, 700);
         mountain2.addVertex(500, 450);
         mountain2.addVertex(600, 450);
         mountain2.addVertex(800, 700);
         add(mountain2);
         mountain2.setFillColor(Color.WHITE);
         mountain2.setFilled(true);
         
         GArc top2 = new GArc(500, 433, 100, 50, 0, 180);
         add(top2);
         top2.setColor(Color.WHITE);
         top2.setFillColor(Color.WHITE);
         top2.setFilled(true);
         
         //Moves the first mountain to be outside of the window
         for (int i=0; i<1; i++)
            {
               mountain.move(-300, 0);
               top.move(-300, 0);
            }
        //Animates the shooting star and eclipsing moon
         while(true)
            {
               
               for (int i=0; i<180; i++)
                  {
                     newMoon.move(1, 0);
                     pause(100);
                  }
               for (int i=0; i<10; ++i)
                  {
                     newMoon.scale(1.01);
                     pause(100);
                  }
               for (int i=0; i<45; i++)
                  {
                     newMoon.move(1, -0.1);
                     pause(100);
                  }
                for (int i=0; i<10; ++i)
                  {
                     newMoon.scale(0.99);
                     pause(100);
                  }
                for (int i=0; i<180; i++)
                  {
                     newMoon.move(1, 0);
                     pause(100);
                  }
               newMoon.setLocation(400, 105);
                              
               for (int i=0; i<200; i++)
                  {
                     shootingStar.scale(1.01);
                     pause(1);
                  }
               
               for (int i=0; i<1000; i++)
                  {
                     shootingStar.move(1,1);
                     pause(1);
                  }
               for (int i=0; i<200; i++)
                  {
                     shootingStar.scale(0.99);
                  } 
                  
               shootingStar.setLocation(0, 0);
            }
      }
}
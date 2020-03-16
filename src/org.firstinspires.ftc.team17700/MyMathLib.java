package org.firstinspires.ftc.team17700;

import java.util.*;

// Math reference: https://seamonsters-2605.github.io/archive/mecanum/

 public class MyMathLib {
     public static double pi = 3.1415; // 3.14159265358979323846
     // Arguments: Joystick X, Joystick Y, Rotation Axis (triggers?). Values are between -1 and 1.
     // Rotational power will take 100% priority over directional power, by design.
     public static double[] mecMath(double x, double y, double z){
         double[] wheelPowers = new double[4];
         double mag = Math.min( 1, Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)) ); // Magnitude
         double theta = Math.atan2(x, y);
         double powerA = Math.sin(theta - 0.25 * pi) * mag;
         double powerB = Math.sin(theta + 0.25 * pi) * mag;
         double dirMag = 1 - Math.abs(z); // Directional Magnitude
         double rotMag = z; // Rotational Magnitude

         // Note: Right-side motors are inverted. If this code does not work, change the inversion before anything else.
         wheelPowers[0] = -(rotMag + powerA * dirMag); // Front-right
         wheelPowers[1] = (rotMag + powerB * dirMag); // Front-left
         wheelPowers[2] = -(rotMag + powerB * dirMag); // Back-right
         wheelPowers[3] = (rotMag + powerA * dirMag); // Back-left

         return wheelPowers;
     }
 }
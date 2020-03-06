/*
1. Extend arm - Start button
2. Retract arm - Menu Button
3. Spin Wheel
    a. blue - X - button
    b. red - B - button
    c. yellow - Y - button
    d. green - A - button

Total of 6 buttons
*/
package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;
// import frc.robot.commands.ColorWheelGetColor;

import frc.robot.Constants;
import frc.robot.Constants.ColorConstants;
import com.ctre.phoenix.motorcontrol.ControlMode;
// Talon Libraries
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// *********************************************
// ALL CODE BELOW IS SAMPLE CODE FROM REV ROBOTICS FOR THIS LINk:
//
// DO NOT USE AS IS - this is a sample that was writtend to run in robot.java - not a command based template
//
//  ******************************************
public class ColorWheelSubSystem extends SubsystemBase {

  /**
   * Change the I2C port below to match the connection of your color sensor
   */
   private final I2C.Port i2cPort = I2C.Port.kOnboard;
   private final TalonSRX  m_colorspinner        = new TalonSRX(ColorConstants.ColorWheelSpinner);
  /**
   * A Rev Color Sensor V3 object is constructed with an I2C port as a 
   * parameter. The device will be automatically initialized with default 
   * parameters.
   */
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);

  /**
   * A Rev Color Match object is used to register and detect known colors. This can 
   * be calibrated ahead of time or during operation.
   * 
   * This object uses a simple euclidian distance to estimate the closest match
   * with given confidence range.
   */
  private final ColorMatch m_colorMatcher = new ColorMatch();

  /**
   * Note: Any example colors should be calibrated as the user needs, these
   * are here as a basic example.
   */

  private final Color kBlueTarget   = ColorMatch.makeColor(ColorConstants.Blue1, ColorConstants.Blue2, ColorConstants.Blue3);
  private final Color kGreenTarget  = ColorMatch.makeColor(ColorConstants.Green1, ColorConstants.Green2, ColorConstants.Green3);
  private final Color kRedTarget    = ColorMatch.makeColor(ColorConstants.Red1, ColorConstants.Red2, ColorConstants.Red3);
  private final Color kYellowTarget = ColorMatch.makeColor(ColorConstants.Yellow1, ColorConstants.Yellow2, ColorConstants.Yellow3);

  public final String colorString = "Red";
  private final Color  detectedColor = m_colorSensor.getColor();
    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */

    public void colorInit () {

      m_colorMatcher.addColorMatch(kBlueTarget);
      m_colorMatcher.addColorMatch(kGreenTarget);
      m_colorMatcher.addColorMatch(kRedTarget);
      m_colorMatcher.addColorMatch(kYellowTarget);
     
    } 
    
     /*
      RedColor read = Blue FindColor
      GreenColor read= Yellow FindColor
      BlueColor read = Red FindColor
      YellowColor read= green FindColor
      */

    public void FindColor(String requiredColor) {

      String ReadColor;
     
      if (requiredColor == "Red") {
        ReadColor = "Blue";
      } else if (requiredColor == "Green") {
        ReadColor = "Yellow";
      } else if (requiredColor == "Blue") {
        ReadColor = "Red";
      } else if (requiredColor == "Yellow") {
        ReadColor = "Green";
      } else {
        ReadColor = "Unkown";
      }
    
       String colorStringY;
       Color detectedColor = m_colorSensor.getColor();
       ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
      SmartDashboard.putString("ColorString", detectedColor.toString());
      colorStringY = "Unknown";
      if (match.color == kBlueTarget) {
        colorStringY = "Blue";
      } else if (match.color == kRedTarget) {
        colorStringY = "Red";
      } else if (match.color == kGreenTarget) { 
       colorStringY = "Green";
      } else if (match.color == kYellowTarget) {
        colorStringY = "Yellow";
      } else {
        colorStringY = "Unknown";    }

    while (ReadColor != colorStringY) {
        detectedColor = m_colorSensor.getColor();
        match = m_colorMatcher.matchClosestColor(detectedColor);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", match.toString());
      
        if (match.color == kBlueTarget) {
          colorStringY = "Blue";
        } else if (match.color == kRedTarget) {
          colorStringY = "Red";
        } else if (match.color == kGreenTarget) { 
         colorStringY = "Green";
        } else if (match.color == kYellowTarget) {
          colorStringY = "Yellow";
        } else {
          colorStringY = "Unknown";    }

        SmartDashboard.putString("requiredColor", ReadColor);
  
        SmartDashboard.putString("ColorString", match.color.toString());
        SmartDashboard.putString("ColorString", colorStringY);
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorStringY);

        }
      }

// Spins wheel 3 revolutions based on the # of "yellow" colors it sees
    public void spin_wheel3x () {
      //spin wheel 3 times:
      int i = 1;
      // i is the number of times you have seen the initial color
      m_colorspinner.set(ControlMode.PercentOutput,  0.20);
      String colorString1 = "JACK_INIT";
      while (i < 6) {
        // Are we getting this from Periodic
         Color     detectedColor = m_colorSensor.getColor();
         ColorMatchResult match1 = m_colorMatcher.matchClosestColor(detectedColor);
         SmartDashboard.putString("ColorStringConvert", match1.color.toString());
         SmartDashboard.putString("ColorStringBase", colorString1);
         System.out.println("IN 3x WHILE LOOP");
         SmartDashboard.putNumber("Confidence", match1.confidence);
         SmartDashboard.putString("Detected Color", match1.toString());
         SmartDashboard.putNumber("Number of times initial color is seen", i);

    
         if (match1.color == kBlueTarget) {
             
            colorString1 = "Blue";
          } else if (match1.color == kRedTarget) {
            colorString1 = "Red";
          } else if (match1.color == kGreenTarget) { 
            colorString1 = "Green";
          } else if (match1.color == kYellowTarget) {
            colorString1 = "Yellow";
          } else {
            colorString1 = "Unknown";    }     
         if (colorString1 == "Yellow") {
            System.out.println("Incrementing (i) in LOOP");
            i = i+1;
          } 
         else { System.out.println("Not Yellow");
          }     
                m_colorspinner.set(ControlMode.PercentOutput,  0.0);
      }

    }

//  Sets the spinner motor on at constant rate
    public void spinColorWheel () {
        m_colorspinner.set(ControlMode.PercentOutput,  0.25);

      } 
// Method Stops the Spinner Wheel Motor
    public void stopWheelSpinner() {
        m_colorspinner.set(ControlMode.PercentOutput,  0.0);
    
      }

    @Override
    public void periodic() {
    
    
  
      // This method will be called once per scheduler run
      
      // For testing only remove this line for comepition
      // m_colorspinner.set(ControlMode.PercentOutput,  0.25);

      Color detectedColor = m_colorSensor.getColor();
      SmartDashboard.putString("ColorString", detectedColor.toString());
 
      String colorString;
      ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);
      SmartDashboard.putNumber("Confidence", match.confidence);
      SmartDashboard.putString("Detected Color", match.toString());
    
      if (match.color == kBlueTarget) {
        colorString = "Blue";
      } else if (match.color == kRedTarget) {
        colorString = "Red";
      } else if (match.color == kGreenTarget) { 
       colorString = "Green";
      } else if (match.color == kYellowTarget) {
        colorString = "Yellow";
      } else {
        colorString = "Unknown";    }

        
        // colorString = "HardSet-Unknown";
        SmartDashboard.putString("ColorString", match.color.toString());
        SmartDashboard.putString("ColorString", colorString);
        SmartDashboard.putNumber("Red", detectedColor.red);
        SmartDashboard.putNumber("Green", detectedColor.green);
        SmartDashboard.putNumber("Blue", detectedColor.blue);
        SmartDashboard.putNumber("Confidence", match.confidence);
        SmartDashboard.putString("Detected Color", colorString);
      }


}
   
    
  
    


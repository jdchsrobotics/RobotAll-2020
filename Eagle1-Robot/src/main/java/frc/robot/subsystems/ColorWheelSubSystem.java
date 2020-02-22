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

import frc.robot.Constants.ColorConstants;


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
    
     
    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      
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
   
    
  
    


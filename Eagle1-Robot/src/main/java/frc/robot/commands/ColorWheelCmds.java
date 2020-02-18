/******
 * 
 * Color Wheel Commands
 * 
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ColorWheelSubSystem;
import frc.robot.Constants.ColorConstants;
import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

public class ColorWheelCmds extends CommandBase {
    /**
     * Change the I2C port below to match the connection of your color sensor
     */
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
  
  
  private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  private final ColorMatch m_colorMatcher = new ColorMatch();

  private final Color kBlueTarget = ColorMatch.makeColor(ColorConstants.Blue1, ColorConstants.Blue2, ColorConstants.Blue3);
  private final Color kGreenTarget = ColorMatch.makeColor(ColorConstants.Green1, ColorConstants.Green2, ColorConstants.Green3);
  private final Color kRedTarget = ColorMatch.makeColor(ColorConstants.Red1, ColorConstants.Red2, ColorConstants.Red3);
  private final Color kYellowTarget = ColorMatch.makeColor(ColorConstants.Yellow1, ColorConstants.Yellow2, ColorConstants.Yellow3);


  public final void xyz () {
    // do something
  }
          
      // Called when the command is initially scheduled.
      @Override
      public final  void initialize() {
      // add intis here
 
      m_colorMatcher.addColorMatch(kBlueTarget);
      m_colorMatcher.addColorMatch(kGreenTarget);
      m_colorMatcher.addColorMatch(kRedTarget);
      m_colorMatcher.addColorMatch(kYellowTarget);

    }

     @Override
     public final void execute () {

     }
     

     @Override
     public final void end (boolean interrupted) {
       
     }


     @Override
     public boolean isFinished() {
      return false;
     }
  



}
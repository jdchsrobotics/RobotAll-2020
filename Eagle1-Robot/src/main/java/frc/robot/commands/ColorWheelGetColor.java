/******
 * 
 * Color Wheel Commands
 * 
 */
package frc.robot.commands;
// package edu.wpi.first.wpilibj.examples.hatchbottraditional.commands;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
// import java.util.function.DoubleSupplier;
// import edu.wpi.first.wpilibj.templates.commandbased.subsystems.ExampleSubsystem;

import frc.robot.subsystems.ColorWheelSubSystem;
import frc.robot.Constants.ColorConstants;

import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


public class ColorWheelGetColor extends CommandBase {
    /**
     * Change the I2C port below to match the connection of your color sensor
     */

    private final ColorWheelSubSystem m_ColorWheelSubSystem;

    private final ColorMatch   m_colorMatcher = new ColorMatch();
  /*
    private final Color kBlueTarget   = ColorMatch.makeColor(ColorConstants.Blue1, ColorConstants.Blue2, ColorConstants.Blue3);
    private final Color kGreenTarget  = ColorMatch.makeColor(ColorConstants.Green1, ColorConstants.Green2, ColorConstants.Green3);
    private final Color kRedTarget    = ColorMatch.makeColor(ColorConstants.Red1, ColorConstants.Red2, ColorConstants.Red3);
    private final Color kYellowTarget = ColorMatch.makeColor(ColorConstants.Yellow1, ColorConstants.Yellow2, ColorConstants.Yellow3);
*/

    public ColorWheelGetColor (ColorWheelSubSystem subSystem) {
      m_ColorWheelSubSystem = subSystem;
  // CONTINUE FROM HERE ADD REQUIREMENT FROM THIS LINK
  // https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/templates/commandbased/commands/ExampleCommand.java
       addRequirements(m_ColorWheelSubSystem);

    }


      // Called when the command is initially scheduled.
      @Override
      public final void  initialize() {
      // add intis here

    }

     @Override
     public final void execute() {

        m_ColorWheelSubSystem.colorRead();
     }
     

     @Override
     public final void end (boolean interrupted) {
      // NO end task needed 
     }

     @Override
     public boolean isFinished() {
      return false;
     }
  
}
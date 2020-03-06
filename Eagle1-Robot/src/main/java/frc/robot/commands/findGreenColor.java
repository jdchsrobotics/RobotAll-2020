/******
 * 
 * Color Wheel Commands
 * 
 * adding comment to ensure branches work
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


public class findGreenColor extends CommandBase {
    /**
     * Change the I2C port below to match the connection of your color sensor
     */

    private final ColorWheelSubSystem m_ColorWheelSubSystem;

    public findGreenColor (ColorWheelSubSystem subSystem) {
      m_ColorWheelSubSystem = subSystem;
  // CONTINUE FROM HERE ADD REQUIREMENT FROM THIS LINK
  // https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/templates/commandbased/commands/ExampleCommand.java
       addRequirements(m_ColorWheelSubSystem);

    }


      // Called when the command is initially scheduled.
      @Override
      public final void  initialize() {
      // add intis here
        m_ColorWheelSubSystem.colorInit();
        m_ColorWheelSubSystem.spinColorWheel ();
        m_ColorWheelSubSystem.FindColor("Green");
    }

    @Override
    public final void execute() {

      
    }
 

    @Override
    public final void end (boolean interrupted) {
        m_ColorWheelSubSystem.stopWheelSpinner();
    }


     @Override
     public boolean isFinished() {
      return false;
     }
  
}
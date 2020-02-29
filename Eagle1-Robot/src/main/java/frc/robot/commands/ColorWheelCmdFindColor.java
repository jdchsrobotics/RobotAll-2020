/******
 * 
 * Color Wheel Commands for finding color
 * 
 * adding comment to ensure branches work
 * 
 */
package frc.robot.commands;
// package edu.wpi.first.wpilibj.examples.hatchbottraditional.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

// import java.util.function.DoubleSupplier;
// import edu.wpi.first.wpilibj.templates.commandbased.subsystems.ExampleSubsystem;

import frc.robot.subsystems.ColorWheelSubSystem;


public class ColorWheelCmdFindColor extends CommandBase {
    /**
     * Change the I2C port below to match the connection of your color sensor
     */

    private final ColorWheelSubSystem m_ColorWheelSubSystem;

    public ColorWheelCmdFindColor (ColorWheelSubSystem subSystem) {
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
        m_ColorWheelSubSystem.FindColor("Blue");
        
    }

     @Override
     public final void execute() {

     //   m_ColorWheelSubSystem.colorRead();
         

          
     }
  

     @Override
     public final void end (boolean interrupted) {
       
     }


     @Override
     public boolean isFinished() {
      return false;
     }
  
}
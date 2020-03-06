/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// 10.32.89.9
package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

// Add when COMMAND file .java is fixed import frc.robot.commands.Teleop_Drive;

import frc.robot.Controls.ControlMap;
import frc.robot.Controls.xboxControllerMap;
import frc.robot.subsystems.DriveSubSystem;
import frc.robot.subsystems.LifterSubSystem;
import frc.robot.commands.*;
// Add after Autocode is written
// import frc.robot.commands.GoAuto.*;

import frc.robot.subsystems.ColorWheelSubSystem;
import frc.robot.subsystems.LifterSubSystem;
import frc.robot.subsystems.BallManagementSubSystem;
// import frc.robot.Constants.eagle_DriveConstants;
import frc.robot.Constants.OI_Constants;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
 
  // The robot's subsystems and commands are defined here...
  private final DriveSubSystem m_robotDrive = new DriveSubSystem();
 
  // Commandd for Drive Subsystem
  // ACTION take out 0, 0 from calls
  private final Default_Drive c_drive       = new Default_Drive(m_robotDrive, 0, 0);
  private final GoAuto        c_goAutoCmd   = new GoAuto(m_robotDrive);

  // Color Wheel  
  private final ColorWheelSubSystem m_colorwheel = new ColorWheelSubSystem();
 // private final ColorWheelGetColor  c_colorwheelCmds = new ColorWheelGetColor(m_colorwheel);

  // Ball Management (shooting and/or pickup)
  private final LifterSubSystem     m_lifterSystem = new LifterSubSystem();
  private final BallManagementSubSystem m_ballSystem = new BallManagementSubSystem();
  // Define the joystick for driver
 // private final Joystick m_stick = new Joystick(OI_Constants.Joystick_1_portID);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    // Configure default commands
    configureDefaultCommands();
    // ACTION - may not be needed once color wheel is in Periodic
    // Start Periodic and/or Init+Execute
    m_colorwheel.colorInit();
    m_lifterSystem.setMotorBrake();
    
  }

private void configureDefaultCommands() {
   m_robotDrive.setDefaultCommand(c_drive);
  
}

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
// From github.com/Team612/612-2020/xxxxx/RobotContainer.java
   // Color Wheel Commands

   // ControlMap.getkA_Green.whenHeld (new findGreenColor(m_colorwheel));
   // ControlMap.getkB_Red.whenHeld (new findRedColor(m_colorwheel));
   // ControlMap.getkY_Yellow.whenPressed (new findYellowColor(m_colorwheel));
   // ControlMap.getkX_Blue.whenHeld (new findBlueColor(m_colorwheel));
   // ControlMap.getStart.whenPressed     (new spinColorWheel3x(m_colorwheel));
//  ACTION = Map to LIfter
    // Map lifter

    // Map Ball Subsystem
    ControlMap.getB5_LiftUp.whenHeld  (new LifterUp(m_lifterSystem));
    ControlMap.getB3_LiftDown.whenHeld (new LifterDown(m_lifterSystem));
    ControlMap.getB4_BalLeft.whenHeld  (new LifterBalanceLeft(m_lifterSystem));
    ControlMap.getB6_BalRight.whenHeld (new LifterBalanceRight(m_lifterSystem));

    //  ACTION = Map to Balls
    ControlMap.getStkLeft_CageUp.whenHeld   (new BallCageUp(m_ballSystem));
    ControlMap.getStkRight_CageUp.whenHeld  (new BallCageDown(m_ballSystem));
    ControlMap.getBumpLeft_BallsIN.whenHeld (new BallsIn(m_ballSystem));
    ControlMap.getBumpRight_BallsOUT.whenHeld (new BallsOut(m_ballSystem));


  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *  FIX for AUTO: Need to uncommend have have our Automnomos code.
   * @return the command to run in autonomous
   */

  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return (c_goAutoCmd);
    // return(null);

  }
  
}

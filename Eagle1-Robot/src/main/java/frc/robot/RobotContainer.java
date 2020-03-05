/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;

// Add when COMMAND file .java is fixed import frc.robot.commands.Teleop_Drive;

import frc.robot.Controls.ControlMap;
import frc.robot.subsystems.DriveSubSystem;
import frc.robot.subsystems.LifterSubSystem;
import frc.robot.commands.Default_Drive;
// Add after Autocode is written
// import frc.robot.commands.GoAuto.*;

import frc.robot.subsystems.ColorWheelSubSystem;
import frc.robot.subsystems.LifterSubSystem;
import frc.robot.commands.ColorWheelGetColor;
import frc.robot.commands.GoAuto;
import frc.robot.commands.LifterLift;
import frc.robot.subsystems.BallManagementSubSystem;
import frc.robot.commands.BallManagementCmds.*;


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
  private final LifterSubSystem     m_liftermotor = new LifterSubSystem();
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
    m_liftermotor.setMotorBrake();

  }

private void configureDefaultCommands() {
   m_robotDrive.setDefaultCommand(c_drive);
  
}

// FIX -> needs the arcade drive exposed or synctax fixed
// Old Default Command Drive -> bypassed commands and calls subsystem directly
// Nice for quick testing but does not support autonomous

/*   m_robotDrive.setDefaultCommand (   
         new RunCommand(() -> m_robotDrive.joy_arcadeDrive (
                                (-1 * m_stick.getY())
                                , m_stick.getX()  ),
                m_robotDrive
         )
    );
    */

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
// Add xbox stuff here (ACTION JMG)
//https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/hatchbottraditional/RobotContainer.java

  // Grab the hatch when the 'A' button is pressed.
  //new JoystickButton(m_driverController, Button.kA.value)
  //.whenPressed(new GrabHatch(m_hatchSubsystem));
// Release the hatch when the 'B' button is pressed.
//new JoystickButton(m_driverController, Button.kB.value)
 // .whenPressed(new ReleaseHatch(m_hatchSubsystem));
// While holding the shoulder button, drive at half speed
//new JoystickButton(m_driverController, Button.kBumperRight.value)
  //.whenHeld(new HalveDriveSpeed(m_robotDrive));
  
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

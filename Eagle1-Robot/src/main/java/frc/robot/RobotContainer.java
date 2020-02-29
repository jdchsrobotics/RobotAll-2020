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
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


// Add when COMMAND file .java is fixed import frc.robot.commands.Teleop_Drive;

import frc.robot.subsystems.DriveSubSystem;
import frc.robot.commands.ColorWheelCmdFindColor;
import frc.robot.commands.ColorWheelGetColor;
import frc.robot.subsystems.ColorWheelSubSystem;

// import frc.robot.Constants.eagle_DriveConstants;
import frc.robot.Constants.OI_Constants;
import frc.robot.Constants.ColorConstants;
/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
 
  // The robot's subsystems and commands are defined here...
  private final DriveSubSystem m_robotDrive = new DriveSubSystem();

  // Color Wheel  
  private final ColorWheelSubSystem m_colorwheel = new ColorWheelSubSystem();
  private final ColorWheelGetColor  m_colorwheelCmds = new ColorWheelGetColor(m_colorwheel);
 // private final Command  m_getcolor = new ColorWheelGetColor(m_colorwheel);

  // Ball Management (shooting and/or pickup)
 
  // Climber
 

  // Define the joystick for driver
  private final Joystick m_stick = new Joystick(OI_Constants.Joystick_1_portID);



  // FIx after commands are fixed (for autonomous)
  // ACTION NEEDED TO ADJUST:
  // private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_colorwheel.colorInit();
    

// Fron botton of this link as the example
    // https://docs.wpilib.org/en/latest/docs/software/commandbased/subsystems.html
/// m_colorwheel.setDefaultCommand(execute());
 //m_colorwheel.setDefaultCommand(;
/*
   m_colorwheel.setDefaultCommand (   
    new RunCommand(() -> m_colorwheel.colorRead()
                        ,
           m_colorwheel 
                   )
    );
*/
// FIX -> needs the archade drive exposed or synctax fixed
    m_robotDrive.setDefaultCommand (   
         new RunCommand(() -> m_robotDrive.arcadeDrive (
                                (-1 * m_stick.getY())
                                , m_stick.getX()  ),
                m_robotDrive
         )
    );
  
}
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
// Add xbox stuff here (ACTION JMG)
//https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/examples/hatchbottraditional/RobotContainer.java
XboxController m_XboxController = new XboxController(OI_Constants.Xbox_Controller_portID);


 new JoystickButton(m_XboxController , Button.kStickLeft.value)
 .whenPressed(new ColorWheelGetColor(m_colorwheel));

  new JoystickButton(m_XboxController, Button.kA.value)
 .whenPressed( new ColorWheelCmdFindColor(m_colorwheel, "Green"));
 new JoystickButton(m_XboxController, Button.kB.value)
 .whenPressed( new ColorWheelCmdFindColor(m_colorwheel, "Red"));
 new JoystickButton(m_XboxController, Button.kX.value)
 .whenPressed( new ColorWheelCmdFindColor(m_colorwheel, "Blue"));
 new JoystickButton(m_XboxController, Button.kY.value)
 .whenPressed( new ColorWheelCmdFindColor(m_colorwheel, "Yellow"));


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
    return (null);
   // return m_autoCommand;
  }
  
}

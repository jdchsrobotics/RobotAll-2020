/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may b
e modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import java.util.function.DoubleSupplier;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.DriveSubSystem;

import frc.robot.Controls.ControlMap;

/**
 * An example command that uses an example subsystem.
 */
public class Default_Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubSystem m_drive;
  private final Double m_forward;
  private final Double m_rotation;
  // private final DoubleSupplier m_forward;
  // private final DoubleSupplier m_rotation;
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  
  // if Using double supplier 
  //   public Default_Drive (Drive_SubSystem subsystem, DoubleSupplier forward, doubleSupplier rotation) {

  public Default_Drive (DriveSubSystem subsystem, double forward, double rotation) {
    m_drive = subsystem;
    m_forward = forward;
    m_rotation = rotation;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

    // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.joy_arcadeDrive((-1 * ControlMap.m_driver_stick.getY()), ControlMap.m_driver_stick.getX());
   
  }


  // Called when the command is initially scheduled.
  @Override
  public final  void initialize() {
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

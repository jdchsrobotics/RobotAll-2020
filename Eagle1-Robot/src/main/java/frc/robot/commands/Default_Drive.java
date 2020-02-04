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

import frc.robot.subsystems.Drive_SubSystem;

/**
 * An example command that uses an example subsystem.
 */
public class Default_Drive extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final Drive_SubSystem m_drive;
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

  public Default_Drive (Drive_SubSystem subsystem, Double forward, double rotation) {
    m_drive = subsystem;
    m_forward = forward;
    m_rotation = rotation;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drive.arcadeDrive(m_forward, m_rotation);
    // if using doublesupplier   
    //  m_drive.arcadeDrive(m_forward.getAsDouble(), m_rotation.getAsDouble());
    // 
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

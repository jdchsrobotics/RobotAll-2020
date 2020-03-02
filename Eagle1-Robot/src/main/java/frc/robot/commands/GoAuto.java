package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
// import java.util.function.DoubleSupplier;

import frc.robot.subsystems.DriveSubSystem;

/*
Autonomous Positions:
A - Left side by Portal
B - Right side by Portal
C - Far side of Portal
D - Drive only ball pickup
*/

import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubSystem;

public class GoAuto extends CommandBase {
  /**
   * Change the I2C port below to match the connection of your color sensor
   */

  private final DriveSubSystem m_DriveSubSystem;

  public GoAuto (DriveSubSystem subSystem) {
    m_DriveSubSystem = subSystem;
// CONTINUE FROM HERE ADD REQUIREMENT FROM THIS LINK
// https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/templates/commandbased/commands/ExampleCommand.java
     addRequirements(m_DriveSubSystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    System.out.println("Temporary Auto-Drive Forward");
    System.out.println("Temporary Auto-Drive Rotate");
    System.out.println("Temporary Auto-Drive Stop Now");
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



// import frc.robot.shootersubsystem; Fix after shooter subsystem exists.
/*
public class DefaultAuto extends SequentialCommandGroup {
    /**
     * Creates a new ComplexAuto.
     *
     * @param drive The drive subsystem this command will run on
     * @param hatch The hatch subsystem this command will run on
     */
    /*
    public DefaultAuto(DriveSubSystem drive) {
      addCommands(
          // Drive forward the specified distance
          
          new DriveForward(AutoConstants.AutoDriveDistanceInches, AutoConstants.AutoDriveSpeed,
                            drive),
    
                            @Override
                            public void execute() {
                              m_drive.arcadeDrive(AutoConstants.AutoDriveSpeed, AutoConstants.AutoDriveRotation);
                            }


                             @Override
                              public final void end (boolean interrupted) {
       
                            }

                             @Override
                              public boolean isFinished() {
                               return true;
                               //return false;
                              }                     
    }
  }

  */
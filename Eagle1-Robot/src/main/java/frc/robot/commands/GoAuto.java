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
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubSystem;

import edu.wpi.first.wpilibj.RobotController;

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
    System.out.println("Temporary Auto-Drive Forward");
    long millisecondsToRun = 1500000; // This should run 1000ms = 1 s.
    long initTime = RobotController.getFPGATime();

    while (RobotController.getFPGATime() - initTime <= millisecondsToRun) {
         m_DriveSubSystem.Drive(-0.5, 0);
    }
    m_DriveSubSystem.Drive(0,0);  
    // new WaitCommand(2);
   /*
    System.out.println("Temporary Auto-Drive Rotate");
    initTime = RobotController.getFPGATime();
    while (RobotController.getFPGATime() - initTime <= millisecondsToRun) {
    m_DriveSubSystem.Drive(0, .5);
    }

     System.out.println("Temporary Auto-Drive Stop Now");
    initTime = RobotController.getFPGATime();
    while (RobotController.getFPGATime() - initTime <= millisecondsToRun) {
    m_DriveSubSystem.Drive(-0.5, 0);
    */
    }
   // new WaitCommand(2);
  

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

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
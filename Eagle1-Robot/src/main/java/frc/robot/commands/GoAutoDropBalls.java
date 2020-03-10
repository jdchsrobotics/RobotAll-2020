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
import frc.robot.subsystems.BallManagementSubSystem;
import edu.wpi.first.wpilibj.RobotController;

public class GoAutoDropBalls extends CommandBase {
  /**
   * Change the I2C port below to match the connection of your color sensor
   */

  private final DriveSubSystem m_DriveSubSystem;
  private final BallManagementSubSystem m_BallManagementSubSystem;

  public GoAutoDropBalls (DriveSubSystem subSystem, BallManagementSubSystem subSystem2) {
    m_DriveSubSystem = subSystem;
    m_BallManagementSubSystem = subSystem2;
// CONTINUE FROM HERE ADD REQUIREMENT FROM THIS LINK
// https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/templates/commandbased/commands/ExampleCommand.java
     addRequirements(m_DriveSubSystem);
     addRequirements(m_BallManagementSubSystem);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Temporary Auto-Drive Forward");
  long millisecondsToRun = 2300000; // This should run 1000ms = 1 s.
    long initTime = RobotController.getFPGATime();

    while (RobotController.getFPGATime() - initTime <= millisecondsToRun) {
         m_DriveSubSystem.Drive(-0.5, 0);
         m_BallManagementSubSystem.upBallCage(0.1);
         
    }
    m_DriveSubSystem.Drive(0,0);  
    m_BallManagementSubSystem.upBallCage(0.05);
    m_BallManagementSubSystem.returnBalls();
    
    // new WaitCommand(2);
   
    //System.out.println("Temporary Auto-Drive Rotate");
    initTime = RobotController.getFPGATime();
    while (RobotController.getFPGATime() - initTime >= millisecondsToRun) {
        
    }
    /*
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
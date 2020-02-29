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
                              m_drive.clearLine();
                                //Robot moves forward for 3 feet
                              m_drive.start(startA);
                                //Robot moves to portal from position closest to portal
                                
                              m_drive.start(startB);
                                //Robot moves to portal from middle positiion 
                              m_drive.start(startC);
                                //Robot moves to portal from position farthest from portal
                            


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
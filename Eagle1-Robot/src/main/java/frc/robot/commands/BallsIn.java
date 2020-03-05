


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.BallManagementSubSystem;


public class BallsIn extends CommandBase {
    private final BallManagementSubSystem m_BallManagementSubSystem;

    public BallsIn (BallManagementSubSystem subSystem) {
      m_BallManagementSubSystem = subSystem;
  // CONTINUE FROM HERE ADD REQUIREMENT FROM THIS LINK
  // https://github.com/wpilibsuite/allwpilib/blob/master/wpilibjExamples/src/main/java/edu/wpi/first/wpilibj/templates/commandbased/commands/ExampleCommand.java
       addRequirements(m_BallManagementSubSystem);

    }
    
    @Override
    public final void initialize () {

    }

    @Override
    public final void execute () {
        m_BallManagementSubSystem.pickupBalls();
        
    }

    @Override
    public final void end (boolean interrupted) {
       
        m_BallManagementSubSystem.setRollerMotorBrake(0);
        

    }


    @Override
    public boolean isFinished() {
     return false;
   }
   
  
}
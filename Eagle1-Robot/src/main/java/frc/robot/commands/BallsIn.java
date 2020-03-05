


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

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

    }

    @Override
    public final void end (boolean interrupted) {
      
    }

    @Override
    public boolean isFinished() {
     return false;
    }
  
}



package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.BallManagementSubSystem;


public class BallCageDown extends CommandBase {
    private final BallManagementSubSystem m_BallManagementSubSystem;

    public BallCageDown (BallManagementSubSystem subSystem) {
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
        m_BallManagementSubSystem.downBallCage ();
    }

    @Override
    public final void end (boolean interrupted) {
        m_BallManagementSubSystem.setCageMotorBrake (0);
    }

    @Override
    public boolean isFinished() {
     return false;
    }
  
}


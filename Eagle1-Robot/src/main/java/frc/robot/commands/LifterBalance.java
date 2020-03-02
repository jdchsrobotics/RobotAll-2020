/*
 *  Lifter SubSystem Commands
 *  -> Release Brake
 *  -> Motor Down
*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.LifterSubSystem;

public class LifterBalance extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final LifterSubSystem m_lifter;
    
    public LifterBalance (LifterSubSystem subsystem) {
      m_lifter = subsystem;

      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_lifter);
    }

    @Override
    public final void initialize () {
        m_lifter.setBrake();
    }

    @Override
    public final void execute () {
        // remove to real code connected to a button later
        m_lifter.moveBalance ();

    }
    

    @Override
    public final void end (boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        // Above commands should be based on Buttons vs "isfinsihed"
     return false;
    }

}
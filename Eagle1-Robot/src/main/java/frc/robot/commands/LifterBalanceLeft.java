/*
 *  Lifter SubSystem Commands
 *   LiftBalancer
 *  -> Move Left/Right based on Joystick on Xbox
 * 
*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.LifterSubSystem;

public class LifterBalanceLeft extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final LifterSubSystem m_lifter;
    
    public LifterBalanceLeft (LifterSubSystem subsystem) {
      m_lifter = subsystem;

      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_lifter);
    }

    @Override
    public final void initialize () {
        m_lifter.setMotorBrake();
    }


    // ACTION - Add paraemter to use joystick value like drive subsystem
    @Override
    public final void execute () {
        // remove to real code connected to a button later

        m_lifter.moveBalanceLeft();

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
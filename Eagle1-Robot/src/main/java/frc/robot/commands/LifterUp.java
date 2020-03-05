/*
 *  Lifter SubSystem Commands
 *  -> Set Brake
 *  -> Lift Up
 *  -> Lift Down
 *  -> Balance Left
 *  -> Balance Right
*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.LifterSubSystem;

public class LifterUp extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final LifterSubSystem m_lifter;
    
    public LifterUp (LifterSubSystem subsystem) {
      m_lifter = subsystem;

      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_lifter);
    }

    @Override
    public final void initialize () {
        m_lifter.setMotorBrake();
        m_lifter.releaseLiftParkingBrake();
    }

    // POSSBILE ACTION - use the joystick value for up/down speed
    @Override
    public final void execute () {
        // remove to real code connected to a button later
        m_lifter.releaseLiftParkingBrake();
        // ACTION - setup to use xbox controller
        m_lifter.moveUpConstantSpeed();
    }
    

    @Override
    public final void end (boolean interrupted) {
        m_lifter.setLiftParkingBrake();
        m_lifter.setMotorBrake();
    }

    @Override
    public boolean isFinished() {
        // Above commands should be based on Buttons vs "isfinsihed"
     return false;
    }

}
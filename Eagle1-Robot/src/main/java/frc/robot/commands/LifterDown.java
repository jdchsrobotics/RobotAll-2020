/*
 *  Lifter SubSystem Commands
 *  -> Release Brake
 *  -> Motor Down
*/


package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.LifterSubSystem;

public class LifterDown extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final LifterSubSystem m_lifter;
    
    public LifterDown (LifterSubSystem subsystem) {
      m_lifter = subsystem;

      // Use addRequirements() here to declare subsystem dependencies.
      addRequirements(m_lifter);
    }

    @Override
    public final void initialize () {
//    m_lifter.setMotorBrake();
//        m_lifter.setLiftParkingBrake();
    }


    // POSSIBLE ACTION - use the joysticke value for speed up/down
    @Override
    public final void execute () {
        // remove to real code connected to a button later
        m_lifter.releaseLiftParkingBrake();
        // ACTION - setup to use Xbox Joystick up/down
        m_lifter.moveDownConstantSpeed();
    }
    

    @Override
    public final void end (boolean interrupted) {
        m_lifter.setLifterMotorSpeed(0);
        m_lifter.setLiftParkingBrake();
        m_lifter.setMotorBrake();

    }

    @Override
    public boolean isFinished() {
        // Above commands should be based on Buttons vs "isfinsihed"
     return false;
    }

}
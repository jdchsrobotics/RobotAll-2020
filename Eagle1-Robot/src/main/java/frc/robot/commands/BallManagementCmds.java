/*****
 *   USed for Ball SubSystem Management
 * 
 * MOTIONS: 
 *  1.  Flip Forward  (probalby bosh windows motors)
 *  2.  Flip UP/Back  
 *  3.  Pull in Balls  (Forward on Motors (Probably Talons SPX))
 *  4.  Push OUt Balls (Reverse on Motors (probably Taoons SPX))
 * 
 */

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.BallManagementSubSystem;


public class BallManagementCmds extends CommandBase {

    
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
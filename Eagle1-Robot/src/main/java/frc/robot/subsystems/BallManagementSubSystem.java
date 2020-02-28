
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

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.DemandType;


public class BallManagementSubSystem extends SubsystemBase {
    // ACTION - check CAN BUS ID
    TalonSRX m_ballrollerBR = new TalonSRX(21);

   // ADD PMW + TALON for Window Montor
   TalonSRX m_ballupdownWM = new TalonSRX(22);
   // PMW Line here


    //  Add subsystem class info here

}
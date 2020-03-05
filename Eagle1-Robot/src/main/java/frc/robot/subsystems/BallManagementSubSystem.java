
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
import frc.robot.Constants.ballConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;


    
public class BallManagementSubSystem extends SubsystemBase {
    // ACTION - check CAN BUS ID
    TalonSRX  m_ballrollerBL = new TalonSRX(ballConstants.leftRollerMotor);
    TalonSRX  m_ballrollerBR = new TalonSRX(ballConstants.rightRollMotor);  
    VictorSPX m_ballupdownWM = new VictorSPX(ballConstants.ballupdownMotor);
   // PMW Line here  


    //  Add subsystem class info here


    public void pickupBalls () {
        m_ballrollerBL.set (ControlMode.PercentOutput,-0.35);
        m_ballrollerBR.set (ControlMode.PercentOutput,0.85);
    }

    public void returnBalls () {
        m_ballrollerBL.set (ControlMode.PercentOutput,0.35);
        m_ballrollerBR.set (ControlMode.PercentOutput,-0.85);
    }

    public void downBallCage () {
        m_ballupdownWM.set (ControlMode.PercentOutput, -0.1);
    }

    public void upBallCage () {
        m_ballupdownWM.set (ControlMode.PercentOutput, 0.2);
    }


    @Override
    public void periodic() {
        // USed to test of motor is alive

     // m_ballupdownWM.set (ControlMode.PercentOutput, -0.2);
    }



}
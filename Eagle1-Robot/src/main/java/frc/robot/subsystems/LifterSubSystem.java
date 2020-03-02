/*
Climber Comments:

Commands:
1. Raise Bar (RB)
2. Lower Bar (LB)
3. Balance Left (LT)
4. Balance Right (RT)
5. Bar Lock/Unlock (L3)

Total of 5 buttons
*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// Talon Libraries
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import frc.robot.Constants.lifterConstants;

// import com.ctre.phoenix.motorcontrol.NeutralMode;
// import com.ctre.phoenix.motorcontrol.ControlMode;
// import com.ctre.phoenix.motorcontrol.DemandType;

  // ACTION - update for servo
  // Ultrasonic sensor for drive
  // private Ultrasonic ultrasonic_drive = new Ultrasonic(Constants.ULTRASONIC_DRIVE[0], Constants.ULTRASONIC_DRIVE[1]);
  // Double solenoid for changing gears from tea 612 - we only need it to stop the lifter from comming down
  // private DoubleSolenoid solenoid_drive = new DoubleSolenoid(Constants.PCM_2, Constants.SOLENOID_DRIVE[0], Constants.SOLENOID_DRIVE[1]);


/* From CONSTANTS file - for reference -->  Lifter Contants
    public static final class lifterConstants {
        public static final int liftermotor = 6;  // Sparcmax
        public static final int balancemotor = 21;  // Talon SRX
        public static final float runUpMotor = (float) 0.5;
        public static final float runDownMotor = (float) 0.5; 
    }
*/ 



// SparcMax Libraries
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANError;

// ACTION _ FIx after we configure the Talon
//
public class LifterSubSystem extends SubsystemBase {

    // ACTION: Check CANBUS Id
 private final TalonSRX    m_leveler        = new TalonSRX(lifterConstants.balancemotor);
 private final CANSparkMax m_lifter         = new CANSparkMax(lifterConstants.liftermotor, MotorType.kBrushless);

    //  Add subsystem class info here
  //  m_pidController.setOutputRange(kMinOutput, kMaxOutput);

// Set Lifter to Brake if not operating
  public void setBrake() {
     if(m_lifter.setIdleMode(IdleMode.kBrake) != CANError.kOk){
         SmartDashboard.putString("Idle Mode", "Error");
    }
 // m_lifter.setIdleMode(IdleMode.kBrake);

// Check Lifter Setting
   if(m_lifter.getIdleMode() == IdleMode.kBrake) {
        SmartDashboard.putString("Idle Mode", "Coast");
      } else {
        SmartDashboard.putString("Idle Mode", "Brake");
      }

   }

  public void moveUpConstantSpeed (){
    m_lifter.set(0.25);

  }
  @Override
  public void periodic() {
    m_lifter.set(0.25);
  }

}
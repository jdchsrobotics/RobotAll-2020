/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.eagle_DriveConstants;
import frc.robot.Constants.EncoderConstants;
// import frc.robot.commands.Default_Drive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
// import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// needed for CAN Spark MAx 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANPIDController;
import com.revrobotics.EncoderType;
import com.revrobotics.ControlType;

// iF you use ultrasonic sensor for drive sub-system 
import edu.wpi.first.wpilibj.Ultrasonic;

// Add Encoder 
public class DriveSubSystem extends SubsystemBase {

    /**
     * Creates a new Drive Subsystem.
     * Code REfactored using team 612 - thank you team 612 for some coding simplifications
     * https://github.com/Team612/612-2020/blob/master/team612/src/main/java/frc/robot/subsystems/Drivetrain.java
     */

  // Ultrasonic sensor for drive if used
  // private Ultrasonic ultrasonic_drive = new Ultrasonic(Constants.ULTRASONIC_DRIVE[0], Constants.ULTRASONIC_DRIVE[1]);


 // Create the drive based on SparcMax Controllers and Brushless motors in a 2x2 configuration
 // LEft Motor 1/4, right motor 2/3 
  private final CANSparkMax m_leftMotor       = new CANSparkMax(eagle_DriveConstants.leftMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_leftMotorSlave  = new CANSparkMax(eagle_DriveConstants.leftSlaveMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor      = new CANSparkMax(eagle_DriveConstants.rightMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotorSlave = new CANSparkMax(eagle_DriveConstants.rightSlaveMotorCanID, MotorType.kBrushless);

// Tie Front and Back Motors together on each side
  private final SpeedControllerGroup m_left  = new SpeedControllerGroup(m_leftMotor, m_leftMotorSlave);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotor, m_rightMotorSlave);

// NOTE Above could be coded as :::  
/*****
 * private final SpeedControllerGroup m_left  = new SpeedControllerGroup(
 *    new CANSparkMax(eagle_DriveConstants.leftMotorCanID, MotorType.kBrushless)
 *   ,new CANSparkMax(eagle_DriveConstants.leftSlaveMotorCanID, MotorType.kBrushless)
 *  );
 * private final SpeedControllerGroup m_right  = new SpeedControllerGroup(
 *    new CANSparkMax(eagle_DriveConstants.rightMotorCanID, MotorType.kBrushless)
 *   ,new CANSparkMax(eagle_DriveConstants.rightSlaveMotorCanID, MotorType.kBrushless)
 *  );
 ******/

private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);

// NOTE:  Encoder code should go here when ready to use it
// NOTE DIAGNOSE ACTION NEEDED - we need to find this method call and understand it 
// m_left_drive_encoder = m_left.getAverageEncoderDistance();
// m_right_drive_encoder = m_right.getAverageEncoderDistance();

 
  // The left-side drive encoder
  // Uses Defaults of the 'motors' encorder connected to sparkmax
  private final CANEncoder m_leftdriveEncoder =
      new CANEncoder(m_leftMotor);
// ALTERNATE  :     m_encoder = m_motor.getEncoder(EncoderType.kQuadrature, 4096);
// From : https://github.com/REVrobotics/SPARK-MAX-Examples/blob/master/Java/Encoder%20Feedback%20Device/src/main/java/frc/robot/Robot.java

// Reset values - we probably don't want this
// m_motor.restoreFactoryDefaults(); (but we need to research)

  // The right-side drive encoder
  // Uses Defaults of the 'motors' encorder connected to sparkmax
  private final CANEncoder m_rightdriveEncoder =
      new CANEncoder (m_rightMotor);

  // RESEARCH: SparkMax equivalent
  /*  Sets the distance per pulse for the encoders
    m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
  }
  */

//  old drive subsystem call great for testing but does not work with autonomous and bypasses standard command programming
/* 
m_robotDrive.joy_arcadeDrive (
                                (-1 * m_stick.getY())
                                , m_stick.getX()  )
*/

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void joy_arcadeDrive(double fwd, double rot) {

    if(fwd >= -0.1 && fwd <= 0.1){
      fwd = 0;
    }

    if(rot >= -0.1 && rot <= 0.1){
      rot = 0;
    }
    /* Alternate code to deal with "center position joystick" 
    //  CLeaner syntax that if statememnts
    x_axis = Math.abs(x_axis) < DEADZONE ? 0.0 : x_axis;
    y_axis = Math.abs(y_axis) < DEADZONE ? 0.0 : y_axis;
    */

    SmartDashboard.putNumber("Sparmax Left Speed Get", m_leftMotor.get());
    SmartDashboard.putNumber("Sparmax Right Speed Get", m_rightMotor.get());
    
    m_robotDrive.arcadeDrive(fwd, rot);

    /**
     * Encoder position is read from a CANEncoder object by calling the
     * GetPosition() method.
     * GetPosition() returns the position of the encoder in units of revolutions
     */

    /**
     * Encoder velocity is read from a CANEncoder object by calling the
     * GetVelocity() method.
     * GetVelocity() returns the velocity of the encoder in units of RPM
     */
   
  }

// Once Encoders are used need something like this
/**
 * 
 *  
   * Resets the drive encoders to currently read a position of 0.
   
  public void resetEncoders() {
    // I THINK THIS IS "setPosition(double xx)" in revrobotsi - same reference HTTP as above
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  
   * Gets the average distance of the two encoders.
   *
   * @return the average of the two encoder readings
   
  public double getAverageEncoderDistance() {
    return (m_leftEncoder.getDistance() + m_rightEncoder.getDistance()) / 2.0;
  }

  
   * Gets the left drive encoder.
   *
   * @return the left drive encoder
   
  public Encoder getLeftEncoder() {
    return m_leftEncoder;
  }

   * Gets the right drive encoder.
   *
   * @return the right drive encoder
   
  public Encoder getRightEncoder() {
    return m_rightEncoder;
  }
 * 
 */



 
  @Override
  public void periodic() {
    SmartDashboard.putNumber("Encoder Left Position", m_leftdriveEncoder.getPosition());
    SmartDashboard.putNumber("Encoder Right Position", m_rightdriveEncoder.getPosition());

    SmartDashboard.putNumber("Encoder counts per Rev", m_leftdriveEncoder.getCountsPerRevolution());
    SmartDashboard.putNumber("Encoder counts per REv", m_rightdriveEncoder.getCountsPerRevolution());

    SmartDashboard.putNumber("Encoder Left Velocity", m_leftdriveEncoder.getVelocity());
    SmartDashboard.putNumber("Encoder Right Velocity", m_leftdriveEncoder.getVelocity());
    SmartDashboard.putNumber("Encoder Left Vel Conv Factor", m_leftdriveEncoder.getVelocityConversionFactor());
    SmartDashboard.putNumber("Encoder Right Vel Conv Factor", m_leftdriveEncoder.getVelocityConversionFactor());

    // This method will be called once per scheduler run
  }
}

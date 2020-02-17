/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.eagle_DriveConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
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

// Add Encoder 
public class DriveSubSystem extends SubsystemBase {

    /**
     * Creates a new ExampleSubsystem.
     */

 // LEft Motor 1/4, right motor 2/3 
  private final CANSparkMax m_leftMotor = new CANSparkMax(eagle_DriveConstants.leftMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_leftMotorSlave = new CANSparkMax(eagle_DriveConstants.leftSlaveMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(eagle_DriveConstants.rightMotorCanID, MotorType.kBrushless);
  private final CANSparkMax m_rightMotorSlave = new CANSparkMax(eagle_DriveConstants.rightSlaveMotorCanID, MotorType.kBrushless);
// 1,4   tight2,3

// Tie Front and Back Motors together on each side
  private final SpeedControllerGroup m_left  = new SpeedControllerGroup(m_leftMotor, m_leftMotorSlave);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotor, m_rightMotorSlave);

// NOTE Above could be coded as :::  
/*****
 * 
 * private final SpeedControllerGroup m_left  = new SpeedControllerGroup(
 *    new CANSparkMax(eagle_DriveConstants.leftMotorCanID, MotorType.kBrushless)
 *   ,new CANSparkMax(eagle_DriveConstants.leftSlaveMotorCanID, MotorType.kBrushless)
 *  );
 * private final SpeedControllerGroup m_right  = new SpeedControllerGroup(
 *    new CANSparkMax(eagle_DriveConstants.rightMotorCanID, MotorType.kBrushless)
 *   ,new CANSparkMax(eagle_DriveConstants.rightSlaveMotorCanID, MotorType.kBrushless)
 *  );
 * 
 ******/

private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);

// NOTE:  Encoder code should go here when ready to use it
// NOTE DIAGNOSE ACTION NEEDED - we need to find this method call and understand it 
// m_left_drive_encoder = m_left.getAverageEncoderDistance();
// m_right_drive_encoder = m_right.getAverageEncoderDistance();

/***** 
  // The left-side drive encoder
  private final Encoder m_leftEncoder =
      new Encoder(DriveConstants.kLeftEncoderPorts[0], DriveConstants.kLeftEncoderPorts[1],
                  DriveConstants.kLeftEncoderReversed);

  // The right-side drive encoder
  private final Encoder m_rightEncoder =
      new Encoder(DriveConstants.kRightEncoderPorts[0], DriveConstants.kRightEncoderPorts[1],
                  DriveConstants.kRightEncoderReversed);

 //   Creates a new DriveSubsystem.
   
  public DriveSubsystem() {
    // Sets the distance per pulse for the encoders
    m_leftEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
    m_rightEncoder.setDistancePerPulse(DriveConstants.kEncoderDistancePerPulse);
  }

  public DriveSubSystem() {
     m_robotDrive.arcadeDrive(xSpeed, zRotation);

  }

*************/

  /**
   * Drives the robot using arcade controls.
   *
   * @param fwd the commanded forward movement
   * @param rot the commanded rotation
   */
  public void arcadeDrive(double fwd, double rot) {

    if(fwd >= -0.1 && fwd <= 0.1){
      fwd = 0;
    }

    if(rot >= -0.1 && rot <= 0.1){
      rot = 0;
    }

    m_robotDrive.arcadeDrive(fwd, rot);
  }


// Once Encoders are used need something like this
/**
 * 
 *  
   * Resets the drive encoders to currently read a position of 0.
   
  public void resetEncoders() {
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
    // This method will be called once per scheduler run
  }
}

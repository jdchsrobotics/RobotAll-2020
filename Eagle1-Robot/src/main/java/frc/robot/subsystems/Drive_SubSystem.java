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
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// needed for CAN Spark MAx 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drive_SubSystem extends SubsystemBase {

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

private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);

  public Drive_SubSystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

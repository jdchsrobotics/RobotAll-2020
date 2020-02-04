package frc.robot;
/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// needed for CAN Spark MAx 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


// Below is need for antonomous
// import edu.wpi.first.wpilibj.Timer;

/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with arcade steering.
 */
public class Robot extends TimedRobot {
  // private final PWMVictorSPX m_leftMotor = new PWMVictorSPX(0);
  // private final PWMVictorSPX m_rightMotor = new PWMVictorSPX(1);

 // LEft Motor 1/4, right motor 2/3 
 private final CANSparkMax m_leftMotor = new CANSparkMax(1, MotorType.kBrushless);
 private final CANSparkMax m_leftMotorSlave = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax m_rightMotor = new CANSparkMax(2, MotorType.kBrushless);
  private final CANSparkMax m_rightMotorSlave = new CANSparkMax(3, MotorType.kBrushless);
// 1,4   tight2,3

  private final SpeedControllerGroup m_left  = new SpeedControllerGroup(m_leftMotor, m_leftMotorSlave);
  private final SpeedControllerGroup m_right = new SpeedControllerGroup(m_rightMotor, m_rightMotorSlave);

  // private DifferentialDrive m_myRobot;
  private final Joystick m_stick = new Joystick(0);
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.


// Add m_stick stuff here with 0.1 math
// then call with variables 
  final double moveVal = -m_stick.getY();
  final double turnVal = m_stick.getX();
   

 // if (moveVal < 0.1)  { moveVal = 0.0; } ;
 // if (1 < 0.1)  { turnVal = 0.0; } ;

 m_robotDrive.arcadeDrive(moveVal, turnVal  );
//  m_robotDrive.arcadeDrive(1 ,0.5  );
//  m_robotDrive.arcadeDrive(moveVal, turnVal);
  }


}

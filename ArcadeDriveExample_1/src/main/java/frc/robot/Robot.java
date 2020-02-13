package frc.robot;
/*----------------------------------------------------------------------------*/

/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
// test comment feel free to remove


import edu.wpi.first.wpilibj.Joystick;
// import edu.wpi.first.wpilibj.PWMVictorSPX;
// import edu.wpi.first.wpilibj.CAN.TalonSRX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

// needed for CAN Spark MAx 
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;


/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with arcade steering.
 */
public class Robot extends TimedRobot {
  // private final PWMVictorSPX m_leftMotor = new PWMVictorSPX(0);
  // private final PWMVictorSPX m_rightMotor = new PWMVictorSPX(1);

  TalonSRX mytalon = new TalonSRX(21);
    /**
     * Change the I2C port below to match the connection of your color sensor
     */
  
    private final I2C.Port i2cPort = I2C.Port.kOnboard;
  
    /**
     * A Rev Color Sensor V3 object is constructed with an I2C port as a 
     * parameter. The device will be automatically initialized with default 
     * parameters.
     */
  
    private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
    private final ColorMatch m_colorMatcher = new ColorMatch();
    /**
     * Note: Any example colors should be calibrated as the user needs, these
     * are here as a basic example.
     */
  
    private final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
    private final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
    private final Color kRedTarget = ColorMatch.makeColor(0.561, 0.232, 0.114);
    private final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
  
  




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
  public void robotInit() {
    m_colorMatcher.addColorMatch(kBlueTarget);
    m_colorMatcher.addColorMatch(kGreenTarget);
    m_colorMatcher.addColorMatch(kRedTarget);
    m_colorMatcher.addColorMatch(kYellowTarget);    

    mytalon.set(ControlMode.PercentOutput, .2);
  }

  @Override
  public void robotPeriodic() {

    /**
     * The method GetColor() returns a normalized color value from the sensor and can be
     * useful if outputting the color to an RGB LED or similar. To
     * read the raw color, use GetRawColor().
     * 
     * The color sensor works best when within a few inches from an object in
     * well lit conditions (the built in LED is a big help here!). The farther
     * an object is the more light from the surroundings will bleed into the 
     * measurements and make it difficult to accurately determine its color.
     */
    Color detectedColor = m_colorSensor.getColor();
    
    /**
     * Run the color match algorithm on our detected color
     */

    String colorString;
    ColorMatchResult match = m_colorMatcher.matchClosestColor(detectedColor);

    if (match.color == kBlueTarget) {
      colorString = "Blue";
    } else if (match.color == kRedTarget) {
      colorString = "Red";
    } else if (match.color == kGreenTarget) {
      colorString = "Green";
    } else if (match.color == kYellowTarget) {
      colorString = "Yellow";
    } else {
      colorString = "Unknown";
    }
    /**
     * Open Smart Dashboard or Shuffleboard to see the color detected by the 
     * sensor.
     */
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("Confidence", match.confidence);
    SmartDashboard.putString("Detected Color", colorString);

  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.


// Add m_stick stuff here with 0.1 math
// then call with variables 

  double moveVal = -m_stick.getY();
  double turnVal = m_stick.getX();
   
   // System.out.print("Joystick_values");
   
// + FOrward  - Backward
 if (moveVal >  0.8)  { moveVal = 0.7; } ;
 if (moveVal <  -0.8 ) { moveVal = -0.7 ;}  ;
 if (turnVal > 0.8 ) {turnVal = 0.7;} ;
 if (turnVal < -0.8 ) {turnVal = -0.7;} ;

 // if (moveVal < 0.1)  { moveVal = 0.0; } ;
 // if (1 < 0.1)  { turnVal = 0.0; } ;

 m_robotDrive.arcadeDrive(moveVal, turnVal  );
 mytalon.set(ControlMode.PercentOutput, turnVal);
//  m_robotDrive.arcadeDrive(1 ,0.5  );
//  m_robotDrive.arcadeDrive(moveVal, turnVal);
  }

  }


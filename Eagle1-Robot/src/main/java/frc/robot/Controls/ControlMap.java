package frc.robot.Controls;

import frc.robot.Constants.OI_Constants;
import frc.robot.Constants.Xbox_Constants;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
//import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;


public class ControlMap{
  // Controller objects
  public static Joystick m_driver_stick = new Joystick(OI_Constants.Joystick_1_portID);
  public static XboxController m_helper_xbox = new XboxController(OI_Constants.xbox_Controller_portID);
  
  // Map Colors   ka = green, kB = REd, ky = yellow, kx=blue
    public final static Button getkA_Green = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kA.value );
    public final static Button getkB_Red = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kB.value );
    public final static Button getkY_Yellow = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kY.value );
    public final static Button getkX_Blue = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kX.value );

    // Map lifter
    public final static Button getB5_LiftUp = new JoystickButton(ControlMap.m_driver_stick, 5 );
    public final static Button getB3_LiftDown = new JoystickButton(ControlMap.m_driver_stick, 3);
    public final static Button getB6_BalRight = new JoystickButton(ControlMap.m_driver_stick, 6 );
    public final static Button getB4_BalLeft = new JoystickButton(ControlMap.m_driver_stick, 4 );

    // Map Ball Subsystem
    public final static Button getStkLeft_CageUp = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kStickLeft.value );
    public final static Button getStkRight_CageUp = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kStickRight.value );
    public final static Button getBumpLeft_BallsIN = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kBumperLeft.value );
    public final static Button getBumpRight_BallsOUT = new JoystickButton(ControlMap.m_helper_xbox, XboxController.Button.kBumperRight.value );
 



    // Driver buttons
/*
    public static JoystickButton driver_button_A    	= new JoystickButton(driver,1);
    public static JoystickButton driver_button_B 		= new JoystickButton(driver,2);
    public static JoystickButton driver_button_X    	= new JoystickButton(driver,3);
    public static JoystickButton driver_button_Y    	= new JoystickButton(driver,4);
    public static JoystickButton driver_button_LB   	= new JoystickButton(driver,5);
    public static JoystickButton driver_button_RB   	= new JoystickButton(driver,6);
    public static JoystickButton driver_button_BCK  	= new JoystickButton(driver,7);
    public static JoystickButton driver_button_STRT 	= new JoystickButton(driver,8);
    public static JoystickButton driver_button_LJ   	= new JoystickButton(driver,9);
    public static JoystickButton driver_button_RJ   	= new JoystickButton(driver,10);
*/


    



}
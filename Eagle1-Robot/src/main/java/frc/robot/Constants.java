/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // Drive Variables
    public static final class eagle_DriveConstants {
        // LEft Motor 1/4, right motor 2/3 
        public static final int leftMotorCanID = 1;
        public static final int leftSlaveMotorCanID = 4; 
        public static final int rightMotorCanID = 2; 
        public static final int rightSlaveMotorCanID = 3;
}
    // Lifter Contants
    public static final class lifterConstants {
        public static final int liftermotor = 6;  // Sparcmax
        public static final int balancemotor = 21;  // Talon SRX
        public static final float runUpMotor = (float) 0.5;
        public static final float runDownMotor = (float) 0.5;
    }

    // Ball Mangement Constants
    public static final class ballConstants {
        public static final int ballupdownMotor = 22;  // Talon SPX VexPro (window motor)V
        public static final int leftRollerMotor = 23;  // Talon SRX 
        public static final int rightRollMotor = 24;   // Talon SRX
        public static final float runDownTimeRollers = (float) 0.2; // Window Motor Down
        public static final float runUpTimeRollers   = (float) 0.2; // Window Motor Up
    }

    public static final class EncoderConstants {
        public static final int LeftEncoderID = 1;
        public static final int LeftSlaveEncoderID = 4;
        public static final int LeftEncoderReverseID = 0;
        // RESEARCH: value of reverseID either 0 or 1
        public static final int RightEncoderID = 2;
        public static final int RightSlaveEncoderID = 3;
        public static final int RightEncoderReverseID = 1;
        // RESEARCH: value of reverseID either 0 or 1
        
        public static final double kP = 5e-5; 
        public static final double kI = 1e-6;
        public static final double kD = 0; 
        public static final double kIz = 0; 
        public static final double kFF = 0.000156; 
        public static final double kMaxOutput = 1; 
        public static final double kMinOutput = -1;
        public static final double maxRPM = 5700;

    }

    // Input/OI Type devices
    public static final class OI_Constants {
        // Joystick - port 0
        public static final int Joystick_1_portID = 1;
        // Xbox Controller port
        public static final int xbox_Controller_portID = 2;

    }
    public static final class Xbox_Constants {
        public static final int XboxButtonA = 1;
        public static final int XboxButtonB = 2;
        public static final int XboxButtonX = 3;
        public static final int XboxButtonY = 4;

        public static final int XboxLeftBumper = 5;
        public static final int XboxRightBumper = 6;

        public static final int XboxStartButton = 7;
        public static final int XboxMenuButton = 8;


        //Double check the values for buttons
    }

    public static final class AutoConstants {
        public static final double AutoDriveSpeed = 0.5;
        public static final double AutoDriveRotation = 0.5;

        public static final double AutoREBDriveSpeed = -0.5;
        public static final double AutoREBDriveRotation = -0.5;
      }
      
    public static final class ColorConstants {

        public static final double Blue1 = 0.143;
        public static final double Blue2 = 0.427;
        public static final double Blue3 = 0.429;

        public static final double Green1 = 0.197;
        public static final double Green2 = 0.561;
        public static final double Green3 = 0.240;

        public static final double Red1 = 0.561;
        public static final double Red2 = 0.232;
        public static final double Red3 = 0.114;

        public static final double Yellow1 = 0.361;
        public static final double Yellow2 = 0.524;
        public static final double Yellow3 = 0.113;
    }
}
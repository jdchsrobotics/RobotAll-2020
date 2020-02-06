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

    // Input/OI Type devices
    public static final class OI_Constants {
        // Joystick - port 1
        public static final int Joystick_1_portID = 0;

    }
    public static final class Xbox_Constants {
        public static final int Xbox_Button_A = 1;
        public static final int Xbox_Button_B = 2;
        public static final int Xbox_Button_X = 3;
        public static final int Xbox_Button_Y = 4;

        //Double check the values for buttons
    }



}

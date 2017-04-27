package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by LOCKESST on 4/27/2017.
 */

public class Hard_CrabBot {
    //Opmode Members
    LinearOpMode Opmode;
    DcMotor BackLeft = null;
    DcMotor BackRight = null;
    DcMotor FrontLeft = null;
    DcMotor FrontRight =  null;
    DcMotor BeaconPusher = null;
    DcMotor Center = null;

    double Forward_Backword = 0;
    double Strafing = 0;
    double Rotation = 0;
    // "Contructor Needed"
    public  Hard_CrabBot(){
    }
    public void StartDriving(LinearOpMode thisOpmode){
        Opmode = thisOpmode;

        BackLeft = Opmode.hardwareMap.dcMotor.get("BackLeft");
        BackRight = Opmode.hardwareMap.dcMotor.get("BackRight");
        FrontLeft = Opmode.hardwareMap.dcMotor.get("FrontLeft");
        FrontRight = Opmode.hardwareMap.dcMotor.get("FrontRight");
        BeaconPusher = Opmode.hardwareMap.dcMotor.get("BeaconPusher");
        Center = Opmode.hardwareMap.dcMotor.get("Center");

        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}

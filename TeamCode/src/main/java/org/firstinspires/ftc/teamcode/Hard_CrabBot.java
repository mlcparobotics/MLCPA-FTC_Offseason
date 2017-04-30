package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by ANDRES SALAS
 */

public class Hard_CrabBot {
    //Opmode Members
    LinearOpMode Opmode;
    DcMotor BackLeft = null;
    DcMotor BackRight = null;
    DcMotor FrontLeft = null;
    DcMotor FrontRight = null;
    DcMotor BeaconPusher = null;
    DcMotor Center = null;

    // "Contructor Needed"
    public Hard_CrabBot() {
    }

    public void Standard_Hardware_declaration(LinearOpMode thisOpmode) {
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

    public void TeleopDrive() {
        FrontRight.setPower(-Opmode.gamepad1.right_stick_y);
        BackRight.setPower(-Opmode.gamepad1.right_stick_y);
        FrontLeft.setPower(Opmode.gamepad1.left_stick_y);
        FrontRight.setPower(Opmode.gamepad1.left_stick_y);
        Center.setPower(-Opmode.gamepad1.right_trigger);
        Center.setPower(Opmode.gamepad1.left_stick_y);
        while (Opmode.gamepad1.a) {
            BeaconPusher.setPower(.5);
        }
        BeaconPusher.setPower(0);

    }
}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by ANDRES SALAS
 */
@TeleOp (name = "TeleopMode")
public class Opmode extends LinearOpMode {
    Hard_CrabBot  CrabBot = new Hard_CrabBot();
    ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode()throws InterruptedException{
        waitForStart();
        runtime.reset();
        while (isStarted() == false){
            telemetry.addData("Press Play To Begin", "><");
            telemetry.update();

        while (opModeIsActive()){
            CrabBot.TeleopDrive();
            }

        }



    }
}

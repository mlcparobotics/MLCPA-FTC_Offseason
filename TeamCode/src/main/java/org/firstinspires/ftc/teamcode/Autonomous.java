package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by ANDRES SALAS
 */

public class Autonomous extends LinearOpMode{
    Hard_CrabBot CrabBot_Hardware = new Hard_CrabBot();
    TrackingSoftware Vuforia = new TrackingSoftware();
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Press Play To Start", "><");
        telemetry.update();
        waitForStart();
        runtime.reset();

        while (opModeIsActive()){
            telemetry.addData("HAVE FUN!", "><");
        }

    }
}

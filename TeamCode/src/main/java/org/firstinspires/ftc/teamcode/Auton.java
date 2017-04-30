package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by ANDRES SALAS
 */
@Autonomous(name = "Auton", group = "Autonomous")
public class Auton extends LinearOpMode{
    Hard_CrabBot CrabBot_Hardware = new Hard_CrabBot();
    TrackingSoftware Vuforia = new TrackingSoftware();
    ElapsedTime runtime = new ElapsedTime();


    private void TurnLeft(double x, int i){
        CrabBot_Hardware.FrontLeft.setPower(x);
        CrabBot_Hardware.BackLeft.setPower(x);
        sleep(i);
    }
    private void TurnRight(double y, int a){
        CrabBot_Hardware.BackRight.setPower(y);
        CrabBot_Hardware.FrontRight.setPower(y);
        sleep(a);

    }
    private void Forward_Backward(double m, int k){
        CrabBot_Hardware.FrontRight.setPower(m);
        CrabBot_Hardware.BackRight.setPower(m);
        CrabBot_Hardware.BackLeft.setPower(m);
        CrabBot_Hardware.FrontLeft.setPower(m);
        sleep(k);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        CrabBot_Hardware.Standard_Hardware_declaration(this);

        telemetry.addData("Press Play To Start", "><");
        telemetry.update();
        waitForStart();
        runtime.reset();

        while (opModeIsActive()){
            telemetry.addData("HAVE FUN!", "><");

            CrabBot_Hardware.Center.setPower(.6);
            sleep(1000);
            TurnLeft(.5, 500);
            Forward_Backward(.7, 1500);
            sleep(300000);


        }

    }
}

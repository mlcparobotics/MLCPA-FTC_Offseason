package org.firstinspires.ftc.teamcode;
import com.qualcomm.ftccommon.FtcRobotControllerService;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.internal.FtcRobotControllerActivity;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

/**
 * Created by ANDRES SALAS
 */
@TeleOp (name = "TeleopMode")
public class Opmode extends LinearOpMode {
    Hard_CrabBot  CrabBot = new Hard_CrabBot();
    ElapsedTime runtime = new ElapsedTime();
    private VuforiaLocalizer Vuforia;
    private static final String TAG = "Vuforia";
    @Override
    public void runOpMode()throws InterruptedException{
        waitForStart();
        runtime.reset();
        CrabBot.Standard_Hardware_declaration(this);

        VuforiaLocalizer.Parameters up = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        up.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;
        this.Vuforia = ClassFactory.createVuforiaLocalizer(up);
        up.vuforiaLicenseKey = "AbUZtgH/////AAAAGXeLnnQrrU5+qrxK0IAwAalZnkNmyO94eGoqcSeXitwa/YkBzM/9YPiM/m1H9mhBrP89G5amGmzbfsDfNu3lVvp97tzix+3H3TMUuODMQj6PdkNciCEDaud+KQR+hQeiupqz6n9s0RMf/MHyefUUGvnF7Ltd1mXFSAqaObvFgWl6DFi0GtLhz5Fa+DZoPrT4n8BkoiGkY4psDR5OEu+yYGbLi9SGB75dlMGhYbQYYE2yiACv0YjZstfQwoxWwKCq/U6ibd2s16wMfBEOVrBVInH6DS4q0TUFQysZ3NRKL8j0mlsbAdVmRMWskeXs4v7GI89T/n0+wmn3o4dxBxgpL+h+6QtJOAFyQlRcCuXkX4o3";


        while (!isStarted()){
            telemetry.addData("Press Play To Begin", "><");
            telemetry.update();


        while (opModeIsActive()){
            telemetry.addData("HAVE FUN!", "><");
            telemetry.update();
            CrabBot.TeleopDrive();
            if (gamepad1.dpad_down){
                this.telemetry.addData("Camera View:", up.cameraMonitorFeedback);
                //telemetry.addData("Camera View", VuforiaLocalizer.CameraDirection.BACK);
            }else if (gamepad1.dpad_up){
                telemetry.addData("BYE BYE", Vuforia);
            }


        }
        }
    }
}
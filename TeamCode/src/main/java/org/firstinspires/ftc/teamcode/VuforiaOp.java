package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by PLAFORET on 2/28/2017.
 */

public class VuforiaOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        VuforiaLocalizer.Parameters params = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        params.vuforiaLicenseKey = "AbUZtgH/////AAAAGXeLnnQrrU5+qrxK0IAwAalZnkNmyO94eGoqcSeXitwa/YkBzM/9YPiM/m1H9mhBrP89G5amGmzbfsDfNu3lVvp97tzix+3H3TMUuODMQj6PdkNciCEDaud+KQR+hQeiupqz6n9s0RMf/MHyefUUGvnF7Ltd1mXFSAqaObvFgWl6DFi0GtLhz5Fa+DZoPrT4n8BkoiGkY4psDR5OEu+yYGbLi9SGB75dlMGhYbQYYE2yiACv0YjZstfQwoxWwKCq/U6ibd2s16wMfBEOVrBVInH6DS4q0TUFQysZ3NRKL8j0mlsbAdVmRMWskeXs4v7GI89T/n0+wmn3o4dxBxgpL+h+6QtJOAFyQlRcCuXkX4o3";
        params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params);
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4);

        VuforiaTrackables beacons = vuforia.loadTrackablesFromAsset("FTC_2016-17");
        beacons.get(0).setName("Wheels");
        beacons.get(1).setName("Tools");
        beacons.get(2).setName("Lego");
        beacons.get(3).setName("Gears");

        waitForStart();

        beacons.activate();

        while (opModeIsActive()){
            for (VuforiaTrackable beac : beacons){
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener) beac.getListener()).getPose();

                if(pose != null){
                    VectorF translation = pose.getTranslation();

                    telemetry.addData(beac.getName() + "-Translation", translation);
                }
            }
        }
    }
}

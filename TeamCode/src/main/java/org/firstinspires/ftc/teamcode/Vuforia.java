package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by ANDRES SALAS
 */

public class Vuforia {
    OpenGLMatrix LastKnownLocation;
    OpenGLMatrix PhoneLocation;
    VuforiaLocalizer Vuforia;
    OpenGLMatrix RobotLocationTransform;
    public static final String TAG = "Vuforia";
    private static final int MAX_TARGETS = 4;
    Hard_CrabBot CrabBot = new Hard_CrabBot();

    public void VuforiaJunk() {
        VuforiaLocalizer.Parameters param = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        VuforiaLocalizer.CameraDirection CamDirec = VuforiaLocalizer.CameraDirection.BACK;
        this.Vuforia = ClassFactory.createVuforiaLocalizer(param);
        param.vuforiaLicenseKey = "AbUZtgH/////AAAAGXeLnnQrrU5+qrxK0IAwAalZnkNmyO94eGoqcSeXitwa/YkBzM/9YPiM/m1H9mhBrP89G5amGmzbfsDfNu3lVvp97tzix+3H3TMUuODMQj6PdkNciCEDaud+KQR+hQeiupqz6n9s0RMf/MHyefUUGvnF7Ltd1mXFSAqaObvFgWl6DFi0GtLhz5Fa+DZoPrT4n8BkoiGkY4psDR5OEu+yYGbLi9SGB75dlMGhYbQYYE2yiACv0YjZstfQwoxWwKCq/U6ibd2s16wMfBEOVrBVInH6DS4q0TUFQysZ3NRKL8j0mlsbAdVmRMWskeXs4v7GI89T/n0+wmn3o4dxBxgpL+h+6QtJOAFyQlRcCuXkX4o3";
        VuforiaTrackables Beacon_Targets = this.Vuforia.loadTrackablesFromAsset("FTC_2016-17");
        VuforiaLocalizer vufroiaLocalizer = ClassFactory.createVuforiaLocalizer(param);
        param.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

    }


}

package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

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


}

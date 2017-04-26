package org.firstinspires.ftc.teamcode;

import android.graphics.Path;
import android.nfc.Tag;

//CREATED BY ANDRES SALAS

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by ANDRES
 */
@Autonomous(name = "Vuforia")
public class Vuforia extends LinearOpMode{
    OpenGLMatrix LastKnownLocation;
    OpenGLMatrix PhoneLocation;
    VuforiaLocalizer Vuforia;
    //Attempt at creating a constructor(?I think thats what they're called) so I could call this when needed
    //static final VuforiaLocalizer.CameraDirection CAMERDIREC = VuforiaLocalizer.CameraDirection.BACK;
    public static final String TAG = "Vuforia";

    @Override
    public void runOpMode() throws InterruptedException{
        //Declaring all necessary info to setup VUFORIA
        VuforiaLocalizer.Parameters param = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        VuforiaLocalizer.CameraDirection CamDirec = VuforiaLocalizer.CameraDirection.BACK;
        this.Vuforia = ClassFactory.createVuforiaLocalizer(param);
        param.vuforiaLicenseKey = "AbUZtgH/////AAAAGXeLnnQrrU5+qrxK0IAwAalZnkNmyO94eGoqcSeXitwa/YkBzM/9YPiM/m1H9mhBrP89G5amGmzbfsDfNu3lVvp97tzix+3H3TMUuODMQj6PdkNciCEDaud+KQR+hQeiupqz6n9s0RMf/MHyefUUGvnF7Ltd1mXFSAqaObvFgWl6DFi0GtLhz5Fa+DZoPrT4n8BkoiGkY4psDR5OEu+yYGbLi9SGB75dlMGhYbQYYE2yiACv0YjZstfQwoxWwKCq/U6ibd2s16wMfBEOVrBVInH6DS4q0TUFQysZ3NRKL8j0mlsbAdVmRMWskeXs4v7GI89T/n0+wmn3o4dxBxgpL+h+6QtJOAFyQlRcCuXkX4o3";
        VuforiaTrackables Beacon_Targets = this.Vuforia.loadTrackablesFromAsset("FTC_2016-17");
        float mmPerInch        = 25.4f;
        float mmBotWidth       = 18 * mmPerInch;
        float mmFTCFieldWidth  = (12*12 - 2) * mmPerInch;
        VuforiaTrackable Wheels = Beacon_Targets.get(0);
        Wheels.setName("Wheels");
        VuforiaTrackable Legos = Beacon_Targets.get(2);
        Legos.setName("Legos");
        //SHOULD Track the "Wheels Target, and display the information in a human readable format
        //thanks to the public string format located at the bottom of the code
        OpenGLMatrix WheelsTargetOnField = OpenGLMatrix.translation(-mmFTCFieldWidth/2,0,0).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, 90,90,0));
        Wheels.setLocation(WheelsTargetOnField);
        RobotLog.ii(TAG, "RedTarget = $s", Format(WheelsTargetOnField));

        final int PHONE_FROM_CENTER = 85;
        final int PHONE_FROM_GROUND = 85;
        final int PHONE_OFF_FROM_CENTER = 0;


        OpenGLMatrix phoneLocationOnRobot = OpenGLMatrix.translation(PHONE_FROM_CENTER, PHONE_FROM_GROUND, PHONE_OFF_FROM_CENTER).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, 0, 0, 0));
        RobotLog.ii(TAG, "phone=%s", Format(phoneLocationOnRobot));
        //Failed Attempt, didn't work due to some unresolved issue
        //OpenGLMatrix PhoneLocationOnRobot = OpenGLMatrix.translation(PHONE_FROM_CENTER, PHONE_FROM_GROUND, PHONE_OFF_FROM_CENTER).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC,AxesOrder.XYZ, AngleUnit.DEGREES, ));

    }
    public String Format(OpenGLMatrix Format){
        return Format.formatAsTransform();
    }
}

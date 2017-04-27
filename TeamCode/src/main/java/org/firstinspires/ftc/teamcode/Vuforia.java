package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.RobotLog;
import com.vuforia.HINT;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

//CREATED BY ANDRES SALAS

/**
 * Created by ANDRES SALAS
 */
@Autonomous(name = "Vuforia", group = "Image Recognition Software")
public class Vuforia extends LinearOpMode{
    OpenGLMatrix LastKnownLocation;
    OpenGLMatrix PhoneLocation;
    VuforiaLocalizer Vuforia;
    OpenGLMatrix RobotLocationTransform;
    //Attempt at creating a constructor(?I think thats what they're called) so I could call this when needed
    //static final VuforiaLocalizer.CameraDirection CAMERDIREC = VuforiaLocalizer.CameraDirection.BACK;
    public static final String TAG = "Vuforia";


    @Override
    public void runOpMode() throws InterruptedException{
        waitForStart();
        //Setting Info for the motors on the robot
        DcMotor FrontLeft = null;
        DcMotor FrontRight = null;
        DcMotor BackLeft = null;
        DcMotor BackRight = null;
        DcMotor Center = null;
        DcMotor BeaconPusher = null;

        FrontLeft = hardwareMap.dcMotor.get("FrontLeft0");
        FrontRight = hardwareMap.dcMotor.get("FrontRight");
        BackLeft = hardwareMap.dcMotor.get("BackLeft");
        BackRight = hardwareMap.dcMotor.get("BackRight");
        Center = hardwareMap.dcMotor.get("Center");
        BeaconPusher = hardwareMap.dcMotor.get("BeaconPusher");

        FrontRight.setDirection(DcMotorSimple.Direction.REVERSE);
        BackRight.setDirection(DcMotorSimple.Direction.REVERSE);



        //Declaring all necessary info to setup VUFORIA
        VuforiaLocalizer.Parameters param = new VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        VuforiaLocalizer.CameraDirection CamDirec = VuforiaLocalizer.CameraDirection.BACK;
        this.Vuforia = ClassFactory.createVuforiaLocalizer(param);
        param.vuforiaLicenseKey = "AbUZtgH/////AAAAGXeLnnQrrU5+qrxK0IAwAalZnkNmyO94eGoqcSeXitwa/YkBzM/9YPiM/m1H9mhBrP89G5amGmzbfsDfNu3lVvp97tzix+3H3TMUuODMQj6PdkNciCEDaud+KQR+hQeiupqz6n9s0RMf/MHyefUUGvnF7Ltd1mXFSAqaObvFgWl6DFi0GtLhz5Fa+DZoPrT4n8BkoiGkY4psDR5OEu+yYGbLi9SGB75dlMGhYbQYYE2yiACv0YjZstfQwoxWwKCq/U6ibd2s16wMfBEOVrBVInH6DS4q0TUFQysZ3NRKL8j0mlsbAdVmRMWskeXs4v7GI89T/n0+wmn3o4dxBxgpL+h+6QtJOAFyQlRcCuXkX4o3";
        VuforiaTrackables Beacon_Targets = this.Vuforia.loadTrackablesFromAsset("FTC_2016-17");
        VuforiaLocalizer vufroiaLocalizer = ClassFactory.createVuforiaLocalizer(param);
        param.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        VuforiaTrackableDefaultListener Wheels = (VuforiaTrackableDefaultListener) Beacon_Targets.get(0).getListener();
        VuforiaTrackableDefaultListener Legos = (VuforiaTrackableDefaultListener) Beacon_Targets.get(2).getListener();
/*
        //Load the targets from the asset folder
        VuforiaTrackable Wheels = Beacon_Targets.get(0);
        Wheels.setName("Wheels");
        VuforiaTrackable Legos = Beacon_Targets.get(2);
        Legos.setName("Legos");

        ((VuforiaTrackableDefaultListener)Wheels.getListener()).setPhoneInformation(PhoneLocation, param.cameraDirection);
        ((VuforiaTrackableDefaultListener)Legos.getListener()).setPhoneInformation(PhoneLocation, param.cameraDirection);


        float mmPerInch        = 25.4f;
        float mmBotWidth       = 18 * mmPerInch;
        float mmFTCFieldWidth  = (12*12 - 2) * mmPerInch;
        //SHOULD Track the "Wheels Target, and display the information in a human readable format
        // /thanks to the public string format located at the bottom of the code
        OpenGLMatrix WheelsTargetOnField = OpenGLMatrix.translation(-mmFTCFieldWidth/2,0,0).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, 0,0,0));
        Wheels.setLocation(WheelsTargetOnField);
        RobotLog.ii(TAG, "Wheels = $s", Format(WheelsTargetOnField));
        OpenGLMatrix LegosLocationOnField = OpenGLMatrix.translation(-mmFTCFieldWidth/2,0,0).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, 0,0,0));
        Legos.setLocation(LegosLocationOnField);
        RobotLog.ii(TAG, "Legos = $s", Format(LegosLocationOnField));
        param.useExtendedTracking = false;
*/
        final float PHONE_FROM_CENTER_OF_ROBOT = 85;
        final float PHONE_FROM_GROUND = 85;
        final float PHONE_OFF_FROM_CENTERLINE_OF_ROBOT = 0;



        OpenGLMatrix phoneLocationOnRobot = OpenGLMatrix.translation(PHONE_FROM_CENTER_OF_ROBOT, PHONE_FROM_GROUND, PHONE_OFF_FROM_CENTERLINE_OF_ROBOT).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES, 0, 0, 0));
        RobotLog.ii(TAG, "phone=%s", Format(phoneLocationOnRobot));
        //Failed Attempt, didn't work due to some unresolved issue
        //OpenGLMatrix PhoneLocationOnRobot = OpenGLMatrix.translation(PHONE_FROM_CENTER, PHONE_FROM_GROUND, PHONE_OFF_FROM_CENTER).multiplied(Orientation.getRotationMatrix(AxesReference.EXTRINSIC,AxesOrder.XYZ, AngleUnit.DEGREES, ));
        //Activate data necessary to identify targets
        //int X = 0;
        Beacon_Targets.activate();
/*
        FrontLeft.setPower(.25);
        FrontRight.setPower(.25);
        BackLeft.setPower(.25);
        BackRight.setPower(.25);
*/
        Center.setPower(.5);
        telemetry.addData("Press Start To Begin", "><");
        telemetry.update();

        while (opModeIsActive() && Wheels.getRawPose() == null){
            idle();
        }
        Center.setPower(0);


/*
        while (opModeIsActive()){
            idle();
            for (VuforiaTrackable Targets : Beacon_Targets) {
                OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) Targets.getListener()).getUpdatedRobotLocation();
                if (robotLocationTransform != null) {
                    LastKnownLocation = robotLocationTransform;
                }


            }
            //Provides Feedback over robots Location
            if (LastKnownLocation != null){
                RobotLog.vv(TAG, "robot=%s", Format(LastKnownLocation));
                telemetry.addData("Position=", Format(LastKnownLocation));
                telemetry.update();
            }else {
                telemetry.addData("Position=", "Unknown");
                telemetry.update();
            }
*/



        }

    public String Format(OpenGLMatrix Format){
        return Format.formatAsTransform();
    }
}

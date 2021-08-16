package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

@Autonomous(name = "RetoFinal")
public class RETOFINAL1<lateinit> extends LinearOpMode {
    DcMotor ruedaIzquierda;
    DcMotor ruedaDerecha;
    Servo brazo;

    VuforiaLocalizer vuforiaLocalizer;
    VuforiaLocalizer.Parameters parameters;
    VuforiaTrackables visionTargets;
    VuforiaTrackable target;
    VuforiaTrackableDefaultListener listener;

    OpenGLMatrix lastKnownLocation;
    OpenGLMatrix phoneLocation;
    public static final String VUFORIA_KEY = "";

    @Override
    public void runOpMode() {

        ruedaIzquierda = hardwareMap.dcMotor.get("MotorI");
        ruedaDerecha = hardwareMap.dcMotor.get("MotorD");
        brazo = hardwareMap.servo.get("servo1");


        ruedaIzquierda.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        ruedaDerecha.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();
    }

    public void VuforiaSetUp() {

        parameters = new VuforiaLocalizer.Parameters();
        parameters.vuforiaLicenseKey = VUFORIA_KEY;
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        vuforiaLocalizer = ClassFactory.createVuforiaLocalizer(parameters);

visionTargets = vuforiaLocalizer.loadTrackablesFromAsset("VuMark");

        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

    }

    public void DriveForward(double power) {
        //Reset Encoders
        ruedaDerecha.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ruedaIzquierda.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        //Set Target Position
        ruedaDerecha.setTargetPosition(5000);
        ruedaIzquierda.setTargetPosition(5000);

        //Run To Position
        ruedaDerecha.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ruedaIzquierda.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForward(power);

        ruedaDerecha.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ruedaIzquierda.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void Servo() {

        brazo.setPosition(1);

        sleep(1000);

        brazo.setPosition(0);

    }

    public void GoToRedBox(double power) {

        ruedaIzquierda.setPower(.5);
        ruedaDerecha.setPower(-.5);

        sleep(5000);

        ruedaIzquierda.setPower(0);
        ruedaDerecha.setPower(0);

        ruedaIzquierda.setTargetPosition(3000);
        ruedaDerecha.setTargetPosition(3000);

        ruedaDerecha.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        ruedaIzquierda.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        DriveForward(power);

        ruedaDerecha.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        ruedaIzquierda.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


    }




        }






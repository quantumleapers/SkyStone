package org.firstinspires.ftc.teamcode;

import android.util.Log;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Robot  extends java.lang.Thread {

    public DcMotor Motor_FL;
    public DcMotor Motor_FR;
    public DcMotor Motor_BR;
    public DcMotor Motor_BL;
    public HardwareMap hardwareMap;
    public Telemetry telemetry;
    public int movementFactor = 20;
    public boolean isTeleOp = true;
    public DcMotor Slide_R;
    public DcMotor Slide_L;
    public CRServo pincher;


    Robot(HardwareMap map, Telemetry tel) {
        hardwareMap = map;
        telemetry = tel;
        initDevices();
    }

    public void pause(int milliSec) {
        try {
            sleep(milliSec);
        } catch (Exception e) {
        }
    }


    public void moveB(long distance) {
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        Motor_FL.setPower(0.8);
        Motor_FR.setPower(-0.8);
        Motor_BR.setPower(0.8);
        Motor_BL.setPower(-0.8);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Backward");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }

    public void moveF(long distance) {
        Motor_FL.setPower(-0.8); //FL
        Motor_FR.setPower(0.8); //FR
        Motor_BR.setPower(-0.8); //BR
        Motor_BL.setPower(0.8); //BL
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "FORWARD");
        telemetry.update();
        if (isTeleOp == false) pause(250);

    }

    public void moveL(long distance) {
        double power = 0.8;

        Motor_FL.setPower(power );
        Motor_FR.setPower(power);
        Motor_BR.setPower((-1) * power);
        Motor_BL.setPower((-1) * power);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Left");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }

    public void moveR(long distance) {
        double power = 0.8;

        Motor_FL.setPower((-1) * power);
        Motor_FR.setPower((-1) * power);
        Motor_BR.setPower(power );
        Motor_BL.setPower(power);

        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Right");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }

    private void initDeviceCore() throws Exception {

        telemetry.addData("Please wait", "In function init devices");
        telemetry.update();

        //Wheels
        Motor_FL = hardwareMap.get(DcMotor.class, "Motor_FL");
        Motor_FR = hardwareMap.get(DcMotor.class, "Motor_FR");
        Motor_BR = hardwareMap.get(DcMotor.class, "Motor_BR");
        Motor_BL = hardwareMap.get(DcMotor.class, "Motor_BL");

     //   Slide_R = hardwareMap.get(DcMotor.class, "slide_r");
       // Slide_L = hardwareMap.get(DcMotor.class, "slide_l");

       // pincher = hardwareMap.get(CRServo.class, "pincher");

        telemetry.addData("Status", "Initialized");
        telemetry.update();


    }


    private void initDevices() {
        ElapsedTime mRuntime = new ElapsedTime();
        mRuntime.reset();

        try {
            initDeviceCore();
        } catch (Exception e) {
            telemetry.addData("Exception", "In function init devices" + e);
            telemetry.update();
            try {
                sleep(10000);
            } catch (Exception e1) {
            }

        }

    }


}

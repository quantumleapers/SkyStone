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
    public boolean isTeleOp = true;
    public DcMotor Slide_R;
    public DcMotor Slide_L;
    public CRServo phook;
    public int EncoderTicks = 1440;
    public int WheelDiameter = 98;
    public float Pi = (float) 3.14;
    public float movementFactor = (WheelDiameter*Pi/EncoderTicks);


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
        Motor_FL.setPower(0.6);
        Motor_FR.setPower(-0.6);
        Motor_BR.setPower(0.6);
        Motor_BL.setPower(-0.6);
        try {
            //sleep(distance * movementFactor);
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
        int TargetTicks_FL = (int) (distance/movementFactor);
        int TargetTicks_BL = (int) (distance/movementFactor);
        int TargetTicks_FR = (int) (distance/movementFactor);
        int TargetTicks_BR = (int) (distance/movementFactor);
        Motor_FL.setPower(-0.6); //FL
        Motor_FR.setPower(0.6); //FR
        Motor_BR.setPower(-0.6); //BR
        Motor_BL.setPower(0.6); //BL
        try {
            //sleep(distance * movementFactor);
            Motor_FL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            Motor_BL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            Motor_FR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            Motor_BR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            Motor_FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Motor_BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Motor_FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            Motor_BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            Motor_FL.setTargetPosition(TargetTicks_FL);
            Motor_BL.setTargetPosition(TargetTicks_BL);
            Motor_BR.setTargetPosition(TargetTicks_BR);
            Motor_FR.setTargetPosition(TargetTicks_FR);

            while(Motor_BL.isBusy() || Motor_FL.isBusy() || Motor_BR.isBusy() || Motor_FR.isBusy() && isTeleOp == false){

            }
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
        double power = 1;

        Motor_FL.setPower(power );
        Motor_FR.setPower(power);
        Motor_BR.setPower((-1) * power);
        Motor_BL.setPower((-1) * power);
        try {
            //sleep(distance * movementFactor);
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
        double power = 1;

        Motor_FL.setPower((-1) * power);
        Motor_FR.setPower((-1) * power);
        Motor_BR.setPower(power );
        Motor_BL.setPower(power);

        try {
            //sleep(distance * movementFactor);
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

    /*public void moveHook90r(long distance) {
        double power = -1;

        phook.setPower(power);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        phook.setPower(0);
        telemetry.addData("Direction", "Up");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }

    public void moveHook90(long distance) {
        double power = 1;

        phook.setPower(power);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        phook.setPower(0);
        telemetry.addData("Direction", "Down");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }
*/
    private void initDeviceCore() throws Exception {

        telemetry.addData("Please wait", "In function init devices");
        telemetry.update();

        //Wheels
        Motor_FL = hardwareMap.get(DcMotor.class, "Motor_FL");
        Motor_FR = hardwareMap.get(DcMotor.class, "Motor_FR");
        Motor_BL = hardwareMap.get(DcMotor.class, "Motor_BL");
        Motor_BR = hardwareMap.get(DcMotor.class, "Motor_BR");
        //phook = hardwareMap.get(CRServo.class, "phook");

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

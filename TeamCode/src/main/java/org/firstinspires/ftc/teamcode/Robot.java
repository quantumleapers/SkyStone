package org.firstinspires.ftc.teamcode;

import android.util.Log;
import android.graphics.Color;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class Robot extends java.lang.Thread {

    public DcMotor Motor_FL;
    public DcMotor Motor_FR;
    public DcMotor Motor_BR;
    public DcMotor Motor_BL;
    public DcMotor Motor_REX;
    public DcMotor BR_Hook;
    public DcMotor BL_Hook;
    public DcMotor p_slide;

    public HardwareMap hardwareMap;
    public Telemetry telemetry;
    public boolean isTeleOp = false;
    public DcMotor Slide_R;
    public DcMotor Slide_L;
    public Servo phookLeft;
    public Servo flap;
    public Servo capPick;
    public Servo phookRight;
    public int EncoderTicks = 1440;
    public float WheelDiameter = (float)3.86;
   public float Pi = (float)3.14159265358979323;
    //public double movementFactor1 = .0084169444;
    public float movementFactor1 = (float)(WheelDiameter*Pi/EncoderTicks);
    public  long movementFactor = 20;

    DigitalChannel digitalTouch;
    NormalizedColorSensor ncolorSensor;
    ColorSensor colorSensor;

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

    public void moveRevMotor(long distance) {
        telemetry.addData("Direction", "Backword");
        telemetry.update();
        Motor_REX.setPower(0.4);

        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }

        telemetry.addData("Direction", "Rev motor right trigger");
        telemetry.update();
        if (isTeleOp == false) pause(250);
    }

    public void setTeleOp( boolean isTeleOp) {
        this.isTeleOp = isTeleOp;
        flap.resetDeviceConfigurationForOpMode();
      //  flap.setPosition(1.0);
    }

    public void rotateClockWise(long degree, double power) {
        telemetry.addData("Direction", "Clockwise");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(power);
        long rotationFactor = 24;
        try {
            sleep(degree * rotationFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "ClockWise");
        telemetry.update();
        if (isTeleOp == true) pause(250);
    }

    public void rotateAntiClockWise(long degree, double power) {
        telemetry.addData("Direction", "AntiClockwise");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(-1 * power);
        long rotationFactor = 7;
        try {
            sleep(degree * rotationFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Anti ClockWise");
        telemetry.update();
        if (isTeleOp == true) pause(250);
    }


    public void moveB(long distance, double power) {
        telemetry.addData("Direction", "Backword");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(-1 * power);
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
        //if (isTeleOp == true) pause(250);
    }

    public void moveB(double power) {
        telemetry.addData("Direction", "Backword");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(-1 * power);
        telemetry.addData("Direction", "Backward");
        telemetry.update();

    }

    public void moveBForFoundation(long distance, double power) {
        telemetry.addData("Direction", "Backword");
        telemetry.update();
        Motor_FL.setPower(0.9);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(0.9);
        Motor_BL.setPower(-1 * power);
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
        if (isTeleOp == true) pause(250);
    }

    public void moveBForRedFoundation(long distance, double power) {
        telemetry.addData("Direction", "Backword");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(-1 * 0.9);
        Motor_BR.setPower(power);
        Motor_BL.setPower(-1 * 0.9);
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
        if (isTeleOp == true) pause(250);
    }

    public void moveFForRedFoundation(long distance, double power) {
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(0.9);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(0.9);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        //if (isTeleOp == true) pause(250);
    }

    public void moveF(long distance, double power) {
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(power);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(power);
        try {
            sleep(distance * movementFactor);
        } catch (Exception e) {
        }
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        //if (isTeleOp == true) pause(250);
    }

    public void moveF(double power) {
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(power);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(power);
        telemetry.addData("Direction", "Forward");
        telemetry.update();

    }

    public void moveForwardUntilTouch() {
        telemetry.addData("Direction with Touch", "Forward");
        telemetry.update();
        //Initialize the digital touch to false.
        digitalTouch.setState(false);

        while (digitalTouch.getState()) {
            moveForward(2, 0.9);
        }

        telemetry.addData("Digital sensor touched the wall", digitalTouch.getState());
        telemetry.update();
    }

    public boolean getTouchSensorState() {
        return digitalTouch.getState();
    }

    public void moveForward(long distance, double power) {
        int TargetTicks_FL = (int) (distance/movementFactor1);
        int TargetTicks_BL = (int) (distance/movementFactor1);
        int TargetTicks_FR = (int) (distance/movementFactor1);
        int TargetTicks_BR = (int) (distance/movementFactor1);

        telemetry.addData("FL target position", TargetTicks_FL);
        telemetry.addData("BL target position", TargetTicks_BL);
        telemetry.addData("FR target position", TargetTicks_FR);
        telemetry.addData("BR target position", TargetTicks_BR);

       // Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
       // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
       // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
       // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        try {
           // sleep(distance * movementFactor);
            Motor_FL.setDirection(DcMotor.Direction.REVERSE);
            Motor_BL.setDirection(DcMotor.Direction.FORWARD);
            Motor_FR.setDirection(DcMotor.Direction.FORWARD);
            Motor_BR.setDirection(DcMotor.Direction.REVERSE);

            Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


            Motor_FL.setPower(Math.abs(power)); //FL
            Motor_FR.setPower(Math.abs(power)); //FR
            Motor_BR.setPower(Math.abs(power)); //BR
            Motor_BL.setPower(Math.abs(power)); //BL

            telemetry.addData("FL target position after run", Motor_FL.getCurrentPosition());
            telemetry.addData("BL target position after run", Motor_BL.getCurrentPosition());
            telemetry.addData("FR target position after run", Motor_FR.getCurrentPosition());
            telemetry.addData("BR target position after run", Motor_BR.getCurrentPosition());
            /*
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {

            }*/

            while(Motor_BL.isBusy() && Motor_FL.isBusy() && Motor_BR.isBusy() && Motor_FR.isBusy()){
            //while(Motor_BL.isBusy()) {
                telemetry.addData("encoder-fwd", Motor_FL.getCurrentPosition() + "  busy=" + Motor_FL.isBusy());
                telemetry.update();
            }

            //}
        } catch (Exception e) {
        }

       // try {
       //     sleep(10000);
       // } catch (Exception e) {
       // }
        //Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
       // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("FL target position after run completion", Motor_FL.getCurrentPosition());
        telemetry.addData("BL target position after run completion", Motor_BL.getCurrentPosition());
        telemetry.addData("FR target position after run completion", Motor_FR.getCurrentPosition());
        telemetry.addData("BR target position after run completion", Motor_BR.getCurrentPosition());

        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);

        telemetry.addData("Direction", "FORWARD encoded");
        telemetry.update();
       // if (isTeleOp == false) pause(250);

    }

    public void moveBackward(long distance, double power) {
        int TargetTicks_FL = (int) (distance/movementFactor1);
        int TargetTicks_BL = (int) (distance/movementFactor1);
        int TargetTicks_FR = (int) (distance/movementFactor1);
        int TargetTicks_BR = (int) (distance/movementFactor1);

        telemetry.addData("FL target position", TargetTicks_FL);
        telemetry.addData("BL target position", TargetTicks_BL);
        telemetry.addData("FR target position", TargetTicks_FR);
        telemetry.addData("BR target position", TargetTicks_BR);

        // Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        try {
            // sleep(distance * movementFactor);
            Motor_FL.setDirection(DcMotor.Direction.FORWARD);
            Motor_BL.setDirection(DcMotor.Direction.REVERSE);
            Motor_FR.setDirection(DcMotor.Direction.REVERSE);
            Motor_BR.setDirection(DcMotor.Direction.FORWARD);

            Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


            Motor_FL.setPower(Math.abs(power)); //FL
            Motor_FR.setPower(Math.abs(power)); //FR
            Motor_BR.setPower(Math.abs(power)); //BR
            Motor_BL.setPower(Math.abs(power)); //BL

            telemetry.addData("FL target position after run", Motor_FL.getCurrentPosition());
            telemetry.addData("BL target position after run", Motor_BL.getCurrentPosition());
            telemetry.addData("FR target position after run", Motor_FR.getCurrentPosition());
            telemetry.addData("BR target position after run", Motor_BR.getCurrentPosition());
/*
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {

            }

 */
          while(Motor_BL.isBusy() && Motor_FL.isBusy() && Motor_BR.isBusy() && Motor_FR.isBusy()){
          //  while(Motor_FL.isBusy()){
                telemetry.addData("encoder-fwd", Motor_FL.getCurrentPosition() + "  busy=" + Motor_FL.isBusy());
                telemetry.update();

            }
        } catch (Exception e) {
        }

        // try {
        //     sleep(10000);
        // } catch (Exception e) {
        // }
        //Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("FL target position after run completion", Motor_FL.getCurrentPosition());
        telemetry.addData("BL target position after run completion", Motor_BL.getCurrentPosition());
        telemetry.addData("FR target position after run completion", Motor_FR.getCurrentPosition());
        telemetry.addData("BR target position after run completion", Motor_BR.getCurrentPosition());

        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);

        telemetry.addData("Direction", "Backword encoded");
        telemetry.update();
        // if (isTeleOp == false) pause(250);

    }

    public void moveLeft(long distance, double power) {
        int TargetTicks_FL = (int) (distance/movementFactor1);
        int TargetTicks_BL = (int) (distance/movementFactor1);
        int TargetTicks_FR = (int) (distance/movementFactor1);
        int TargetTicks_BR = (int) (distance/movementFactor1);

        telemetry.addData("FL target position", TargetTicks_FL);
        telemetry.addData("BL target position", TargetTicks_BL);
        telemetry.addData("FR target position", TargetTicks_FR);
        telemetry.addData("BR target position", TargetTicks_BR);

        // Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        try {
            // sleep(distance * movementFactor);
            Motor_FL.setDirection(DcMotor.Direction.FORWARD);
            Motor_BL.setDirection(DcMotor.Direction.REVERSE);
            Motor_FR.setDirection(DcMotor.Direction.FORWARD);
            Motor_BR.setDirection(DcMotor.Direction.REVERSE);

            Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


            Motor_FL.setPower(Math.abs(power)); //FL
            Motor_FR.setPower(Math.abs(power)); //FR
            Motor_BR.setPower(Math.abs(power)); //BR
            Motor_BL.setPower(Math.abs(power)); //BL

            telemetry.addData("FL target position after run", Motor_FL.getCurrentPosition());
            telemetry.addData("BL target position after run", Motor_BL.getCurrentPosition());
            telemetry.addData("FR target position after run", Motor_FR.getCurrentPosition());
            telemetry.addData("BR target position after run", Motor_BR.getCurrentPosition());
            /*
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {

            }*/

            while(Motor_BL.isBusy() && Motor_FL.isBusy() && Motor_BR.isBusy() && Motor_FR.isBusy()){
           // while(Motor_BL.isBusy()) {
                telemetry.addData("encoder-fwd", Motor_FL.getCurrentPosition() + "  busy=" + Motor_FL.isBusy());
                telemetry.update();
            }

           // }
        } catch (Exception e) {
        }

        // try {
        //     sleep(10000);
        // } catch (Exception e) {
        // }
        //Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("FL target position after run completion", Motor_FL.getCurrentPosition());
        telemetry.addData("BL target position after run completion", Motor_BL.getCurrentPosition());
        telemetry.addData("FR target position after run completion", Motor_FR.getCurrentPosition());
        telemetry.addData("BR target position after run completion", Motor_BR.getCurrentPosition());

        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);

        telemetry.addData("Direction", "LEFT Encoded ");
        telemetry.update();
        // if (isTeleOp == false) pause(250);

    }

    public void moveRight(long distance, double power) {
        int TargetTicks_FL = (int) (distance/movementFactor1);
        int TargetTicks_BL = (int) (distance/movementFactor1);
        int TargetTicks_FR = (int) (distance/movementFactor1);
        int TargetTicks_BR = (int) (distance/movementFactor1);

        telemetry.addData("FL target position", TargetTicks_FL);
        telemetry.addData("BL target position", TargetTicks_BL);
        telemetry.addData("FR target position", TargetTicks_FR);
        telemetry.addData("BR target position", TargetTicks_BR);

        // Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);


        try {
            // sleep(distance * movementFactor);
            Motor_FL.setDirection(DcMotor.Direction.REVERSE);
            Motor_BL.setDirection(DcMotor.Direction.FORWARD);
            Motor_FR.setDirection(DcMotor.Direction.REVERSE);
            Motor_BR.setDirection(DcMotor.Direction.FORWARD);

            Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

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


            Motor_FL.setPower(Math.abs(power)); //FL
            Motor_FR.setPower(Math.abs(power)); //FR
            Motor_BR.setPower(Math.abs(power)); //BR
            Motor_BL.setPower(Math.abs(power)); //BL

            telemetry.addData("FL target position after run", Motor_FL.getCurrentPosition());
            telemetry.addData("BL target position after run", Motor_BL.getCurrentPosition());
            telemetry.addData("FR target position after run", Motor_FR.getCurrentPosition());
            telemetry.addData("BR target position after run", Motor_BR.getCurrentPosition());

            while(Motor_BL.isBusy() && Motor_FL.isBusy() && Motor_BR.isBusy() && Motor_FR.isBusy()){
           // while(Motor_BL.isBusy()){
                telemetry.addData("encoder-fwd", Motor_FL.getCurrentPosition() + "  busy=" + Motor_FL.isBusy());
                telemetry.update();

            }
        } catch (Exception e) {
        }

        // try {
        //     sleep(10000);
        // } catch (Exception e) {
        // }
        //Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        // Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        telemetry.addData("FL target position after run completion", Motor_FL.getCurrentPosition());
        telemetry.addData("BL target position after run completion", Motor_BL.getCurrentPosition());
        telemetry.addData("FR target position after run completion", Motor_FR.getCurrentPosition());
        telemetry.addData("BR target position after run completion", Motor_BR.getCurrentPosition());

        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);

        telemetry.addData("Direction", "RIGHT Encoded");
        telemetry.update();
        // if (isTeleOp == false) pause(250);

    }

    public void moveL(long distance, double power) {

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
        //if (isTeleOp == true) pause(250);
    }

    public void moveL(double power) {

        Motor_FL.setPower(power );
        Motor_FR.setPower(power);
        Motor_BR.setPower((-1) * power);
        Motor_BL.setPower((-1) * power);

        telemetry.addData("Direction", "Left");
        telemetry.update();

    }

    public void moveR(long distance, double power) {

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
       // if (isTeleOp == true) pause(250);
    }

    public void moveR(double power) {
        Motor_FL.setPower((-1) * power);
        Motor_FR.setPower((-1) * power);
        Motor_BR.setPower(power );
        Motor_BL.setPower(power);
        telemetry.addData("Direction", "Right");
        telemetry.update();
    }

    public void stopRobot() {
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
        Motor_BR.setPower(0);
        Motor_BL.setPower(0);
        telemetry.addData("Robot", "Stop");
        telemetry.update();
    }

    public void moveRightHookToLatch() {

        phookRight.setPosition(0.97);
        telemetry.addData("left hook position ", phookRight.getPosition());
        telemetry.update();
    }



    public void moveRightHookToRelease() {
        while (phookRight.getPosition() != 0.50) {
            phookRight.setPosition(0.50);
            telemetry.addData("servo moder ", "resetting");
            telemetry.update();
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {

            }
        }
    }

    public void moveRightHook90r() {
        //double power = -1;

        // phook.setPosition(0);
        phookRight.setPosition(0.97);
        telemetry.addData("left hook position ", phookRight.getPosition());
        telemetry.update();

        try {
            Thread.sleep(2500);
        } catch (Exception ex) {

        }

        telemetry.addData("servo moder ", "90 degree test");
        telemetry.update();

    }

    public void engageFlap() {
        //double power = -1;

        // phook.setPosition(0);
        flap.setPosition(-0.97);
        telemetry.addData("position ", flap.getPosition());
        telemetry.update();

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        telemetry.addData("servo moder ", "flap engageFlap");
        telemetry.update();
    }
    public void disengageFlap() {
        //double power = -1;

        // phook.setPosition(0);
        flap.setPosition(0.97);
        telemetry.addData("position ", flap.getPosition());
        telemetry.update();

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        telemetry.addData("servo moder ", "flap disengageFlap");
        telemetry.update();
    }
    

    public void resetCapstone() {
        //double power = -1;

        // phook.setPosition(0);

        capPick.setPosition(0.92);
        telemetry.addData("position ", capPick.getPosition());
        telemetry.update();

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        telemetry.addData("servo moder ", "reset capPick");
        telemetry.update();
    }

    public void engageCapstone() {
        //double power = -1;

        // phook.setPosition(0);

        capPick.setPosition(0.80);
        telemetry.addData("position ", capPick.getPosition());
        telemetry.update();

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        telemetry.addData("servo moder ", "capPick engageCapstone");
        telemetry.update();
    }

    public void disengageCapstone() {
        //double power = -1;

        // phook.setPosition(0);
        capPick.setPosition(0.3);
        telemetry.addData("position ", capPick.getPosition());
        telemetry.update();

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        telemetry.addData("servo moder ", "capPick disengageCapstone");
        telemetry.update();
    }

   public void resetDcMotorsToUseNonEncode()
    {
        Motor_FL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Motor_BL.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Motor_FR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        Motor_BR.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
    public void engageSlider(int ticks) {

        telemetry.addData( "Move slider", p_slide.getCurrentPosition());
        telemetry.update();
        long currentPos =0;
        try {
            // sleep(distance * movementFactor);

            if (ticks <-2500 || ticks >2500) {
                return;
            }
            currentPos =p_slide.getCurrentPosition();
            if ((ticks + currentPos > 2500) || (ticks + currentPos < -2500))
            return;


            p_slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            p_slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            p_slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            p_slide.setTargetPosition(ticks);
            p_slide.setPower(1); //FL



            telemetry.addData("slider target position after run", p_slide.getCurrentPosition());
            telemetry.update();


            while(p_slide.isBusy()) {

            }
        } catch (Exception e) {
        }

        p_slide.setPower(0);
        telemetry.addData("slider engaged", p_slide.getCurrentPosition());
        telemetry.update();
    }

    public void engageHooks (int ticks) {

        telemetry.addData( "Back right hook", BR_Hook.getCurrentPosition());
        telemetry.update();



        try {
            // sleep(distance * movementFactor);
            BR_Hook.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BR_Hook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BR_Hook.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BR_Hook.setTargetPosition(ticks);
            BR_Hook.setPower(1); //FL

            BL_Hook.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            BL_Hook.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            BL_Hook.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            BL_Hook.setTargetPosition(ticks);
            BL_Hook.setPower(1); //FL

            telemetry.addData("Back right hook target position after run", BR_Hook.getCurrentPosition());
            telemetry.addData("Back left hook target position after run", BL_Hook.getCurrentPosition());
            telemetry.update();


            while(BL_Hook.isBusy() || BR_Hook.isBusy()){


            }
        } catch (Exception e) {
        }


        BL_Hook.setPower(0);
        BR_Hook.setPower(0);
        telemetry.addData("Back hooks engaged", BL_Hook.getPower());
        telemetry.update();

    }

    public void moveDown() {

    }

    public void moveLeftHookToLatch() {
        //double power = -1;
        phookLeft.setPosition(0.97);
        telemetry.addData("left hook position ", phookLeft.getPosition());
        telemetry.update();

        // sleep for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (Exception ex) {

        }
    }

    public void moveLeftHookToRelease() {
        while (phookLeft.getPosition() != 0.50) {
            phookLeft.setPosition(0.50);
            telemetry.addData("servo moder ", "resetting");
            telemetry.update();
            try {
                Thread.sleep(1500);
            } catch (Exception ex) {

            }
        }
    }

    public boolean detectNewSkyStone() throws InterruptedException {


        telemetry.addData("Detected red", colorSensor.red());
        telemetry.addData("Detected alpha", colorSensor.alpha());
        telemetry.addData("Detected blue", colorSensor.blue());
        telemetry.addData("Detected green", colorSensor.green());
        telemetry.update();

        if (colorSensor.red() >= 10 && colorSensor.red() <= 18) {
            return true;
        }
        return false;

    }

    public boolean detectSkyStone() throws InterruptedException {

        NormalizedRGBA colors = ncolorSensor.getNormalizedColors();
        sleep(100);
        telemetry.addData("Detected color", colors.toColor());

        telemetry.update();
        sleep(2000);

        // Try this first(if)
        if (colors.toColor() == Color.BLACK) {
            telemetry.addData("SkyStone", "true");
            return true;
        }
        // If above does not work, use HSS values(else)
        float[] hssValues = new float[3];
        Color.colorToHSV(colors.toColor(), hssValues);
        telemetry.addData("SkyStone using HSS value",hssValues[0]);
        telemetry.addData("SkyStone using HSS value",hssValues[1]);
        telemetry.addData("SkyStone using HSS value",hssValues[2]);


        if (hssValues[0] < 40 ) {
            telemetry.addData("SkyStone using HSS value", "true");
            return true;
        }
        telemetry.update();



        return false;
    }

    public void enableLight() {

        telemetry.addData("Enable light", "enable light");
        //telemetry.update();
        if (ncolorSensor instanceof SwitchableLight) {
            telemetry.addData("Switchable light", "true");
            //telemetry.update();
            SwitchableLight light = (SwitchableLight)colorSensor;
            light.enableLight(true);
        }
       // ncolorSensor.resetDeviceConfigurationForOpMode();
    }

    public void disableLight() {
        if (ncolorSensor instanceof SwitchableLight) {
            SwitchableLight light = (SwitchableLight)colorSensor;
            light.enableLight(false);
        }
       // ncolorSensor.resetDeviceConfigurationForOpMode();
    }
/*
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
        BR_Hook  = hardwareMap.get(DcMotor.class, "BR_Hook");
        BR_Hook.setDirection(DcMotorSimple.Direction.REVERSE);

        BL_Hook = hardwareMap.get(DcMotor.class, "BL_Hook");
        BL_Hook.setDirection(DcMotorSimple.Direction.FORWARD);

        p_slide = hardwareMap.get(DcMotor.class, "p_slide");



        phookLeft = hardwareMap.get(Servo.class, "left_hook");
        phookLeft.resetDeviceConfigurationForOpMode();
        phookLeft.setDirection(Servo.Direction.FORWARD);
        //phook.s
        phookLeft.setPosition(0.45);

        phookRight = hardwareMap.get(Servo.class, "right_hook");
        phookRight.resetDeviceConfigurationForOpMode();
        phookRight.setDirection(Servo.Direction.FORWARD);
        //phook.s
        phookRight.setPosition(0.45);

        flap = hardwareMap.get(Servo.class, "p_flap");
        flap.resetDeviceConfigurationForOpMode();
        flap.setDirection(Servo.Direction.FORWARD);
        if (!isTeleOp) {
            flap.setPosition(1.0);
        }
        capPick = hardwareMap.get(Servo.class, "launch_capstone");
        capPick.resetDeviceConfigurationForOpMode();
        capPick.setDirection(Servo.Direction.FORWARD);
        if (isTeleOp) {
            capPick.setPosition(1.0);
        }
        //Initialize sensor
        digitalTouch = hardwareMap.get(DigitalChannel.class, "touch_sensor");
        digitalTouch.setMode(DigitalChannel.Mode.INPUT);
        digitalTouch.setState(false);

        //Initialize Color sensor
        ncolorSensor = hardwareMap.get(NormalizedColorSensor.class, "color_sensor");
        ncolorSensor.resetDeviceConfigurationForOpMode();

        //phook.s
 //       flap.setPosition(0.45);




         //flap = hardwareMap.get(Servo.class, "p_flap");
       // Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        //Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
       // Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

     //   Slide_R = hardwareMap.get(DcMotor.class, "slide_r");
       // Slide_L = hardwareMap.get(DcMotor.class, "slide_l");

       // pincher = hardwareMap.get(CRServo.class, "pincher");

        Motor_FL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Motor_BL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Motor_FR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        Motor_BR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BR_Hook.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BL_Hook.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
                sleep(100);
            } catch (Exception e1) {
            }

        }

    }


}

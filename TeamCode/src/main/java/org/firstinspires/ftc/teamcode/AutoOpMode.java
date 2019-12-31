package org.firstinspires.ftc.teamcode;


import android.util.Log;

import org.firstinspires.ftc.robotcore.external.Telemetry;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="AutoOpBlue", group="Linear Opmode")
public class AutoOpMode extends LinearOpMode {

    private ElapsedTime aRuntime = new ElapsedTime();

    @Override
    public void runOpMode() throws InterruptedException {
            telemetry.addData("Starting Autonomous", "Initialized");
            telemetry.update();
            telemetry.addData("HardwareMap", hardwareMap.size());
            telemetry.update();

        waitForStart();
        aRuntime.reset();
        Robot robot = new Robot(hardwareMap, telemetry);
        robot.moveBackward(12);
        robot.moveRight(34);
        robot.moveBackward(17);

        robot.engageHooks(72);
        robot.moveFlap();
        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        robot.moveForward(29);
        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        robot.engageHooks(-72);


        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }

        robot.moveLeft(34);
        robot.moveBackward(17);
        robot.moveRight(8);
        robot.moveForward(13);
        robot.moveLeft(24);
/*
        robot.engageSlider(2500);
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {

        }

        robot.moveFlap();

 */


        //  robot.moveFEnc(30);
        //robot.moveLEnc(30);

/*
        robot.moveRightHookToLatch();
        robot.moveLeftHookToLatch();
        robot.moveBackward(30);
        robot.moveRightHookToRelease();
        robot.moveLeftHookToRelease();

 */
       // robot.moveFlap();
/*
        try p
            Thread.sleep(2000);

        } catch (Exception ex) {
            telemetry.addData("sleep", "sleep");
            telemetry.update();
        }*/
       // robot.moveFEnc(60);
        //robot.moveHook90l();
       // robot.moveREnc(30);


           // telemetry.addData("SLEEP", "Autonomous Run Time: " + aRuntime.toString());
           // telemetry.update();


        //robot.moveF(10);

   }
}

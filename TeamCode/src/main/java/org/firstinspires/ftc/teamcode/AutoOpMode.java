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


@Autonomous(name="AutoOp", group="Linear Opmode")
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
        robot.moveF(10);
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            telemetry.addData("SLEEP", "Autonomous Run Time: " + aRuntime.toString());
            telemetry.update();
        }
        robot.moveF(10);
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            telemetry.addData("SLEEP", "Autonomous Run Time: " + aRuntime.toString());
            telemetry.update();
            /*robot.moveHook90(10);
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                telemetry.addData("SLEEP", "Hook Run Time: " + aRuntime.toString());
                telemetry.update();
            }
*/



        }
}}

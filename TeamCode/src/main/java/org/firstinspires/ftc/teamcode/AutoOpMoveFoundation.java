package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;
@Disabled


public class AutoOpMoveFoundation extends LinearOpMode {

    private static final double DRIVE_SPEED = 0.7;
    private static final double MOVE_FOUNDATION_SPEED = 0.5;

    static final double DRIVE_GEAR_REDUCTION = 0.705;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_MOTOR_REV = 1440;
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.14159);

    private ElapsedTime aRuntime = new ElapsedTime();

    Robot robot;
    String alliance = "Red";
    String direction = "";
    String direction_reverse = "";

    @Override
    public void runOpMode() {

        aRuntime.reset();
        Robot robot = new Robot(hardwareMap, telemetry);
        waitForStart();

        direction = (alliance == "Blue") ? "forward" : "backward";
        direction_reverse = (alliance == "Blue") ? "backward" : "forward";

        // ACTION 1:
        // Drive: Start moving to foundation
        encoderDrive(DRIVE_SPEED, "right", 16, 3.5);
        sleep(100);

        // ACTION 2:
        // Drive: Center on foundation
        encoderDrive(DRIVE_SPEED, direction, 11, 5);
        sleep(100);

        // ACTION 3:
        // Drive: Drive to foundation
        encoderDrive(DRIVE_SPEED, "right", 19.5, 6);
        sleep(250);

        // ACTION 4:
        // Lower foundation latch
       // robot.servoFoundation.setPosition(0.1);
        //sleep(500); // Delay long enough for latch to go down

        // ACTION 5:
        // Drive: Pull foundation to wall
        encoderDrive(MOVE_FOUNDATION_SPEED, "left", 45, 9);
        sleep(100);

        // ACTION 6:
        // Raise foundation latch
       // robot.servoFoundation.setPosition(0.75);
        //sleep(100);

        // ACTION 7:
        // Drive: Park on line under bridge
       // encoderDrive(DRIVE_SPEED, direction_reverse, 30, 5);
        //sleep(100);



        telemetry.addData("Autonomous Path", "Complete");
        telemetry.update();

        sleep(15000);   // Sleep to keep ramp up for most of Autonomous



    }

    public void encoderDrive(double speed, String direction, double inches, double timeout) {

        int newLeftFrontTarget;
        int newRightFrontTarget;
        int newLeftRearTarget;
        int newRightRearTarget;

        int lfDirection;
        int rfDirection;
        int lrDirection;
        int rrDirection;

        double cpiCompensation = 1;

        if (direction == "left") {
            lfDirection = 1;
            lrDirection = -1;
            rfDirection = -1;
            rrDirection = 1;
            cpiCompensation = 1.1;
        } else if (direction == "right") {
            lfDirection = -1;
            lrDirection = 1;
            rfDirection = 1;
            rrDirection = -1;
            cpiCompensation = 1.1;
        } else if (direction == "forward") {
            lfDirection = -1;
            lrDirection = -1;
            rfDirection = -1;
            rrDirection = -1;
        } else if (direction == "backward") {
            lfDirection = 1;
            lrDirection = 1;
            rfDirection = 1;
            rrDirection = 1;
        } else {
            lfDirection = 1;
            lrDirection = 1;
            rfDirection = 1;
            rrDirection = 1;
        }

        double CPI = COUNTS_PER_INCH * cpiCompensation;

        newLeftFrontTarget = robot.Motor_FL.getCurrentPosition() + (int) (inches * CPI * lfDirection);
        newRightFrontTarget = robot.Motor_FR.getCurrentPosition() + (int) (inches * CPI * rfDirection);
        newLeftRearTarget = robot.Motor_BL.getCurrentPosition() + (int) (inches * CPI * lrDirection);
        newRightRearTarget = robot.Motor_BR.getCurrentPosition() + (int) (inches * CPI * rrDirection);
        robot.Motor_FL.setTargetPosition(newLeftFrontTarget);
        robot.Motor_FR.setTargetPosition(newRightFrontTarget);
        robot.Motor_BL.setTargetPosition(newLeftRearTarget);
        robot.Motor_BR.setTargetPosition(newRightRearTarget);

        robot.Motor_FL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.Motor_FR.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.Motor_BL.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.Motor_BR.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //reset the timeout time
        aRuntime.reset();

        robot.Motor_FL.setPower(Math.abs(speed));
        robot.Motor_FR.setPower(Math.abs(speed));
        robot.Motor_BL.setPower(Math.abs(speed));
        robot.Motor_BR.setPower(Math.abs(speed));

        while (opModeIsActive() &&
                (aRuntime.seconds() < timeout) &&
                (robot.Motor_FL.isBusy() && robot.Motor_FR.isBusy() &&
                        robot.Motor_BL.isBusy() && robot.Motor_BR.isBusy())) {

            telemetry.addData("Path1", "Running to %7d :%7d", newLeftFrontTarget, newRightFrontTarget);
            telemetry.addData("Path2", "Running at %7d :%7d",
                    robot.Motor_FL.getCurrentPosition(),
                    robot.Motor_FL.getCurrentPosition());
            telemetry.addData("isBusy:", "lf: %3b  rf: %3b  lr: %3b  rr: %3b",
                    robot.Motor_BL.isBusy(), robot.Motor_FL.isBusy(),
                    robot.Motor_BR.isBusy(), robot.Motor_FR.isBusy());
            telemetry.addData("Timers: ", "Timeout: %4f, Timer: %4f", timeout, aRuntime.seconds());
            telemetry.update();

        }

        //stop all motion
        robot.Motor_FL.setPower(0);
        robot.Motor_FR.setPower(0);
        robot.Motor_BL.setPower(0);
        robot.Motor_BR.setPower(0);

        //Turn off RUN_TO_POSITION
        robot.Motor_FL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Motor_FR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Motor_BL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.Motor_BR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

}

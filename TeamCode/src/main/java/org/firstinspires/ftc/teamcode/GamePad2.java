package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

@TeleOp(name="FirstOpMode257", group="Linear Opmode")
public class FirstOpMode extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    static final double power =  1;
    private DcMotor MotorFl = null;
    private DcMotor MotorFr = null;
    private DcMotor MotorBl = null;
    private DcMotor MotorBr = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status1", "Initialized");
        telemetry.update();

        telemetry.addData("HardwareMap", hardwareMap.size());
        telemetry.update();


        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        //MotorFl = hardwareMap.dcMotor.get("Motor_FL");
        //MotorFr = hardwareMap.dcMotor.get("Motor_FR");
        // MotorBl = hardwareMap.dcMotor.get("Motor_BL");
        // MotorBr = hardwareMap.dcMotor.get("Motor_BR");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        // MotorFl.setDirection(DcMotor.Direction.FORWARD);
        // MotorFr.setDirection(DcMotor.Direction.FORWARD);
        // MotorBl.setDirection(DcMotor.Direction.FORWARD);
        // MotorBr.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            //  double leftPower = 1.0;
            // double rightPower = -1.0;

            // Choose to drive using either Tank Mode, or POV Mode
            // Comment out the method that's not used.  The default below is POV.

            // POV Mode uses left stick to go forward, and right stick to turn.
            // - This uses basic math to combine motions and is easier to drive straight.
            //double drive = -gamepad1.left_stick_y;
            //double turn  =  gamepad1.right_stick_x;
            //leftPower    = Range.clip(drive + turn, -1.0, 1.0) ;
            //rightPower   = Range.clip(drive - turn, -1.0, 1.0) ;

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.
            // leftPower  = -gamepad1.left_stick_y ;
            // rightPower = -gamepad1.right_stick_y ;

            // Send calculated power to wheels
            // MotorFl.setPower(leftPower);
            //MotorFr.setPower(rightPower);
            //MotorBl.setPower(leftPower);
            //MotorBr.setPower(rightPower);


            Robot robot = new Robot(hardwareMap, telemetry);
            robot.resetDcMotorsToUseNonEncode();
            // gamepad1 = new Gamepad();

            if (this.gamepad1.right_stick_y > 0.5) {
                telemetry.addData("Game pad 1Moving", "Backward");
                telemetry.update();
                // robot.moveRevMotor(1);
                robot.moveB(10, power);
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }


            // gamepad2 = new Gamepad();
           /* if (this.gamepad2.right_stick_y > 0.5) {
                telemetry.addData("Moving", "Backward");
                telemetry.update();
                robot.moveB(10, power);
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update(); */
            }

            if (this.gamepad1.right_stick_y < -0.5) {
                telemetry.addData("Moving", "Forward");
                telemetry.update();
                robot.moveF(10, power);
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }

            /*if (this.gamepad2.right_stick_y < -0.5) {
                telemetry.addData("Moving", "Forward");
                telemetry.update();
                robot.moveF(10, power);
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update(); */
            }

            if (this.gamepad1.right_stick_x > 0.5) {
                telemetry.addData("Moving", "Right");
                telemetry.update();
                robot.moveR(5, power);
                telemetry.addData("Moving Complete", "Right");
                telemetry.update();
            }

            /* if (this.gamepad2.right_stick_x > 0.5) {
                telemetry.addData("Moving", "Right");
                telemetry.update();
                robot.moveR(5, power);
                telemetry.addData("Moving Complete", "Right");
                telemetry.update(); */
            }

            if (this.gamepad1.right_stick_x < -0.5) {
                telemetry.addData("Moving", "Left");
                telemetry.update();
                robot.moveL(5, power);
                telemetry.addData("Moving Complete", "Left");
                telemetry.update();
            }

            /*if (this.gamepad2.right_stick_x < -0.5) {
                telemetry.addData("Moving", "Left");
                telemetry.update();
                robot.moveL(5, power);
                telemetry.addData("Moving Complete", "Left");
                telemetry.update();*/
            }

            if (this.gamepad1.left_stick_x < -0.5) {
                telemetry.addData("Moving", "clockwise rotation");
                telemetry.update();
                robot.rotateClockWise(100, power);
                telemetry.addData("Moving Complete", "clockwise rotation");
                telemetry.update();
            }

            if (this.gamepad1.left_stick_x > 0.5) {
                telemetry.addData("Moving", "anticlockwise rotation");
                telemetry.update();
                robot.rotateAntiClockWise(100, power);
                telemetry.addData("Moving Complete", "anticlockwise rotation");
                telemetry.update();
            }
            if (this.gamepad1.right_trigger > 0.1) {
                telemetry.addData("Moving", "engage flap");
                telemetry.update();
                robot.engageFlap();
                telemetry.addData("Moving Complete", "engage flap");
                telemetry.update();
            }
            if (this.gamepad1.left_trigger> 0.1) {
                telemetry.addData("Moving", "de-engage flap");
                telemetry.update();
                robot.disengageFlap();
                telemetry.addData("Moving Complete", "de-engage flap");
                telemetry.update();
            }
            if (this.gamepad1.right_bumper == TRUE) {
                telemetry.addData("Moving", "engage slider");
                telemetry.update();
                robot.engageSlider(2500);
                telemetry.addData("Moving Complete", "engage slider");
                telemetry.update();
            }
            if (this.gamepad1.left_bumper == TRUE) {
                telemetry.addData("Moving", "de-engage slider");
                telemetry.update();
                robot.engageSlider(-2500);
                telemetry.addData("Moving Complete", "de-engage slider");
                telemetry.update();
            }
            if (this.gamepad1.x == TRUE) {
                telemetry.addData("Moving", "engage  phooks");
                telemetry.update();
                robot.engageHooks(72);
                telemetry.addData("Moving Complete", "engage  phooks");
                telemetry.update();
            }
            if (this.gamepad1.b == TRUE) {
                telemetry.addData("Moving", "disengage  phooks");
                telemetry.update();
                robot.engageHooks(-72);
                telemetry.addData("Moving Complete", "disengage  phooks");
                telemetry.update();
            }
/*
            robot.moveF(1);
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                telemetry.addData("SLEEP", "Run Time: " + runtime.toString());
                telemetry.update();

               // break;
            }
            robot.moveR(1);
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                telemetry.addData("SLEEP R", "Run Time: " + runtime.toString());
                telemetry.update();

                // break;
            }
            robot.moveB(1);
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                telemetry.addData("SLEEP B", "Run Time: " + runtime.toString());
                telemetry.update();

                // break;
            }
            robot.moveL(1);
            try {
                Thread.sleep(10000);
            } catch (Exception ex) {
                telemetry.addData("SLEEP L", "Run Time: " + runtime.toString());
                telemetry.update();

                // break;
            }
*/

            // robot.moveR(10);
            // robot.moveB(10);
            //robot.moveL(10);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status3", "Run Time: " + runtime.toString());
            //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}
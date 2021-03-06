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

@TeleOp(name="TeleOpQLeapers", group="Linear Opmode")
public class FirstOpMode extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    boolean slideback = true;
    boolean sliderEngaged = false;
    boolean flapEngaged = false;
    static double power =  1;
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

        RobotTeleop robot = new RobotTeleop(hardwareMap, telemetry);
        robot.setTeleOp(true);
        robot.resetDcMotorsToUseNonEncode();
        robot.stopRobot();

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


            if(this.gamepad1.dpad_up){
                telemetry.addData("Game pad 1Power", "100%");
                telemetry.update();
                power = 1;
                telemetry.addData("Power Changed", "100%");
                telemetry.update();

            }
            if(this.gamepad1.dpad_down){
                telemetry.addData("Game pad 1Power", "10%");
                telemetry.update();
                power = 0.25;
                telemetry.addData("Power Changed", "10%");
                telemetry.update();

            }
            if(this.gamepad1.dpad_left){
                telemetry.addData("Game pad 1Power", "25%");
                telemetry.update();
                power = 0.5;
                telemetry.addData("Power Changed", "25%");
                telemetry.update();

            }
            if(this.gamepad1.dpad_right){
                telemetry.addData("Game pad 1Power", "50%");
                telemetry.update();
                power = 0.75;
                telemetry.addData("Power Changed", "50%");
                telemetry.update();

            }
            // gamepad1 = new Gamepad();

            if (this.gamepad1.right_stick_y > 0.5) {
                telemetry.addData("Game pad 1Moving", "Backward");
                telemetry.update();
                // robot.moveRevMotor(1);
                while (this.gamepad1.right_stick_y >= 0.5) {
                    robot.moveB(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }


            // gamepad2 = new Gamepad();

            if (this.gamepad1.right_stick_y < -0.5) {
                telemetry.addData("Moving", "Forward");
                telemetry.update();
                while (this.gamepad1.right_stick_y <= -0.5) {
                    robot.moveF(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }


            if (this.gamepad1.right_stick_x > 0.5) {
                telemetry.addData("Moving", "Right");
                telemetry.update();
                while(this.gamepad1.right_stick_x >= 0.5) {
                    robot.moveR(power);
                }
                robot.stopRobot();
                // robot.moveR(5, power);
                telemetry.addData("Moving Complete", "Right");
                telemetry.update();
            }


            if (this.gamepad1.right_stick_x < -0.5) {
                telemetry.addData("Moving", "Left");
                telemetry.update();
                while(this.gamepad1.right_stick_x <= -0.5) {
                    robot.moveL(power);
                }
                robot.stopRobot();
                // robot.moveL(5, power);
                telemetry.addData("Moving Complete", "Left");
                telemetry.update();
            }


            if (this.gamepad1.left_stick_x < -0.5) {
                telemetry.addData("Moving", "clockwise rotation");
                telemetry.update();
               while(this.gamepad1.left_stick_x <= -0.5) {
                   robot.rotateClockWise(power);
               }
               robot.stopRobot();
                telemetry.addData("Moving Complete", "clockwise rotation");
                telemetry.update();
            }

            if (this.gamepad1.left_stick_x > 0.5) {
                telemetry.addData("Moving", "anticlockwise rotation");
                telemetry.update();
                while(this.gamepad1.left_stick_x >= 0.5) {
                    robot.rotateAntiClockWise(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "anticlockwise rotation");
                telemetry.update();
            }

            if (this.gamepad1.right_stick_button) {
                telemetry.addData("Right stick button", "reset capstone pick");
                telemetry.update();
                robot.resetCapstone();
            }

            if (this.gamepad2.right_stick_button) {
                telemetry.addData("Right stick button", "reset capstone pick");
                telemetry.update();
                robot.resetCapstone();
            }

            if (this.gamepad1.right_trigger > 0.1 && sliderEngaged == TRUE) {
                telemetry.addData("Moving", "engage flap");
                telemetry.update();
                robot.engageFlap();
                flapEngaged = true;
                telemetry.addData("Moving Complete", "engage flap");
                telemetry.update();
            }

            if (this.gamepad1.left_trigger> 0.1) {
                telemetry.addData("Moving", "de-engage flap");
                telemetry.update();
                robot.disengageFlap();
                flapEngaged = false;
                telemetry.addData("Moving Complete", "de-engage flap");
                telemetry.update();
            }
            if (this.gamepad1.right_bumper == TRUE && slideback == TRUE) {
                telemetry.addData("Moving", "engage slider");
                telemetry.update();
                robot.engageSlider(2500);
                slideback = false;
                sliderEngaged = true;
                telemetry.addData("Moving Complete", "engage slider");
                telemetry.update();
            }
            if (this.gamepad1.left_bumper == TRUE && slideback == FALSE && flapEngaged == FALSE) {
                telemetry.addData("Moving", "de-engage slider");
                telemetry.update();
                robot.engageSlider(-2500);
                slideback = true;
                sliderEngaged = false;
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
            if (this.gamepad1.a == TRUE) {
                telemetry.addData("Moving", "engage  capstone");
                telemetry.update();
                robot.engageCapstone();
                telemetry.addData("Moving Complete", "engage  capstone");
                telemetry.update();
            }
            if (this.gamepad1.y == TRUE) {
                telemetry.addData("Moving", "disengage  capstone");
                telemetry.update();
                robot.disengageCapstone();
                telemetry.addData("Moving Complete", "disengage capstone");
                telemetry.update();
            }

            //GAMEPAD 2

            if(this.gamepad2.dpad_up){
                telemetry.addData("Game pad 2Power", "100%");
                telemetry.update();
                power = 1;
                telemetry.addData("Power Changed", "100%");
                telemetry.update();

            }
            if(this.gamepad2.dpad_down){
                telemetry.addData("Game pad 2Power", "10%");
                telemetry.update();
                power = 0.25;
                telemetry.addData("Power Changed", "10%");
                telemetry.update();

            }
            if(this.gamepad2.dpad_left){
                telemetry.addData("Game pad 2Power", "25%");
                telemetry.update();
                power = 0.5;
                telemetry.addData("Power Changed", "25%");
                telemetry.update();

            }
            if(this.gamepad2.dpad_right){
                telemetry.addData("Game pad 2Power", "50%");
                telemetry.update();
                power = 0.75;
                telemetry.addData("Power Changed", "50%");
                telemetry.update();

            }

            if (this.gamepad2.right_stick_y > 0.5) {
                telemetry.addData("Game pad 2Moving", "Backward");
                telemetry.update();
                // robot.moveRevMotor(1);
                while (this.gamepad2.right_stick_y >= 0.5) {
                    robot.moveB(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }


            if (this.gamepad2.right_stick_y < -0.5) {
                telemetry.addData("Moving", "Forward");
                telemetry.update();
                while (this.gamepad2.right_stick_y <= -0.5) {
                    robot.moveF(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Backward");
                telemetry.update();
            }


            if (this.gamepad2.right_stick_x > 0.5) {
                telemetry.addData("Moving", "Right");
                telemetry.update();
                while(this.gamepad2.right_stick_x >= 0.5) {
                    robot.moveR(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Right");
                telemetry.update();
            }


            if (this.gamepad2.right_stick_x < -0.5) {
                telemetry.addData("Moving", "Left");
                telemetry.update();
                while(this.gamepad2.right_stick_x <= -0.5) {
                    robot.moveL(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "Left");
                telemetry.update();
            }


            if (this.gamepad2.left_stick_x < -0.5) {
                telemetry.addData("Moving", "clockwise rotation");
                telemetry.update();
                while(this.gamepad2.left_stick_x <= -0.5) {
                    robot.rotateClockWise(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "clockwise rotation");
                telemetry.update();
            }

            if (this.gamepad2.left_stick_x > 0.5) {
                telemetry.addData("Moving", "anticlockwise rotation");
                telemetry.update();
                while(this.gamepad2.left_stick_x >= 0.5) {
                    robot.rotateAntiClockWise(power);
                }
                robot.stopRobot();
                telemetry.addData("Moving Complete", "anticlockwise rotation");
                telemetry.update();
            }
            if (this.gamepad2.right_trigger > 0.1 && sliderEngaged == TRUE) {
                telemetry.addData("Moving", "engage flap");
                telemetry.update();
                robot.engageFlap();
                flapEngaged = true;
                telemetry.addData("Moving Complete", "engage flap");
                telemetry.update();
            }

            if (this.gamepad2.left_trigger> 0.1) {
                telemetry.addData("Moving", "de-engage flap");
                telemetry.update();
                robot.disengageFlap();
                flapEngaged = false;
                telemetry.addData("Moving Complete", "de-engage flap");
                telemetry.update();
            }
            if (this.gamepad2.right_bumper == TRUE && slideback == TRUE) {
                telemetry.addData("Moving", "engage slider");
                telemetry.update();
                robot.engageSlider(2500);
                slideback = false;
                sliderEngaged = true;
                telemetry.addData("Moving Complete", "engage slider");
                telemetry.update();
            }
            if (this.gamepad2.left_bumper == TRUE && slideback == FALSE && flapEngaged == FALSE) {
                telemetry.addData("Moving", "de-engage slider");
                telemetry.update();
                robot.engageSlider(-2500);
                slideback = true;
                sliderEngaged = false;
                telemetry.addData("Moving Complete", "de-engage slider");
                telemetry.update();
            }
            if (this.gamepad2.x == TRUE) {
                telemetry.addData("Moving", "engage  phooks");
                telemetry.update();
                robot.engageHooks(72);
                telemetry.addData("Moving Complete", "engage  phooks");
                telemetry.update();
            }
            if (this.gamepad2.b == TRUE) {
                telemetry.addData("Moving", "disengage  phooks");
                telemetry.update();
                robot.engageHooks(-72);
                telemetry.addData("Moving Complete", "disengage  phooks");
                telemetry.update();
            }
            if (this.gamepad2.a == TRUE) {
                telemetry.addData("Moving", "engage capstone");
                telemetry.update();
                robot.engageCapstone();
                telemetry.addData("Moving Complete", "engage capstone");
                telemetry.update();
            }
            if (this.gamepad2.y == TRUE) {
                telemetry.addData("Moving", "disengage  capstone");
                telemetry.update();
                robot.disengageCapstone();
                telemetry.addData("Moving Complete", "disengage  capstone");
                telemetry.update();
            }

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status3", "Run Time: " + runtime.toString());
            //telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}

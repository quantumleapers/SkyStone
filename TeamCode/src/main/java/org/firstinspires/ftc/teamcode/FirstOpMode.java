package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="FirstOpMode233", group="Linear Opmode")
public class FirstOpMode extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor MotorFl = null;
    private DcMotor MotorFr = null;
    private DcMotor MotorBl = null;
    private DcMotor MotorBr = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status1", "Initialized");
        telemetry.update();

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        MotorFl = hardwareMap.dcMotor.get("Motor_FL");
        MotorFr = hardwareMap.dcMotor.get("Motor_FR");
        MotorBl = hardwareMap.dcMotor.get("Motor_BL");
        MotorBr = hardwareMap.dcMotor.get("Motor_BR");


        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        MotorFl.setDirection(DcMotor.Direction.FORWARD);
        MotorFr.setDirection(DcMotor.Direction.FORWARD);
        MotorBl.setDirection(DcMotor.Direction.FORWARD);
        MotorBr.setDirection(DcMotor.Direction.FORWARD);

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
            double leftPower = 1.0;
            double rightPower = -1.0;

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
            MotorFl.setPower(leftPower);
            MotorFr.setPower(rightPower);
            MotorBl.setPower(leftPower);
            MotorBr.setPower(rightPower);

            // Show the elapsed game time and wheel power.
            telemetry.addData("Status1", "Run Time: " + runtime.toString());
            telemetry.addData("Motors", "left (%.2f), right (%.2f)", leftPower, rightPower);
            telemetry.update();
        }
    }
}

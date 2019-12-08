package org.firstinspires.ftc.teamcode;
//Fix if detecting 2 or 0 minerals
//Give Power to Servo Motor holder
//Buttons to move latch and slide
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Gyroscope;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp
public class TeleopTest extends LinearOpMode{

    @Override
    public void runOpMode()  {
        org.firstinspires.ftc.teamcode.Robot robot = new org.firstinspires.ftc.teamcode.Robot (hardwareMap, telemetry);
        robot.isTeleOp = true;

        telemetry.addData ("Status", "Initialized"); //Displays "Status: Initialized"
        telemetry.update();
        //Driver must press INIT and then ▶️

        waitForStart();
        
        while (opModeIsActive()) {
            telemetry.addData("TeleOP", "New Code");
            telemetry.update();


            if (this.gamepad1.right_stick_y > 0.5) {
                telemetry.addData("Moving", "Backward");
                telemetry.update();
                robot.moveB(1);
            }

            if (this.gamepad1.right_stick_y < -0.5) {
                telemetry.addData("Moving", "Forward");
                telemetry.update();
                robot.moveF(1);
            }

            if (this.gamepad1.right_stick_x > 0.5) {
                telemetry.addData("Moving", "Right");
                telemetry.update();
                robot.moveR(1);
            }

            if (this.gamepad1.right_stick_x < -0.5) {
                telemetry.addData("Moving", "Left");
                telemetry.update();
            	robot.moveL(1);
        	}

        }
    }
}
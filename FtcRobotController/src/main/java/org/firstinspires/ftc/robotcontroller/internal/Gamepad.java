package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Forward", group="Linear Opmode")
//@Disabled
public class Gamepad extends LinearOpMode{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor MotorFl = null;
    private DcMotor MotorFr = null;
    private DcMotor MotorBl = null;
    private DcMotor MotorBr = null;

    DcMotor leftMotor;
    DcMotor rightMotor;
// If you want the robot to go backward, set the power to negative
    //Power range: -1 to 1
    double power = 0.5;

    @Override
    public void runOpMode() throws InterruptedException {



    }
}

package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


public class RobotTeleop extends Robot {

    public HardwareMap hardwareMap;
    public Telemetry telemetry;


    RobotTeleop(HardwareMap map, Telemetry tel) {
        super(map, tel);
        hardwareMap = map;
        telemetry = tel;
        //initDevices();
    }

    @Override
    public void moveB(double power) {
        telemetry.addData("Direction", "Backward");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(-1 * power);

    }
    @Override
    public void moveF(double power) {
        telemetry.addData("Direction", "Forward");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(power);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(power);

    }
    @Override
    public void moveL(double power) {

        Motor_FL.setPower(power);
        Motor_FR.setPower(power);
        Motor_BR.setPower((-1) * power);
        Motor_BL.setPower((-1) * power);

    }
    @Override
    public void moveR(double power) {

        Motor_FL.setPower((-1) * power);
        Motor_FR.setPower((-1) * power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(power);


    }
    //@Override
    public void rotateClockWise(double power) {
        telemetry.addData("Direction", "Clockwise");
        telemetry.update();
        Motor_FL.setPower(power);
        Motor_FR.setPower(power);
        Motor_BR.setPower(power);
        Motor_BL.setPower(power);
        long rotationFactor = 7;

    }
    public void rotateAntiClockWise(double power) {
        telemetry.addData("Direction", "AntiClockwise");
        telemetry.update();
        Motor_FL.setPower(-1 * power);
        Motor_FR.setPower(-1 * power);
        Motor_BR.setPower(-1 * power);
        Motor_BL.setPower(-1 * power);
        long rotationFactor = 7;

    }

    public void stopMotors(){
        Motor_BL.setPower(0);
        Motor_BR.setPower(0);
        Motor_FL.setPower(0);
        Motor_FR.setPower(0);
    }
}

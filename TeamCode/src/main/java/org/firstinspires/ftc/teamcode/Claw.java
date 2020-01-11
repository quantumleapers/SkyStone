package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;


public class Claw extends java.lang.Thread {
    public DcMotor p_slide;
    public Servo flap;
    public int EncoderTicks = 1440;
    public Telemetry telemetry;

    public void engageSlider(int EncoderTicks) {
        p_slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        p_slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        p_slide.setTargetPosition(EncoderTicks);
        p_slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        p_slide.setPower(1);

        while(p_slide.isBusy())
        {

        }
        StopRunning();
        p_slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void StopRunning(){
        p_slide.setPower(0);
    }

    public void moveFlap () throws InterruptedException {
        flap.setPosition(.97);

        sleep(500);

        flap.setPosition(.5);

        sleep(500);

        flap.setPosition(.97);


    }
    public void retractSlider (int EncoderTicks){
        p_slide.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        p_slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        p_slide.setTargetPosition(EncoderTicks);
        p_slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        p_slide.setPower(-1);

        while (p_slide.isBusy()){

        }
        StopRunning();
        p_slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

}




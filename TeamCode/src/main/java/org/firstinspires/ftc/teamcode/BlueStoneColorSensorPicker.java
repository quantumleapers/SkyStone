package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="BlueSensorPicker", group="Linear Opmode")
public class BlueStoneColorSensorPicker extends LinearOpMode {

    private static final double power = 1;
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
/*
        if (true) {
            robot.enableLight();
            telemetry.addData("Starting Autonomous", robot.detectSkyStone());
            telemetry.update();
            sleep(5000);

            robot.disableLight();
            return;
        }
 */
        robot.disengageFlap();
        robot.engageSlider(2500);
        robot.moveF(31, power);
        robot.moveL(54, power);
        //robot.moveF(28, power);
        robot.moveF(33, power);
        if (robot.detectSkyStone()) {
            // confirmed 1st stone is a skystone
            robot.moveF(40, .25);
            robot.engageFlap();
          //  robot.moveB(15, power);
            robot.moveB(23, power);
            robot.moveL(132, power);
            robot.disengageFlap();

            //robot.moveR(147, power);
            robot.moveR(202, power); /* move to 4th stone */
            // robot.moveF(14, power);
            robot.moveF(18, power);
            robot.moveF(40, .25);
            robot.engageFlap();
            robot.moveB(18, power);
            //robot.moveL(222, power);
            robot.moveL(190, power);
            robot.disengageFlap();
        }
        else {
             robot.moveR(26, power);
             if (robot.detectSkyStone()) {
                 robot.moveF(40, .25);
                 robot.engageFlap();
                 robot.moveB(23, power); //15
                 robot.moveL(162, power);
                 robot.disengageFlap();
 
                 robot.moveR(230, power);
                 robot.moveF(18, power); //14
                 robot.moveF(40, .25);
                 robot.engageFlap();
                 robot.moveB(18, power);
                 robot.moveL(222, power);
                 robot.disengageFlap();
             } else {
                 robot.moveR(24, power);
                 robot.moveF(40, .25);
                 robot.engageFlap();
                 robot.moveB(23, power);
                 robot.moveL(172, power);
                 robot.disengageFlap();
                 robot.moveR(230, power);
                 robot.moveF(18, power); //14
                 robot.moveF(40, .25);
                 robot.engageFlap();
                 robot.moveB(20, power);
                 robot.moveL(222, power);
                 robot.disengageFlap();
                 robot.moveR(35, power);
             }
        }
 
        /*
        robot.moveR(183, power);
        robot.moveF(14, power);
        robot.moveF(35, .25);
        robot.engageFlap();
        robot.moveB(14, power);
        robot.moveL(144, power);
        robot.disengageFlap();
         */


        robot.engageSlider(-2500);
        robot.moveR(50, power);
        robot.moveF(12, power);


    }
}

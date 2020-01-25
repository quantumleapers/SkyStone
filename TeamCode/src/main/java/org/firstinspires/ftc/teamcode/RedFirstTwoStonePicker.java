package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="RedFirstTwoStonePicker", group="Linear Opmode")
public class RedFirstTwoStonePicker extends LinearOpMode {

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
        robot.disengageFlap();
        robot.engageSlider(2500);
        robot.moveF(27, power);
        robot.moveR(23, power);
        robot.moveF(32, power);
        robot.moveF(40, .25);
        robot.engageFlap();
        robot.moveB(20, power);
        robot.moveR(138, power);
        robot.disengageFlap();
        //robot.engageSlider(-2500);

        //robot.moveR(60, power);
        robot.rotateAntiClockWise(10, 0.5);
        // added additional move back to not hit the bridge stand - 1/25
        robot.moveB(4, power);
        robot.moveL(152, power);
        // changing move forward from 18 to 21 to account for the above additional move back - 1/25
        robot.moveF(22, power);
        robot.moveF(35, .25);
        robot.engageFlap();
        robot.rotateAntiClockWise(10, 0.5);
        robot.moveB(20, power);
        // reducing amount going back from 164 to 162 to not use space of alliance robot 1/25
        robot.moveR(162, power);
        robot.disengageFlap();
        robot.engageSlider(-2500);
        // added additional rotate to make it straighter 1/25
        robot.rotateAntiClockWise(6, 0.5);

        robot.moveL(54, power);
        robot.moveF(18, power);

        /*
        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        robot.moveF(82, power);
        robot.rotateClockWise(30, 0.5);
        robot.engageHooks(-72);
        //  robot.moveF(55, 0.2);

        try {
            Thread.sleep(500);
        } catch (Exception ex) {

        }
        robot.moveL(52, power);
        robot.rotateAntiClockWise(30, 0.5);
        robot.moveF(100, 0.2);
        robot.moveL(78, power);
        // robot.moveB(36, power);
        //robot.moveR(45, 0.5);
        //robot.moveF(35, power);
        //robot.moveF(50, 0.2);
        //robot.moveL(80, power);
        robot.moveF(100, 0.2);
        //  robot.moveB(4, power);
        // robot.moveL(50, power);


/*
        robot.engageSlider(2500);
        try {
            Thread.sleep(5000);
        } catch (Exception ex) {

        }

        robot.moveFlap();

 */


        //  robot.moveFEnc(30);
        //robot.moveLEnc(30);

/*
        robot.moveRightHookToLatch();
        robot.moveLeftHookToLatch();
        robot.moveBackward(30);
        robot.moveRightHookToRelease();
        robot.moveLeftHookToRelease();

 */
        // robot.moveFlap();
/*
        try p
            Thread.sleep(2000);

        } catch (Exception ex) {
            telemetry.addData("sleep", "sleep");
            telemetry.update();
        }*/
        // robot.moveFEnc(60);
        //robot.moveHook90l();
        // robot.moveREnc(30);


        // telemetry.addData("SLEEP", "Autonomous Run Time: " + aRuntime.toString());
        // telemetry.update();


        //robot.moveF(10);

    }
}
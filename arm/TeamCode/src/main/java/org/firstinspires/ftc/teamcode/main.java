package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.subsystems.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.Wheels;
import org.firstinspires.ftc.teamcode.subsystems.RobotArm;


@TeleOp
public class main extends OpMode {
    public main() {}

    //Timers for Debug classes
    private ElapsedTime timerDrive = new ElapsedTime();
    private ElapsedTime timerArm = new ElapsedTime();

    //A value that changes the resulting data form encoders to be in degrees


    //Instantiates the RobotMap class and set it to a local variable
    private RobotMap robot = new RobotMap();

    //Instantiates the Wheels class and sets it to a local variable
    private Wheels tank = null;

    //instantiates the Arm class and sets it to local variable
    private RobotArm arm = null;


    //Initiates robot map and any robot-related
    // variables not located in the robot map
    public void init(){
        robot.init(hardwareMap);
        tank = new Wheels(robot.frontLftWheel, robot.frontRhtWheel,
                robot.backLftWheel, robot.backRhtWheel);


        arm = new RobotArm(robot.clawLeft, robot.clawRight,
                robot.armJointServo, RobotMap.baseMotor);

    }

    //After start button pressed, do this
    public void start(){
        timerDrive.reset();
        timerArm.reset();
    }

    //Controls any actions performed by robot after start is pressed
    public void loop() {
        timerDrive.reset();
        timerArm.reset();
        double DRIVE_SPEED = 0.5;
        int position = RobotMap.baseMotor.getCurrentPosition();
        telemetry.addData("Encoder Position",
                            position + 360 / 1680);

        //Controller variables for ease of programming
        //Sets controls to a variable and clips their ranges
        //double leftStickY1, leftStickX1;
        boolean buttonX = gamepad1.x;
        boolean buttonY = gamepad1.y;
        //boolean leftClick1 = gamepad1.left_stick_button;
        //boolean rightClick1 = gamepad1.right_stick_button;
        boolean buttonA = gamepad1.a;
        boolean buttonB = gamepad1.b;
        boolean leftBump1 = gamepad1.left_bumper;
        boolean rightBump1 = gamepad1.right_bumper;
        boolean dpadUp1 = gamepad1.dpad_up;
        boolean dpadDown1 = gamepad1.dpad_down;
        boolean dpadLeft1 = gamepad1.dpad_left;
        boolean dpadRight1 = gamepad1.dpad_right;
        double lTrigger, rTrigger;
        lTrigger = Range.clip(gamepad1.left_trigger, 0, 0.8);
        rTrigger = Range.clip(gamepad1.right_trigger, 0, 0.8);


        //Action that drives the robot
        if (dpadUp1) {
            tank.drive(-DRIVE_SPEED, -DRIVE_SPEED, DRIVE_SPEED, DRIVE_SPEED);
        }
        if (dpadDown1) {
            tank.drive(DRIVE_SPEED, DRIVE_SPEED, -DRIVE_SPEED, -DRIVE_SPEED);
        }
        if (dpadLeft1) {
            tank.drive(DRIVE_SPEED, -DRIVE_SPEED, DRIVE_SPEED, -DRIVE_SPEED);
        }
        if (dpadRight1) {
            tank.drive(-DRIVE_SPEED, DRIVE_SPEED, -DRIVE_SPEED, DRIVE_SPEED);
        }

        //Turn Left
        if (leftBump1) {
            tank.drive(-DRIVE_SPEED, -DRIVE_SPEED, -DRIVE_SPEED, -DRIVE_SPEED);
        }
        //Turn Right
        if (rightBump1) {
            tank.drive(DRIVE_SPEED, DRIVE_SPEED, DRIVE_SPEED, DRIVE_SPEED);
        }

        if (!dpadUp1 && !dpadDown1 && !dpadLeft1 &&
                !dpadRight1 && !leftBump1 && !rightBump1) {
            tank.drive(0, 0,
                    0, 0);
        }


        //Arm Base
        if (lTrigger > 0.05) {
            RobotMap.baseMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            arm.armBase(-lTrigger / 2);
        }
        if (rTrigger > 0.05){
            RobotMap.baseMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            arm.armBase(rTrigger / 2);
        }
        if (rTrigger < 0.01 && lTrigger < 0){
            RobotMap.baseMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            RobotMap.baseMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            RobotMap.baseMotor.getCurrentPosition();
            RobotMap.baseMotor.setTargetPosition(0);
            telemetry.addLine("Arm stopped");
        }

        //Joint
            //Joint up
        if(buttonA){
            arm.joint(-0.3);
        }
            //Joint down
        if(buttonB){
            arm.joint(0.3);
        }

        //Claw
            //Open
        if(buttonY){
            arm.claw(-0.3);
        }
        if(buttonX){
            arm.claw(0.6);
        }


    }


    //Stops robot when finished or disabled.
    public void stop(){}
}
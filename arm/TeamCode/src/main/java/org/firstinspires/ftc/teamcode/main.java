package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.RobotMap;
import org.firstinspires.ftc.teamcode.subsystems.Wheels;
import org.firstinspires.ftc.teamcode.subsystems.RobotArm;


@TeleOp
public class main extends OpMode {
    public main() {}


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
        arm = new RobotArm(robot.servoClaw, robot.armJointServo);
    }

    //After start button pressed, do this
    public void start(){

    }

    //Controls any actions performed by robot after start is pressed
    public void loop() {

        double DRIVE_SPEED = 0.3;

        //Controller variables for ease of programming
        boolean select = gamepad1.back;

        boolean left_click = gamepad1.left_stick_button;
        boolean right_click = gamepad1.right_stick_button;

        boolean buttonA = gamepad1.a;
        boolean buttonB = gamepad1.b;
        boolean buttonX = gamepad1.x;
        boolean buttonY = gamepad1.y;

        boolean leftBump1 = gamepad1.left_bumper;
        boolean rightBump1 = gamepad1.right_bumper;

        boolean dpadUp1 = gamepad1.dpad_up;
        boolean dpadDown1 = gamepad1.dpad_down;
        boolean dpadLeft1 = gamepad1.dpad_left;
        boolean dpadRight1 = gamepad1.dpad_right;

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
            tank.drive(-DRIVE_SPEED/2, -DRIVE_SPEED/2,
                    -DRIVE_SPEED/2, -DRIVE_SPEED/2);
        }
        //Turn Right
        if (rightBump1) {
            tank.drive(DRIVE_SPEED/2, DRIVE_SPEED/2,
                    DRIVE_SPEED/2, DRIVE_SPEED/2);
        }

        if (!dpadUp1 && !dpadDown1 && !dpadLeft1 &&
                !dpadRight1 && !leftBump1 && !rightBump1) {
            tank.drive(0, 0,
                    0, 0);
        }

        //Joint
            //Joint up
        if(buttonY){
            arm.joint(-0.7);
        }
            //Joint down
        if(buttonX){
            arm.joint(0.25);
        }



        //Claw
            //Open
        if(buttonA){
            arm.claw(-0.3);
        }
        if(buttonB){
            arm.claw(0.8);
        }


    }


    //Stops robot when finished or disabled.
    public void stop(){}
}
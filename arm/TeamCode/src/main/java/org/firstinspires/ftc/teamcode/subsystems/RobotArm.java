package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//import org.firstinspires.ftc.teamcode.main;

public class RobotArm {
    private Servo leftClaw, rightClaw, servoJoint = null;
    private DcMotor base = null;
    //static private final int ENCODER_DEGREE = (360/1680);
    //private main source = new main();


    public RobotArm(Servo leftClaw, Servo rightClaw,
                    Servo servoJoint, DcMotor base){
        this.leftClaw = leftClaw;
        this.rightClaw = rightClaw;
        this.servoJoint = servoJoint;
        this.base = base;
    }

    //Controls the claw
        //To use, put in "if" statement.
    public void claw(double clawAngle){
        leftClaw.setPosition(clawAngle);
        rightClaw.setPosition(clawAngle);
    }

    public void armBase(double baseSpeed){
        this.base.setPower(baseSpeed);
    }

    public void joint(double jointAngle){
        this.servoJoint.setPosition(jointAngle);
    }
}
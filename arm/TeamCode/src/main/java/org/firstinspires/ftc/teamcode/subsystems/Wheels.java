package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

public class Wheels {
    private DcMotor motorFrontLeft, motorFrontRight,
            motorBackLeft, motorBackRight = null;

    public Wheels(DcMotor motorFrontLeft, DcMotor motorFrontRight,
                  DcMotor motorBackLeft, DcMotor motorBackRight) {
        this.motorFrontLeft = motorFrontLeft;
        this.motorBackLeft = motorBackLeft;
        this.motorFrontRight = motorFrontRight;
        this.motorBackRight = motorBackRight;
    }

    public void drive(double leftFrontWheel, double leftBackWheel,
                      double rightFrontWheel, double rightBackWheel) {

        //Set left Wheels to one variable
        motorFrontLeft.setPower(leftFrontWheel);
        motorBackLeft.setPower(leftBackWheel);

        //Set right Wheels to one variable
        motorFrontRight.setPower(rightFrontWheel);
        motorBackRight.setPower(rightBackWheel);
    }
}
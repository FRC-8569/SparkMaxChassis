//Libraries url
//https://software-metadata.revrobotics.com/REVLib-2023.json
//https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix5-frc2023-latest.json

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Robot extends TimedRobot {

  private MotorControllerGroup right;
  private MotorControllerGroup left;
  private DifferentialDrive drive;
  private Joystick joystick;
  private CANSparkMax motor1;
  private CANSparkMax motor2;
  private CANSparkMax motor3;
  private CANSparkMax motor4;

  @Override
  public void robotInit() {
    motor1 = new CANSparkMax(1, MotorType.kBrushed);
    motor2 = new CANSparkMax(2, MotorType.kBrushed);
    motor3 = new CANSparkMax(3, MotorType.kBrushed);
    motor4 = new CANSparkMax(4, MotorType.kBrushed);

    left = new MotorControllerGroup(motor1, motor2);
    right = new MotorControllerGroup(motor3, motor4);

    drive = new DifferentialDrive(left, right);
    joystick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    double turnSpeed = 0.5 * joystick.getRawAxis(0);
    double driveSpeed = 0.7 * joystick.getRawAxis(5);

    drive.arcadeDrive(turnSpeed, driveSpeed);
  }
}
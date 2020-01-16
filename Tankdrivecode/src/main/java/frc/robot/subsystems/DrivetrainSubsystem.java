/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;




public class DrivetrainSubsystem extends SubsystemBase {
  private static final int frontleftmotorPORT= 1;
  private static final int backleftmotorPORT= 2;
  private static final int frontrightmotorPORT = 14;
  private static final int backrightmotorPORT = 15;
  

  private CANSparkMax frontleftmotor;
  private CANSparkMax backleftmotor;
  
  private CANSparkMax frontrightmotor;
  private CANSparkMax backrightmotor;

  private double powerratio;
  private Joystick joystick;

  private final DifferentialDrive Drivetrain;
  
  

  
  /**
   * Creates a new ExampleSubsystem.
   */
  public DrivetrainSubsystem() {
    super();
    frontleftmotor = new CANSparkMax(frontleftmotorPORT, MotorType.kBrushless); 
    backleftmotor = new CANSparkMax(backleftmotorPORT, MotorType.kBrushless);
    frontrightmotor = new CANSparkMax(frontrightmotorPORT, MotorType.kBrushless);
    backrightmotor = new CANSparkMax(backrightmotorPORT, MotorType.kBrushless);

    backleftmotor.follow(frontleftmotor);
    backrightmotor.follow(frontrightmotor);

    Drivetrain = new DifferentialDrive (frontleftmotor, frontrightmotor);


  }
  
  

  public void drive() {
    Drivetrain.arcadeDrive(joystick.getY(), joystick.getX());
  }
  @Override
  public void periodic() {
   
  }
}

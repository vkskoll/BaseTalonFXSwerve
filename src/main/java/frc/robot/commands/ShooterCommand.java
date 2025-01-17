// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends Command {
  /** Creates a new ShooterCommand. */
  private final ShooterSubsystem shooterSubsystem;
  private double topShooterVolts;
  private double bottomShooterVolts;
  public ShooterCommand(ShooterSubsystem shooterSubsystem, double topShooterVolts, double bottomShooterVolts) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    this.topShooterVolts = topShooterVolts;
    this.bottomShooterVolts = bottomShooterVolts;

    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("ShooterCMD Started");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    shooterSubsystem.setShooterSpeed(topShooterVolts, bottomShooterVolts);
    shooterSubsystem.getShooterVelocity();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setShooterSpeed(0, 0);
    System.out.println("ShooterCMD Stopped");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

package frc.robot.commands;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.subsystems.XRPDrivetrain;

public class Auton extends Command{
  private final XRPDrivetrain m_XRPDrivetrain;
  private AnalogInput m_leftSensor;
  private AnalogInput m_rightSensor;

  public Auton(XRPDrivetrain XRPDrivetrain) {
    m_XRPDrivetrain = XRPDrivetrain;
    m_leftSensor = new AnalogInput(0);
    m_rightSensor = new AnalogInput(2);
    addRequirements(XRPDrivetrain);
  }

    public void initialize() {
      System.out.println("Auton start");
      //Work in Process
      Commands.sequence(
        Commands.race(
          Commands.run(() -> m_XRPDrivetrain.arcadeDrive(1, 0.5), m_XRPDrivetrain),
          Commands.waitSeconds(3)
        )
        ).schedule();

    }
}